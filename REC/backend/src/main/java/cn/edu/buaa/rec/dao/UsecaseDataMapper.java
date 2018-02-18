package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.UsecaseData;
import cn.edu.buaa.rec.model.UsecaseDataExample;

import java.util.List;

public interface UsecaseDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usecase_data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int countByExample(UsecaseDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usecase_data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insert(UsecaseData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usecase_data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insertSelective(UsecaseData record);

    List<UsecaseData> selectByUsecaseId(Long usecaseId);
}