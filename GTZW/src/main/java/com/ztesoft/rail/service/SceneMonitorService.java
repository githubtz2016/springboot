package com.ztesoft.rail.service;

import com.ztesoft.rail.utils.ResultMsg;

public interface SceneMonitorService {

    public ResultMsg getTotalData(String time);
    public ResultMsg getHotTop3(String time);
    public ResultMsg getUserDistribute(String time);
    public ResultMsg getMapData(String time);
    public ResultMsg getUserChange(String time);
    public ResultMsg getDashboard(String time);
    public ResultMsg getStationData(String time);

}
