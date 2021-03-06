package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.Data;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insert(Data record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table data
     *
     * @mbggenerated Wed Feb 28 00:40:34 CST 2018
     */
    int insertSelective(Data record);
    Data selectById(Long dataId);

    List<Data> selectByProjectId(Long id);

    List<Data> selectByProjectIdAndUserId(@Param("projectId")Long projectId, @Param("userId")Long userId);

    int checkByNameAndProjectId(@Param("name")String name,@Param("projectId")Long projectid);
    Long selectMaxId();
}