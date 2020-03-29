package com.allan.entity;

import java.math.BigDecimal;

/**
 * Database Table Remarks:
 *   世界机场信息数据
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_airport_info
 */
public class AirportInfo {
    /**
     * Database Column Remarks:
     *   id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.id
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   机场三字码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.airport_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String airportCode;

    /**
     * Database Column Remarks:
     *   机场英文名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.airport_en
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String airportEn;

    /**
     * Database Column Remarks:
     *   机场中文名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.airport_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String airportCn;

    /**
     * Database Column Remarks:
     *   纬度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.latitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private BigDecimal latitude;

    /**
     * Database Column Remarks:
     *   经度
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.longitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private BigDecimal longitude;

    /**
     * Database Column Remarks:
     *   城市三字码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.city_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String cityCode;

    /**
     * Database Column Remarks:
     *   城市中文名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.city_name_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String cityNameCn;

    /**
     * Database Column Remarks:
     *   所属国家
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_airport_info.country
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    private String country;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.id
     *
     * @return the value of t_airport_info.id
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.id
     *
     * @param id the value for t_airport_info.id
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.airport_code
     *
     * @return the value of t_airport_info.airport_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.airport_code
     *
     * @param airportCode the value for t_airport_info.airport_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode == null ? null : airportCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.airport_en
     *
     * @return the value of t_airport_info.airport_en
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getAirportEn() {
        return airportEn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.airport_en
     *
     * @param airportEn the value for t_airport_info.airport_en
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setAirportEn(String airportEn) {
        this.airportEn = airportEn == null ? null : airportEn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.airport_cn
     *
     * @return the value of t_airport_info.airport_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getAirportCn() {
        return airportCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.airport_cn
     *
     * @param airportCn the value for t_airport_info.airport_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setAirportCn(String airportCn) {
        this.airportCn = airportCn == null ? null : airportCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.latitude
     *
     * @return the value of t_airport_info.latitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.latitude
     *
     * @param latitude the value for t_airport_info.latitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.longitude
     *
     * @return the value of t_airport_info.longitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.longitude
     *
     * @param longitude the value for t_airport_info.longitude
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.city_code
     *
     * @return the value of t_airport_info.city_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.city_code
     *
     * @param cityCode the value for t_airport_info.city_code
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.city_name_cn
     *
     * @return the value of t_airport_info.city_name_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getCityNameCn() {
        return cityNameCn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.city_name_cn
     *
     * @param cityNameCn the value for t_airport_info.city_name_cn
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setCityNameCn(String cityNameCn) {
        this.cityNameCn = cityNameCn == null ? null : cityNameCn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_airport_info.country
     *
     * @return the value of t_airport_info.country
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_airport_info.country
     *
     * @param country the value for t_airport_info.country
     *
     * @mbg.generated Sun Mar 29 16:53:14 CST 2020
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}