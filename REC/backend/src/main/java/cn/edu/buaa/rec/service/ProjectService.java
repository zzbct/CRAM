package cn.edu.buaa.rec.service;

import cn.edu.buaa.rec.model.Project;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: suruo
 * @Email: csuruo@gmail.com
 * @Date: Created on 上午1:23 2018/02/06
 * @Modified by:
 */

public interface ProjectService {
    Map<String,Object> newProject(Project project) ;

    //    查询数据库中是否已经存在该项目名称
    boolean noExist(String name);

    List<Map<String,Object>> allProject();

    Map<String,Object> getProjectInfo(String projectName);

    Map<String,Object> applyRole(Map<String, Object> applyRoleInfo);

    Map<String,Object> applyManager(Map<String, Object> applyManagerInfo);

    List<Map<String,Object>> getScenes(String projectName);

    String getRole(String projectName);

    String getData(String projectName);

    String getQuestion(String projectName);

    String getSolution(String projectName);
}