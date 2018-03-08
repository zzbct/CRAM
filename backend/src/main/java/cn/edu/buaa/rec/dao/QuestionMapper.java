package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insertSelective(Question record);
    List<Question> selectByProjectId(Long projectId);

    Long selectMaxId();

    int checkByTitleAndProjectId(@Param("title")String title, @Param("projectId")Long projectid);

}