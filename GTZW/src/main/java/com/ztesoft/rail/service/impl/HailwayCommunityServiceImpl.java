package com.ztesoft.rail.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ztesoft.rail.dao.HailwayCommunityDao;
import com.ztesoft.rail.dao.HailwayMapDataDao;
import com.ztesoft.rail.domain.HailwayCommunity;
import com.ztesoft.rail.service.HailwayCommunityService;
import com.ztesoft.rail.utils.PerformanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HailwayCommunityServiceImpl implements HailwayCommunityService {
    @Autowired
    private HailwayCommunityDao hailwayCommunityDao;
    @Autowired
    private HailwayMapDataDao hailwayMapDataDao;

    /**
     * 查询表hailway_community
     * @return
     */
    @Override
    public List<HailwayCommunity> lineData(Integer lineId) {
        return hailwayCommunityDao.lineData(lineId);
    }

    /**
     * 分页查询各个高铁线路的指标
     * @param startTime
     * @param endTime
     * @param index
     * @param sequence
     * @param line
     * @return
     */

  @Override
  public Page<PerformanceUtil> allData(Integer pageNum,Integer pageSize,String startTime, String endTime, String index, String sequence, Integer line) {
	  Page<PerformanceUtil> page = PageHelper.startPage(pageNum,pageSize);

	  if((startTime != null) && (startTime != "") &&
              (endTime != null) && (endTime !="") &&
              (index !=null) && (index != "") &&
              (sequence != null) &&(sequence != "") &&
              (line != null) && (line !=0)){

	  String str="";
	  String ss[]=null;
	  ss = startTime.split("-");
	  for(int i=0;i<ss.length;i++){
	      str+=ss[i];
      }
	  startTime=str+0+"0";

      String str1="";
      String ss1[]=null;
      ss1 = endTime.split("-");
      for(int j=0;j<ss1.length;j++){
          str1+=ss1[j];
      }
      endTime = str1+24;

      if (index.equals("HTTP_IND1")) {
          page = hailwayCommunityDao.dataIndex0(startTime, endTime, sequence, line);
      }
      if (index.equals("HTTP_IND2")) {
          page = hailwayCommunityDao.dataIndex1(startTime, endTime, sequence, line);
      }else if (index.equals("HTTP_IND5")) {
          page = hailwayCommunityDao.dataIndex2(startTime, endTime, sequence, line);
      }
      if (index.equals("FTP_IND1")) {
          page = hailwayCommunityDao.dataIndex3(startTime, endTime, sequence, line);
      }
      if (index.equals("IM_IND1")) {
          page = hailwayCommunityDao.dataIndex4(startTime, endTime, sequence, line);
      }
      if (index.equals("IM_IND2")) {
          page = hailwayCommunityDao.dataIndex5(startTime, endTime, sequence, line);
      }
      if (index.equals("IM_IND3")) {
          page = hailwayCommunityDao.dataIndex6(startTime, endTime, sequence, line);
      }
      if (index.equals("VIDEO_IND1")) {
          page = hailwayCommunityDao.dataIndex7(startTime, endTime, sequence, line);
      }
      if (index.equals("VIDEO_IND2")) {
          page = hailwayCommunityDao.dataIndex8(startTime, endTime, sequence, line);
      }
      if (index.equals("UU_IND1")) {
          page = hailwayCommunityDao.dataIndex9(startTime, endTime, sequence, line);
      }
      if (index.equals("S1MME_IND1")) {
          page = hailwayCommunityDao.dataIndex10(startTime, endTime, sequence, line);
      }
      if (index.equals("S1MME_IND2")) {
          page = hailwayCommunityDao.dataIndex11(startTime, endTime, sequence, line);
      }
      if(index.equals("S1MME_IND1_VOLTE")){
          page = hailwayCommunityDao.VoltedataIndex0(startTime,endTime,sequence,line);
      }
      if(index.equals("S1MME_IND2_VOLTE")){
          page = hailwayCommunityDao.VoltedataIndex1(startTime,endTime,sequence,line);
      }
      if(index.equals("VOLTE_IND5")){
          page = hailwayCommunityDao.VoltedataIndex2(startTime,endTime,sequence,line);
      }
      if(index.equals("VOLTE_IND1")){
          page = hailwayCommunityDao.VoltedataIndex3(startTime,endTime,sequence,line);
      }
      if(index.equals("VOLTE_IND2")){
          page = hailwayCommunityDao.VoltedataIndex4(startTime,endTime,sequence,line);
      }
      if(index.equals("SV_IND1")){
          page = hailwayCommunityDao.VoltedataIndex5(startTime,endTime,sequence,line);
      }
      if(index.equals("MOS_IND1")){
          page = hailwayCommunityDao.VoltedataIndex6(startTime,endTime,sequence,line);
      }
      if(index.equals("UU_IND1")){
          page = hailwayCommunityDao.VoltedataIndex7(startTime,endTime,sequence,line);
      }
      if(index.equals("X2_IND1")){
          page = hailwayCommunityDao.VoltedataIndex8(startTime,endTime,sequence,line);
      }


      }
      return page;


  }

    /**
     * 查询所有的指标数据用于画线
     * @param startTime
     * @param endTime
     * @param index
     * @param line
     * @return
     */


    @Override
    public List<PerformanceUtil> allIndexData(String startTime, String endTime, String index, Integer line) {
          List<PerformanceUtil> list=null;

          if((startTime != null) && (startTime != "") &&
                    (endTime != null) && (endTime !="") &&
                    (index !=null) && (index != "") &&
                    (line != null) && (line !=0)){

              if(startTime.trim().length()<=11){
                String str="";
                String ss[]=null;
                ss = startTime.split("-");
                for(int i=0;i<ss.length;i++){
                    str+=ss[i];
                }
                startTime=str+0+"0";

                String str1="";
                String ss1[]=null;
                ss1 = endTime.split("-");
                for(int j=0;j<ss1.length;j++){
                    str1+=ss1[j];
                }
                endTime = str1+24;

              }else {
                  startTime = startTime.replace("-", "").replace(" ", "");
                  endTime = endTime.replace("-", "").replace(" ", "");

              }

                if (index.equals("HTTP_IND1")) {
                    list= hailwayMapDataDao.dataIndex0(startTime, endTime,  line);
                }
                if (index.equals("HTTP_IND2")) {
                    list = hailwayMapDataDao.dataIndex1(startTime, endTime, line);
                }else if (index.equals("HTTP_IND5")) {
                    list = hailwayMapDataDao.dataIndex2(startTime, endTime, line);
                }
                if (index.equals("FTP_IND1")) {
                    list = hailwayMapDataDao.dataIndex3(startTime, endTime,  line);
                }
                if (index.equals("IM_IND1")) {
                    list = hailwayMapDataDao.dataIndex4(startTime, endTime,  line);
                }
                if (index.equals("IM_IND2")) {
                    list = hailwayMapDataDao.dataIndex5(startTime, endTime,  line);
                }
                if (index.equals("IM_IND3")) {
                    list = hailwayMapDataDao.dataIndex6(startTime, endTime,  line);
                }
                if (index.equals("VIDEO_IND1")) {
                    list = hailwayMapDataDao.dataIndex7(startTime, endTime,  line);
                }
                if (index.equals("VIDEO_IND2")) {
                    list = hailwayMapDataDao.dataIndex8(startTime, endTime,  line);
                }
                if (index.equals("UU_IND1")) {
                    list = hailwayMapDataDao.dataIndex9(startTime, endTime, line);
                }
                if (index.equals("S1MME_IND1")) {
                    list = hailwayMapDataDao.dataIndex10(startTime, endTime,  line);
                }
                if (index.equals("S1MME_IND2")) {
                    list = hailwayMapDataDao.dataIndex11(startTime, endTime,  line);
                }
                if(index.equals("S1MME_IND1_VOLTE")){
                    list = hailwayMapDataDao.volteDataIndex0(startTime,endTime,line);
                }
                if(index.equals("S1MME_IND2_VOLTE")){
                    list = hailwayMapDataDao.volteDataIndex1(startTime,endTime,line);
                }
                if(index.equals("VOLTE_IND5")){
                    list = hailwayMapDataDao.volteDataIndex2(startTime,endTime,line);
                }
                if(index.equals("VOLTE_IND1")){
                    list = hailwayMapDataDao.volteDataIndex3(startTime,endTime,line);
                }
                if(index.equals("VOLTE_IND2")){
                    list = hailwayMapDataDao.volteDataIndex4(startTime,endTime,line);
                }
                if(index.equals("SV_IND1")){
                    list = hailwayMapDataDao.volteDataIndex5(startTime,endTime,line);
                }
                if(index.equals("MOS_IND1")){
                    list = hailwayMapDataDao.volteDataIndex6(startTime,endTime,line);
                }
                if(index.equals("UU_IND1")){
                    list = hailwayMapDataDao.volteDataIndex7(startTime,endTime,line);
                }
                if(index.equals("X2_IND1")){
                    list = hailwayMapDataDao.volteDataIndex8(startTime,endTime,line);
                }

            }
                 return list;
    }


}
