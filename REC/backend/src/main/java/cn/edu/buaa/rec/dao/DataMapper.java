package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.Data;
import cn.edu.buaa.rec.model.DataExample;

import java.util.List;

public interface DataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int countByExample(DataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insert(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbggenerated Sun Feb 18 09:09:16 CST 2018
     */
    int insertSelective(Data record);

    Data selectById(Long dataId);

    List<Data> selectByProjectId(Long id);
}