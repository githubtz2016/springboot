package com.ztesoft.rail.controller;

import com.ztesoft.rail.service.DownLoadDataService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/download")
public class downloadFileController {
    @Autowired
    private DownLoadDataService downLoadDataService;

    /**
     * 导出首页数据到excel
     * @param time,lineId
     * @return
     */
    @GetMapping("/getfirstPage")
    public void getfirstPage(String time, String lineId,HttpServletResponse response) {
        //获取要导入的数据
        List<Map<String,String>> list = downLoadDataService.getfirstPage(time,lineId);
        //设置excel表格基本信息
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("小区各项指标表");
        sheet.setColumnWidth(0,30 * 256);
        //设置表头
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("小区名称");
        headerRow.createCell(1).setCellValue("所属地市");
        headerRow.createCell(2).setCellValue("网页页面响应成功率(%)");
        headerRow.createCell(3).setCellValue("页面响应平均时延(ms)");
        headerRow.createCell(4).setCellValue("HTTP下载速率(kbps)");
        headerRow.createCell(5).setCellValue("应用下载速率(kbps)");
        headerRow.createCell(6).setCellValue("播放成功率(%)");
        headerRow.createCell(7).setCellValue("视频下载速率(kbps)");
        headerRow.createCell(8).setCellValue("ATTACH成功率(%)");
        headerRow.createCell(9).setCellValue("TAU成功率(%)");
        //将数据循环导入到表格中
        for(int i=0;i<list.size();i++){
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(list.get(i).get("community_name"));
            row.createCell(1).setCellValue(list.get(i).get("city_name"));
            row.createCell(2).setCellValue(list.get(i).get("HTTP_IND1"));
            row.createCell(3).setCellValue(list.get(i).get("HTTP_IND2"));
            row.createCell(4).setCellValue(list.get(i).get("HTTP_IND5"));
            row.createCell(5).setCellValue(list.get(i).get("FTP_IND1"));
            row.createCell(6).setCellValue(list.get(i).get("VIDEO_IND1"));
            row.createCell(7).setCellValue(list.get(i).get("VIDEO_IND2"));
            row.createCell(8).setCellValue(list.get(i).get("S1MME_IND1"));
            row.createCell(9).setCellValue(list.get(i).get("S1MME_IND2"));
        }
        //输出excel
        try {
            String filename = "首页指标.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 导出volte数据到excel
     * @param time,lineId
     * @return
     */
    @GetMapping("/getvoltePage")
    public void getvoltePage(String time, String lineId,HttpServletResponse response) {
        //获取要导入的数据
        List<Map<String,String>> list = downLoadDataService.getvoltePage(time,lineId);
        //设置excel表格基本信息
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("小区各项指标表");
        sheet.setColumnWidth(0,30 * 256);
        //设置表头
        HSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("小区名称");
        headerRow.createCell(1).setCellValue("所属地市");


        //将数据循环导入到表格中
        for(int i=0;i<list.size();i++){
            HSSFRow row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(list.get(i).get("community_name"));


        }
        //输出excel
        try {
            String filename = "volte指标.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename, "utf-8"));
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
