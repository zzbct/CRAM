package cn.edu.buaa.rec.controller;

import cn.edu.buaa.rec.model.*;
import cn.edu.buaa.rec.service.MailService;
import cn.edu.buaa.rec.service.ProjectService;
import cn.edu.buaa.rec.service.BusinessRoleDataService;
import cn.edu.buaa.rec.service.UsecaseRoleDataService;
import cn.edu.buaa.rec.service.UserProjectRoleService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: suruo
 * @Email: csuruo@gmail.com
 * @Date: Created on 下午8:44 2018/02/06
 * @Modified by:
 */

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    @Qualifier("ProjectService")
    private ProjectService projectService;

    @Autowired
    @Qualifier("UserProjectRoleService")
    private UserProjectRoleService userProjectRoleService;

    @Autowired
    @Qualifier("BusinessRoleDataService")
    private BusinessRoleDataService businessRoleDataService;

    @Autowired
    @Qualifier("UsecaseRoleDataService")
    private UsecaseRoleDataService usecaseRoleDataService;

    @Autowired
    @Qualifier("MailService")
    private MailService mailService;


    //项目中心，暂时默认显示场景
    @RequestMapping("/home")
    @ResponseBody
    public Map<String, Object> ProjectHomePage(@Valid @RequestBody Map<String, Object> info) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(info);
        Long projectId = jsonObject.getLong("ProjectId");
        Long userId = jsonObject.getLong("UserId");
        List<Long> roleIds = userProjectRoleService.getUserRoleId(projectId, userId);
        System.out.println(roleIds.toString());
        if (roleIds == null && roleIds.size() == 0) {
            return null;
        }
        Map<String, Object> result = new HashMap<>();
        List<BusinessRoleData> businessRoleData = businessRoleDataService.getBusinessRoleDataByRoleIds(roleIds);
        List<Map<String, Object>> businessForms = new LinkedList<>();
        if (businessRoleData != null) {
            businessForms = businessRoleDataService.getBusinessForm(businessRoleData);
        }
        result.put("businessForms", businessForms);
        List<UsecaseRoleData> usecaseRoleData = usecaseRoleDataService.getUsecaseRoleDataByRoleIds(roleIds);
        List<Map<String, Object>> usecaseForms = new LinkedList<>();
        if (usecaseRoleData != null) {
            usecaseForms = usecaseRoleDataService.getUsecaseForm(usecaseRoleData);
        }
        result.put("usecaseForms", usecaseForms);
        return result;
    }

    //    申请角色
    @RequestMapping("/roleapply")
    @ResponseBody
    public Map<String, Object> applyRole(@Valid @RequestBody Map<String, Object> applyRoleInfo) {
        return projectService.applyRole(applyRoleInfo);
    }

    //  申请管理员
    @RequestMapping("/manapply")
    @ResponseBody
    public Map<String, Object> applyManager(@Valid @RequestBody Map<String, Object> applyManagerInfo) {
        return projectService.applyManager(applyManagerInfo);
    }

    @RequestMapping("/scenes")
    @ResponseBody
    public List<Map<String, Object>> showScenes(@Valid @RequestBody String projectName) {
//        return projectService.getScenes(projectName);
//        关系改变，重新写
        return null;
    }

    //    显示项目中心的角色项
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showRole(@Valid @RequestBody Map<String, Object> info) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(info);

        Long projectId = jsonObject.getLong("ProjectId");
        Long userId = jsonObject.getLong("UserId");
        Map<String, Object> m = new HashMap<String, Object>();

        List<Role> roles = projectService.getRole(projectId);
        List<Long> roleIds = userProjectRoleService.getUserRoleId(projectId, userId);
        List<Role> userRoles = new LinkedList<Role>();
        List<Role> listRoles = new LinkedList<Role>();
        for (Role r : roles) {
            Boolean flag = false;
            for (Long id : roleIds) {
                if (id == r.getId()) {
                    userRoles.add(r);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                listRoles.add(r);
            }
        }
        m.put("listRoles", listRoles);
        m.put("userRoles", userRoles);
        return m;
    }

    //    项目中心的数据展示接口
    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showData(@Valid @RequestBody Map<String, Object> info) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(info);
        Long projectId = jsonObject.getLong("ProjectId");
        Long userId = jsonObject.getLong("UserId");
        Map<String, Object> map = new HashMap<>();
        List<Data> datas = projectService.getData(projectId);
        List<Data> listDatas = new LinkedList<>();
        List<Data> userDatas = new LinkedList<>();
        for (Data d : datas) {
            if (d.getCreatorId() != userId) {
                System.out.println(d.toString());
                listDatas.add(d);
            } else {
                userDatas.add(d);
            }
        }

        map.put("listDatas", listDatas);
        map.put("userDatas", userDatas);
        return map;
    }

    //    展示项目中还未解决的问题
    @RequestMapping("/question")
    @ResponseBody
    public Map<String, Object> showQuestion(@Valid @RequestBody Map<String, Object> info) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(info);
        Long projectId = jsonObject.getLong("ProjectId");
        Long userId = jsonObject.getLong("UserId");
        if (projectId == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        List<Question> questions = projectService.getQuestion(projectId);
        System.out.println(questions);
        List<Question> listQuestions = new LinkedList<>();
        List<Question> userQuestions = new LinkedList<>();
        for (Question q : questions) {
            if (q.getCreatorId() != userId) {
                System.out.println(q.toString());
                listQuestions.add(q);
            } else {
                userQuestions.add(q);
            }
        }
        map.put("ListQuestions", listQuestions);
        map.put("UserQuestions", userQuestions);
        return map;
    }

    //    展示项目中未处理的解决方案
    @RequestMapping(value = "/solution", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> showSolution(@Valid @RequestBody Map<String, Object> info) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(info);
        Long projectId = jsonObject.getLong("ProjectId");
        Long userId = jsonObject.getLong("UserId");
        Map<String, Object> map = new HashMap<>();
        List<Solution> solutions = projectService.getSolution(projectId);
        List<Solution> listSolutions = new LinkedList<>();
        List<Solution> userSolutions = new LinkedList<>();
        for (Solution s : solutions) {
            if (s.getCreatorId() != userId) {
                System.out.println(s.toString());
                listSolutions.add(s);
            } else {
                userSolutions.add(s);
            }
        }

        map.put("listSolutions", listSolutions);
        map.put("userSolutions", userSolutions);
        return map;
    }

    //展示项目中未处理的解决方案
}