package com.ztesoft.rail.dao;

import com.ztesoft.rail.domain.HailwayLine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VolteIndexDao {
    Map<String,String> getVolteAccrete(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    Map<String,String> getVolteContinue(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    Map<String,String> getMOS(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    Map<String,String> getESRVCCSwitch(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    Map<String,String> getRRCLogin(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    Map<String,String> getX2Switch(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    //详情接口
    List<Map<Object,Object>> getX2SwitchInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<Object,Object>> getESRVCCInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<Object,Object>> getRTPInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<Object,Object>> getVolteContinueInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<Object,Object>> getVolteAccreteInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<Object,Object>> getImsRegisterInfo(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("lineId") String lineId);
}
