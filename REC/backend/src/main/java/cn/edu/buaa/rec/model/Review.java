package cn.edu.buaa.rec.model;

import java.util.Date;

public class Review {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.time
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.user_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.target_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private Long targetId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.type_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private Integer typeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.content
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.id
     *
     * @return the value of review.id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.id
     *
     * @param id the value for review.id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.time
     *
     * @return the value of review.time
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.time
     *
     * @param time the value for review.time
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.user_id
     *
     * @return the value of review.user_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.user_id
     *
     * @param userId the value for review.user_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.target_id
     *
     * @return the value of review.target_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public Long getTargetId() {
        return targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.target_id
     *
     * @param targetId the value for review.target_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.type_id
     *
     * @return the value of review.type_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.type_id
     *
     * @param typeId the value for review.type_id
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.content
     *
     * @return the value of review.content
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.content
     *
     * @param content the value for review.content
     *
     * @mbggenerated Mon Feb 05 20:59:37 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}