package cn.edu.buaa.rec.model;

public class SolutionQuestion {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column solution_question.id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column solution_question.solution_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    private Long solutionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column solution_question.question_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    private Long questionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column solution_question.id
     *
     * @return the value of solution_question.id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column solution_question.id
     *
     * @param id the value for solution_question.id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column solution_question.solution_id
     *
     * @return the value of solution_question.solution_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public Long getSolutionId() {
        return solutionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column solution_question.solution_id
     *
     * @param solutionId the value for solution_question.solution_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column solution_question.question_id
     *
     * @return the value of solution_question.question_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column solution_question.question_id
     *
     * @param questionId the value for solution_question.question_id
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}