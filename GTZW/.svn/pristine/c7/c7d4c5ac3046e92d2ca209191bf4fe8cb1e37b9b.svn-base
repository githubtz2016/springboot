package com.ztesoft.rail.service.impl;

import com.ztesoft.rail.dao.SceneMonitorDao;
import com.ztesoft.rail.service.SceneMonitorService;
import com.ztesoft.rail.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SceneMonitorServiceImpl implements SceneMonitorService {

    @Autowired
    private SceneMonitorDao sceneMonitorDao;

    @Override
    public ResultMsg getTotalData(String timeStr) {
        ResultMsg rm = new ResultMsg();
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        Map<String,String> mapget = new HashMap<String, String>();
        //Map<String,String> mapput = new HashMap<String, String>();
        //日期处理
        String time = timeStr.replace("-","");
        time = time.replace(" ","");
        mapget = sceneMonitorDao.get4Guser(time);
//        if(!mapIsBlack(mapget)){
//            if(!strIsBlack(mapget.get("userNum"))){
//                mapput.put("userNum",mapget.get("userNum"));
//            }else{
//                mapput.put("userNum","--");
//            }
//        }else{
//            mapput.put("userNum","--");
//        }
        list.add(mapget);
        mapget = sceneMonitorDao.getVolteData(time);
        list.add(mapget);
        mapget = sceneMonitorDao.getSumFlow(time);
        list.add(mapget);
        rm.setData(list);
        return rm;
    }

    @Override
    public ResultMsg getHotTop3(String time) {
        return null;
    }

    @Override
    public ResultMsg getUserDistribute(String time) {
        return null;
    }

    @Override
    public ResultMsg getMapData(String timeStr) {
        ResultMsg rm = new ResultMsg();
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //日期处理
        String time = timeStr.replace("-","");
        time = time.replace(" ","");
        list = sceneMonitorDao.getWLAN(time);
        rm.setData(list);
        return rm;
    }

    @Override
    public ResultMsg getUserChange(String timeStr) {
        ResultMsg rm = new ResultMsg();
        //查询list结果集
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //返回map结果集
        Map<String,List<?>> result = new HashMap<String, List<?>>();
        List<Date> dates = new ArrayList<Date>();
        try {
            Date date = new SimpleDateFormat("yyyyMMddHH").parse(timeStr);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
            dates.add(date);
            list = sceneMonitorDao.getUserChange(sdf.format(date));
            result.put(sdf.format(date),list);
            Calendar now = Calendar.getInstance();
            //循环获取一小时前的数据
            for(int i=0;i<3;i++){
                now.setTime(dates.get(i));
                now.add(Calendar.HOUR_OF_DAY, -1);
                date = now.getTime();
                dates.add(date);
                result.put(sdf.format(date),sceneMonitorDao.getUserChange(sdf.format(date)));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        rm.setData(result);
        return rm;
    }

    @Override
    public ResultMsg getDashboard(String timeStr) {
        ResultMsg rm = new ResultMsg();
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        Map<String,String> mapget = new HashMap<String, String>();
        //日期处理
        String time = timeStr.replace("-","");
        time = time.replace(" ","");
        mapget = sceneMonitorDao.getX2Switch(time);
        list.add(mapget);
        mapget = sceneMonitorDao.getWLANlose(time);
        list.add(mapget);
        mapget = sceneMonitorDao.getHttpIndex(time);
        list.add(mapget);
        mapget = sceneMonitorDao.getVolteNet(time);
        list.add(mapget);
        rm.setData(list);
        return rm;
    }

    @Override
    public ResultMsg getStationData(String timeStr) {
        ResultMsg rm = new ResultMsg();
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //日期处理
        String time = timeStr.replace("-","");
        time = time.replace(" ","");
        list = sceneMonitorDao.getStation(time);
        rm.setData(list);
        return rm;
    }

    //判断map为空方法
    public boolean mapIsBlack(Map<String,String> map){
        if(map == null || map.size()<1) {
            return true;
        }
        return false;
    }
    //判断String为空方法
    public boolean strIsBlack(String str){
        if (str == null || str == ""){
            return true;
        }
        return false;
    }

}
