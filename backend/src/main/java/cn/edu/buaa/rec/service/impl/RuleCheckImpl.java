package cn.edu.buaa.rec.service.impl;

import cn.edu.buaa.rec.dao.BusinessMapper;
import cn.edu.buaa.rec.dao.UsecaseMapper;
import cn.edu.buaa.rec.model.AlternativeFlow;
import cn.edu.buaa.rec.model.BasicFlow;
import cn.edu.buaa.rec.model.Business;
import cn.edu.buaa.rec.model.Flow;
import cn.edu.buaa.rec.model.RucmModel;
import cn.edu.buaa.rec.service.RuleCheckService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.text.StyledEditorKit;

/**
 * Created by menghan on 2018/2/27.
 */
@Service("RuleCheckService")
public class RuleCheckImpl implements RuleCheckService {

    @Autowired
    private UsecaseMapper usecaseMapper;

    @Autowired
    private BusinessMapper businessMapper;

    public Map<String,Object> ruleCheckGlobal(Long businessId){
        Boolean flag = true;
        Map<String,Object> map = new HashMap<>();
        Business business = businessMapper.selectBusiness(businessId);
        List<Long> useCasesId = usecaseMapper.selectUseCases(businessId);
        List<String> rucmSpecs = new ArrayList<>();
        List<RucmModel> rucmModels = new ArrayList<>();
        for(Long id:useCasesId){
            String rucmSpec = usecaseMapper.selectRucmSpecByUseCase(id);
            rucmSpecs.add(rucmSpec);
        }
        String preCondition = business.getPreCondition();
        String postCondition = business.getPostCondition();
        if(rucmModels.size()>0) {
            String useCaseBeginPre = rucmModels.get(0).getPreCondition();
            String useCaseEndPost = rucmModels.get(rucmModels.size()-1).getBasicFlow().getPostCondition();
            if(preCondition==null||useCaseBeginPre==null){
                flag = false;
                map.put("result","业务-"+business.getId()+"没有输入\n");
            }
            if(postCondition==null||useCaseEndPost==null){
                flag = false;
                String errorInfo = "业务-"+business.getId()+"没有输出\n";
                if(map.get("result")!=null){
                    String str = (String)map.get("result");
                    str+= errorInfo;
                    map.put("result",str);
                }
                else map.put("result",errorInfo);
            }
            else{
                if(!preCondition.equals(useCaseBeginPre)){
                    flag = false;
                    String errorInfo = "业务-"+business.getId()+"的输入存在不一致\n";
                    if(map.get("result")!=null){
                        String str = (String)map.get("result");
                        str+= errorInfo;
                        map.put("result",str);
                    }
                    else map.put("result",errorInfo);
                }
                if(!postCondition.equals(useCaseEndPost)){
                    flag = false;
                    String errorInfo = "业务-"+business.getId()+"的输出存在不一致\n";
                    if(map.get("result")!=null){
                        String str = (String)map.get("result");
                        str+= errorInfo;
                        map.put("result",str);
                    }
                    else map.put("result",errorInfo);
                }
            }
            for (int i = 0; i < rucmModels.size()-1; i++) {
                String preUseCasePost = rucmModels.get(i).getBasicFlow().getPostCondition();
                String postUseCasePre = rucmModels.get(i+1).getPreCondition();
                if(!preUseCasePost.equals(postUseCasePre)){
                    flag = false;
                    String errorInfo = "业务-"+business.getId()+"中的用例"+(i+1)+"的输出和用例"+(i+2)+"的输入不一致";
                    if(map.get("result")!=null){
                        String str = (String)map.get("result");
                        str+= errorInfo;
                        map.put("result",str);
                    }
                    else map.put("result",errorInfo);
                }
            }
        }else{
            flag = false;
            map.put("result","业务-"+business.getId()+"没有用例\n");
        }
        map.put("status",flag?0:1);
        return map;
    }
    public String ruleCheckResult(String rucmModel){
        RucmModel rucmModelM = new RucmModel(rucmModel);
        return checkResult(rucmModelM);
    }
    public String checkResult(RucmModel rucmModel ){
        //transfer rucmModel to object
        StringBuilder sb = new StringBuilder();
        RucmModel model = rucmModel;
        //rule1
        Map<String,Object> rule1Map = rule1Check(model);
        if((Integer)rule1Map.get("status")==1)
            sb.append(rule1Map.get("result"));
        //rule3
        Map<String,Object> rule3Map = rule3Check(model);
        if((Integer)rule3Map.get("status")==1)
            sb.append(rule3Map.get("result"));
        //rule7
        Map<String,Object> rule7Map = rule7Check(model);
        if((Integer)rule7Map.get("status")==1)
            sb.append(rule7Map.get("result"));
        return sb.toString();
    }

    @Override
    public Map<String, Object> rule1Check(RucmModel content) {
        Map<String,Object> map = new HashMap<>();
        if(content.getBasicFlow().getPostCondition()==null||content.getBasicFlow().getPostCondition().length()==0){
            map.put("status",1);
            map.put("result","BasicFLow触发了规则1：控制流必须有起始和退出节点\n");
        }
        for(int i = 1;i <= content.getAlternativeFlows().size();i++ ){
            if(content.getAlternativeFlows().get(i-1).getPostCondition()==null||content.getAlternativeFlows().get(i-1).getPostCondition().length()==0){
                map.put("status",1);
                String errorInfo="AlternativeFLow-"+i+"触发了规则1：控制流必须有后置条件\n";
                if(map.get("result")!=null){
                    String str = (String)map.get("result");
                    str+= errorInfo;
                    map.put("result",str);
                }else map.put("result",errorInfo);
            }
        }
        if(map.get("status")==null) map.put("status",0);
        return map;
    }

    @Override
    public Map<String, Object> rule3Check(RucmModel rucmModel) {
        Map<String,Object> map = new HashMap<>();
        BasicFlow basicFlow= rucmModel.getBasicFlow();
        List<String> steps = basicFlow.getSteps();
        for(int i = 1;i<=steps.size();i++){
            if(steps.get(i-1).contains("VALIDATE THAT")){
                int j = 0;
                for(;j<rucmModel.getAlternativeFlows().size();j++){
                    String rfs = rucmModel.getAlternativeFlows().get(j).getRfs();
                    if(isNumeric(rfs)&&Integer.parseInt(rfs)==i) break;
                }
                if(j==rucmModel.getAlternativeFlows().size()||rucmModel.getAlternativeFlows().size()==0){
                    map.put("status",1);
                    String errorInfo = "BasicFlow-步骤"+i+"触发了规则3：没有对应的分支节点\n";
                    if(map.get("result")!=null){
                        String str = (String)map.get("result");
                        str+= errorInfo;
                        map.put("result",str);
                    }else map.put("result",errorInfo);
                }

            }
        }
        if(map.get("status")==null) map.put("status",0);
        return map;
    }

    @Override
    public Map<String, Object> rule6Check(String content) {
        return null;
    }

    @Override
    public Map<String, Object> rule7Check(RucmModel rucmModel) {
        Map<String,Object> map = new HashMap<>();
        BasicFlow basicFlow= rucmModel.getBasicFlow();
        List<String> steps = basicFlow.getSteps();
        for(int i=1;i<=steps.size();i++){
            String step = steps.get(i-1);
            if(step.contains("ACTION")){
                String errorInfo = "BasicFlow-步骤"+i+"触发了规则7：动作节点的操作和对象不为空\n";
                if(!step.contains("OP")){
                    map.put("status",1);
                    if(map.get("result")!=null){
                        String str = (String)map.get("result");
                        str+= errorInfo;
                        map.put("result",str);
                    }else map.put("result",errorInfo);
                }
                else{
                    String operation = step.substring(step.indexOf("ACTION")+6,step.indexOf("OP")+2).trim();
                    String object = step.substring(step.indexOf("OP")+2).trim();
                    if(operation.length()==0||object.length()==0){
                        map.put("status",1);
                        if(map.get("result")!=null){
                            String str = (String)map.get("result");
                            str+= errorInfo;
                            map.put("result",str);
                        }else map.put("result",errorInfo);
                    }
                }
            }
        }
        if(map.get("status")==null) map.put("status",0);
        return map;
    }

    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
