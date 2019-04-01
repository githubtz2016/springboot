package com.ztesoft.rail.service.impl;

import com.ztesoft.rail.dao.DownLoadDao;
import com.ztesoft.rail.service.DownLoadDataService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DownLoadDataServiceImpl implements DownLoadDataService {
    @Autowired
    private DownLoadDao downLoadDao;

    @Override
    public List<Map<String,String>> getfirstPage(String time, String lineId) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //日期处理
        String timeStr = time.replace("-","");
        timeStr = timeStr.replace(" ","");
        //判断时间位数
        String startTime = "";
        String endTime = "";
        if(timeStr.length()==8){
            startTime = timeStr+"00";
            endTime = timeStr+"24";
        }else{
            startTime = timeStr;
            endTime = timeStr;
        }
        list = downLoadDao.getfirstPage(startTime,endTime,lineId);
        return list;
    }

    @Override
    public List<Map<String,String>> getvoltePage(String time, String lineId) {
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        //日期处理
        String timeStr = time.replace("-","");
        timeStr = timeStr.replace(" ","");
        //判断时间位数
        String startTime = "";
        String endTime = "";
        if(timeStr.length()==8){
            startTime = timeStr+"00";
            endTime = timeStr+"24";
        }else{
            startTime = timeStr;
            endTime = timeStr;
        }
        list = downLoadDao.getvoltePage(startTime,endTime,lineId);
        return list;
    }


}
