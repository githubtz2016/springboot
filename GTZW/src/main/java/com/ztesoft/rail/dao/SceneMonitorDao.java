package com.ztesoft.rail.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SceneMonitorDao {
    //总计数据
    Map<String,String> get4Guser(@Param("time") String time);
    Map<String,String> getVolteData(@Param("time") String time);
    Map<String,String> getSumFlow(@Param("time") String time);
    //仪表盘数据
    Map<String,String> getX2Switch(@Param("time") String time);
    Map<String,String> getHttpIndex(@Param("time") String time);
    Map<String,String> getWLANlose(@Param("time") String time);
    Map<String,String> getVolteNet(@Param("time") String time);
    //地图的无线利用率
    List<Map<String,String>> getWLAN(@Param("time") String time);
    //高流量车站用户数
    List<Map<String,String>> getStation(@Param("time") String time);
    //用户变化趋势
    List<Map<String,String>> getUserChange(@Param("time") String time);
}
