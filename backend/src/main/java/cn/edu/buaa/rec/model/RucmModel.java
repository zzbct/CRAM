package cn.edu.buaa.rec.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by menghan on 2018/2/27.
 */
public class RucmModel {

    private String useCaseName;
    private String briefDescription;
    private String preCondition;
    private String primaryActor;
    private String secondaryActors;
    private String dependency;
    private String generalization;
    private BasicFlow basicFlow;
    private List<AlternativeFlow> alternativeFlows;
    public RucmModel(String text){
        JSONObject rucmSpecification = JSONObject.parseObject(text);
        JSONObject basicSection = rucmSpecification.getJSONObject("Brief");
        JSONArray basicInfo = basicSection.getJSONArray("data");
        setBriefDescription((String)basicInfo.get(0));
        setUseCaseName((String)basicInfo.get(1));
        setPreCondition((String)basicInfo.get(2));
        setPrimaryActor((String)basicInfo.get(3));
        setSecondaryActors((String)basicInfo.get(4));
        setDependency((String)basicInfo.get(5));
        setGeneralization((String)basicInfo.get(6));
        basicFlow = new BasicFlow(rucmSpecification.getJSONObject("BasicFlow"));
        alternativeFlows = new ArrayList<>();
        JSONArray specificFlows = rucmSpecification.getJSONArray("SpecificAlternativeFlows");
        for(int i = 0 ; i<specificFlows.size();i++){
            AlternativeFlow flow = new AlternativeFlow(specificFlows.getJSONObject(i),"SpecificAlternativeFlow");
            alternativeFlows.add(flow);
        }
        JSONArray boundedFlows = rucmSpecification.getJSONArray("BoundedAlternativeFlows");
        for(int i = 0 ; i<boundedFlows.size();i++){
            AlternativeFlow flow = new AlternativeFlow(boundedFlows.getJSONObject(i),"BoundedAlternativeFlow");
            alternativeFlows.add(flow);
        }
        JSONArray globalFlows = rucmSpecification.getJSONArray("GlobalAlternativeFlows");
        for(int i = 0 ; i<globalFlows.size();i++){
            AlternativeFlow flow = new AlternativeFlow(globalFlows.getJSONObject(i),"GlobalAlternativeFlow");
            alternativeFlows.add(flow);
        }
    }
    public RucmModel(){

    }
    public String getUseCaseName() {
        return useCaseName;
    }

    public void setUseCaseName(String useCaseName) {
        this.useCaseName = useCaseName;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition;
    }

    public String getPrimaryActor() {
        return primaryActor;
    }

    public void setPrimaryActor(String primaryActor) {
        this.primaryActor = primaryActor;
    }

    public String getSecondaryActors() {
        return secondaryActors;
    }

    public void setSecondaryActors(String secondaryActors) {
        this.secondaryActors = secondaryActors;
    }

    public String getDependency() {
        return dependency;
    }

    public void setDependency(String dependency) {
        this.dependency = dependency;
    }

    public String getGeneralization() {
        return generalization;
    }

    public void setGeneralization(String generalization) {
        this.generalization = generalization;
    }

    public BasicFlow getBasicFlow() {
        return basicFlow;
    }

    public void setBasicFlow(BasicFlow basicFlow) {
        this.basicFlow = basicFlow;
    }

    public List<AlternativeFlow> getAlternativeFlows() {
        return alternativeFlows;
    }

    public void setAlternativeFlows(List<AlternativeFlow> alternativeFlows) {
        this.alternativeFlows = alternativeFlows;
    }
}
