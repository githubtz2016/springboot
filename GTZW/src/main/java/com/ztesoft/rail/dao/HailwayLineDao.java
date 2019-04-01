package com.ztesoft.rail.dao;

import com.ztesoft.rail.domain.HailwayLine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface HailwayLineDao {
    List<HailwayLine> getAllHailwayLine();
    Map<String,String> getHttpIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
    Map<String,String> getFtpIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
    Map<String,String> getImIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
    Map<String,String> getVideoIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
    Map<String,String> getUUIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
    Map<String,String> getS1mmeIndex(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("lineId") String lineId);
}
