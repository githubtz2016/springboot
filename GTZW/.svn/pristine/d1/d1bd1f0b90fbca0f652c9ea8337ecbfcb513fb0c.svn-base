package com.ztesoft.rail.controller;

import com.ztesoft.rail.service.SceneMonitorService;
import com.ztesoft.rail.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sceneMonitor")
public class SceneMonitorController {

    @Autowired
    public SceneMonitorService sceneMonitorService;

    /**
     * 获取场景监控总数据
     * @param time
     * @return
     */
    @GetMapping(value = "/getTotalData")
    public ResultMsg getTotalData(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getTotalData(time);
        return resultMsg;
    }

    /**
     * 获取热门应用top3
     * @param time
     * @return
     */
    @GetMapping(value = "/getHotTop3")
    public ResultMsg getHotTop3(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getHotTop3(time);
        return resultMsg;
    }

    /**
     * 获取用户终端分布
     * @param time
     * @return
     */
    @GetMapping(value = "/getUserDistribute")
    public ResultMsg getUserDistribute(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getUserDistribute(time);
        return resultMsg;
    }

    /**
     * 获取地图数据
     * @param time
     * @return
     */
    @GetMapping(value = "/getMapData")
    public ResultMsg getMapData(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getMapData(time);
        return resultMsg;
    }

    /**
     * 获取高铁用户变化趋势
     * @param time
     * @return
     */
    @GetMapping(value = "/getUserChange")
    public ResultMsg getUserChange(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getUserChange(time);
        return resultMsg;
    }

    /**
     * 获取仪表盘数据
     * @param time
     * @return
     */
    @GetMapping(value = "/getDashboard")
    public ResultMsg getDashboard(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getDashboard(time);
        return resultMsg;
    }

    /**
     * 获取车站数据
     * @param time
     * @return
     */
    @GetMapping(value = "/getStationData")
    public ResultMsg getStationData(String time){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg = sceneMonitorService.getStationData(time);
        return resultMsg;
    }





}
