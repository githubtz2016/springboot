package com.ztesoft.rail.dao;

import com.ztesoft.rail.domain.HailwayLine;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DownLoadDao {
    List<Map<String,String>> getfirstPage (@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("lineId") String lineId);
    List<Map<String,String>> getvoltePage (@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("lineId") String lineId);

}
