package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.Question;
import cn.edu.buaa.rec.model.QuestionExample;

import java.util.List;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int countByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insertSelective(Question record);

    List<Question> selectByProjectId(Long id);
}