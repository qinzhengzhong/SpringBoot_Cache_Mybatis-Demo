package com.allan.mapper;

import com.allan.entity.AirportInfo;

public interface AirportInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    int insert(AirportInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    int insertSelective(AirportInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    AirportInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    int updateByPrimaryKeySelective(AirportInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_airport_info
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    int updateByPrimaryKey(AirportInfo record);
}