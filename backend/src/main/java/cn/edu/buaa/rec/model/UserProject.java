package cn.edu.buaa.rec.model;

public class UserProject {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project.id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project.user_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_project.project_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    private Long projectId;

    public UserProject() {
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project.id
     *
     * @return the value of user_project.id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project.id
     *
     * @param id the value for user_project.id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project.user_id
     *
     * @return the value of user_project.user_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project.user_id
     *
     * @param userId the value for user_project.user_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_project.project_id
     *
     * @return the value of user_project.project_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_project.project_id
     *
     * @param projectId the value for user_project.project_id
     *
     * @mbggenerated Mon Mar 05 21:11:02 CST 2018
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}