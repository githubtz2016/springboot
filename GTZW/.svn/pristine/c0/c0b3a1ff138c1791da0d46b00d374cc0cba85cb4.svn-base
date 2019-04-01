package com.ztesoft.rail.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztesoft.rail.domain.HailwayCommunity;
import com.ztesoft.rail.service.HailwayCommunityService;
import com.ztesoft.rail.utils.PerformanceUtil;
import com.ztesoft.rail.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hailwayCommunity")
public class HailwayCommunityController {
    @Autowired
    private HailwayCommunityService hailwayCommunityService;

    /**
     * 前端传入高铁的线路id值 经纬度
     * 根据lineid查询hailway_community
     * 表中的所有数据
     * @param lineId
     * @return
     */
    @RequestMapping(value = "/getHailwayCommunityData",method = RequestMethod.POST)
    @ResponseBody
    public List<HailwayCommunity> lineData(Integer lineId){
        return hailwayCommunityService.lineData(lineId);
    }

    /**
     * 根据参数查询各个小区指标
     * @param pageNum
     * @param pageSize
     * @param startTime
     * @param endTime
     * @param index
     * @param sequence
     * @param line
     * @return
     */
    @PostMapping(value = "/getAllData")
    public PageInfo<PerformanceUtil> allData(Integer pageNum,Integer pageSize,String startTime, String endTime, String index, String sequence, Integer line){
        Page<PerformanceUtil> userList=hailwayCommunityService.allData(pageNum,pageSize,startTime,endTime,index,sequence,line);
        System.out.println(userList);
        PageInfo<PerformanceUtil> page = new PageInfo<PerformanceUtil>(userList);
        return page;

    }

    /**
     * 根据值取所有指标数据和对应的经纬度
     * @param startTime
     * @param endTime
     * @param index
     * @param line
     * @return
     */
    @PostMapping(value = "/getAllIndexData")
    public List<PerformanceUtil> getAllIndexData(String startTime, String endTime, String index, Integer line){
        return hailwayCommunityService.allIndexData(startTime,endTime,index,line);
    }






}
