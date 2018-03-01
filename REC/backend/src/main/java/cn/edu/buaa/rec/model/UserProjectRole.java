package cn.edu.buaa.rec.model;

public class UserProjectRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.user_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.project_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Long projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.role_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Long roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.is_creator
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Integer isCreator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project_role.isApproved
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    private Integer isapproved;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.id
     *
     * @return the value of user_project_role.id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.id
     *
     * @param id the value for user_project_role.id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.user_id
     *
     * @return the value of user_project_role.user_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.user_id
     *
     * @param userId the value for user_project_role.user_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.project_id
     *
     * @return the value of user_project_role.project_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.project_id
     *
     * @param projectId the value for user_project_role.project_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.role_id
     *
     * @return the value of user_project_role.role_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.role_id
     *
     * @param roleId the value for user_project_role.role_id
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.is_creator
     *
     * @return the value of user_project_role.is_creator
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Integer getIsCreator() {
        return isCreator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.is_creator
     *
     * @param isCreator the value for user_project_role.is_creator
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setIsCreator(Integer isCreator) {
        this.isCreator = isCreator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project_role.isApproved
     *
     * @return the value of user_project_role.isApproved
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public Integer getIsapproved() {
        return isapproved;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project_role.isApproved
     *
     * @param isapproved the value for user_project_role.isApproved
     *
     * @mbggenerated Tue Feb 06 02:42:05 CST 2018
     */
    public void setIsapproved(Integer isapproved) {
        this.isapproved = isapproved;
    }
}