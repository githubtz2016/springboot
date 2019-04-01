package com.ztesoft.rail.controller;

import com.ztesoft.rail.domain.HailwayLine;
import com.ztesoft.rail.service.DownLoadDataService;
import com.ztesoft.rail.service.HailwayLineService;
import com.ztesoft.rail.utils.ResultMsg;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hailwayLine")
public class HailwayLineController {

    @Autowired
    private HailwayLineService hailwayLineService;
 
    /**
     * 下拉框加载所有的高铁路线
     * @return
     */
    @PostMapping(value = "/getAllHailwayLine")
    @Cacheable(key = "getAllHailwayLine")
    public List<HailwayLine> getAllHailwayLine(){
        return hailwayLineService.getAllHailwayLine();
    }

    /**
     * 根据查询条件返回高铁线路各项指标
     * @param time,lineId
     * @return
     */
    @RequestMapping(value = "/getIndexByHailwayLine",method = RequestMethod.GET)
    public ResultMsg getIndexByHailwayLine(String time, String lineId){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(hailwayLineService.getIndexByHailwayLine(time,lineId));
        return resultMsg;
    }

    /**
     * 根据查询条件返回volte各项指标
     * @param time,lineId
     * @return
     */
    @RequestMapping(value = "/getIndexByVolte",method = RequestMethod.GET)
    @Cacheable(value = "getIndexByVolte")
    public ResultMsg getIndexByVolte(String time, String lineId){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(hailwayLineService.getIndexByVolte(time,lineId));
        return resultMsg;
    }


}
