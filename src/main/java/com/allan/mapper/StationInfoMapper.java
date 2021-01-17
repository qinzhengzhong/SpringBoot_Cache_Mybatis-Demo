package com.allan.mapper;

import com.allan.entity.StationInfo;

import java.util.List;

public interface StationInfoMapper {

    int deleteByPrimaryKey(String id);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    StationInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(StationInfo record);

    int updateByPrimaryKey(StationInfo record);

    List<StationInfo> getAllStations();
}