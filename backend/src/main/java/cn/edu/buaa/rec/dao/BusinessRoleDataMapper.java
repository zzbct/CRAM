package cn.edu.buaa.rec.dao;

import cn.edu.buaa.rec.model.BusinessRoleData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessRoleDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business_role_data
     *
     * @mbggenerated Mon Mar 05 23:04:33 CST 2018
     */
    int insert(BusinessRoleData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business_role_data
     *
     * @mbggenerated Mon Mar 05 23:04:33 CST 2018
     */
    int insertSelective(BusinessRoleData record);

    List<BusinessRoleData> selectBusinessRoleDataByRoleIds(@Param("rIds") List<Long> rIds);
    List<BusinessRoleData> selectBusinessRoleDataByRoleId(@Param("rId") Long rId);

}