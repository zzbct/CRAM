package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.UserProjectRole;

import java.util.List;

public interface UserProjectRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_project_role
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insert(UserProjectRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_project_role
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insertSelective(UserProjectRole record);
    List<UserProjectRole> selectBySysUserId(Long sysUserId);
}