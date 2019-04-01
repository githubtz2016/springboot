package com.ztesoft.rail.service.impl;

import com.ztesoft.rail.dao.HailwayMapDataDao;
import com.ztesoft.rail.dao.HailwayLineDao;
import com.ztesoft.rail.dao.VolteIndexDao;
import com.ztesoft.rail.domain.HailwayLine;
import com.ztesoft.rail.domain.IndexEntity;
import com.ztesoft.rail.service.HailwayLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HailwayLineServiceImpl implements HailwayLineService {

    @Autowired
    public HailwayLineDao hailwayLineDao;
    @Autowired
    public HailwayMapDataDao hailwayHttpHDao;
    @Autowired
    public VolteIndexDao volteIndexDao;

    @Override
    public List<HailwayLine> getAllHailwayLine() {
        return hailwayLineDao.getAllHailwayLine();
    }

    @Override
    @Cacheable(cacheNames = "hailwayLine",key = "methodName+'_'+#p0+#p1")
    public List<IndexEntity> getIndexByHailwayLine(String time,String lineId) {
        List<IndexEntity> list = new ArrayList<IndexEntity>();
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
        Map<String,String> mapget = new HashMap<String, String>();
        //获取http指标
        mapget = hailwayLineDao.getHttpIndex(startTime,endTime,lineId);
        IndexEntity ie1 = new IndexEntity();
        ie1.setId("HTTP_IND1");
        ie1.setName("网页浏览类页面响应成功率(%)");
        if(mapget == null || mapget.get("HTTP_IND1")==null){
        	ie1.setValue("--");
        }else{
            ie1.setValue(String.valueOf(mapget.get("HTTP_IND1")));
        }
        list.add(ie1);
        IndexEntity ie2 = new IndexEntity();
        ie2.setId("HTTP_IND2");
        ie2.setName("页面响应平均时延(ms)");
        if(mapget == null || mapget.get("HTTP_IND2")==null){
        	ie2.setValue("--");
        }else{
            ie2.setValue(String.valueOf(mapget.get("HTTP_IND2")));
        }
        list.add(ie2);
        IndexEntity ie3 = new IndexEntity();
        ie3.setId("HTTP_IND5");
        ie3.setName("HTTP下载速率(kbps)");
        if(mapget == null || mapget.get("HTTP_IND5")==null){
        	ie3.setValue("--");
        }else{
            ie3.setValue(String.valueOf(mapget.get("HTTP_IND5")));
        }
        list.add(ie3);
        //获取ftp指标
        mapget = hailwayLineDao.getFtpIndex(startTime,endTime,lineId);
        IndexEntity ie4 = new IndexEntity();
        ie4.setId("FTP_IND1");
        ie4.setName("应用下载速率(kbps)");
        if(mapget == null || mapget.get("FTP_IND1")==null){
        	ie4.setValue("--");
        }else{
            ie4.setValue(String.valueOf(mapget.get("FTP_IND1")));
        }

        list.add(ie4);
        //获取im指标
        mapget = hailwayLineDao.getImIndex(startTime,endTime,lineId);
        IndexEntity ie5 = new IndexEntity();
        ie5.setId("IM_IND1");
        ie5.setName("IM登陆成功率(%)");
        if(mapget == null || mapget.get("IM_IND1")==null){
        	ie5.setValue("--");
        }else{
            ie5.setValue(String.valueOf(mapget.get("IM_IND1")));
        }

        list.add(ie5);
        IndexEntity ie6 = new IndexEntity();
        ie6.setId("IM_IND2");
        ie6.setName("IM 200KB以上上传速率（kbps）");
        if(mapget == null || mapget.get("IM_IND2")==null){
        	ie6.setValue("--");
        }else{
            ie6.setValue(String.valueOf(mapget.get("IM_IND2")));
        }

        list.add(ie6);
        IndexEntity ie7 = new IndexEntity();
        ie7.setId("IM_IND3");
        ie7.setName("IM 200KB以上下载速率（kbps）");
        if(mapget == null || mapget.get("IM_IND3")==null){
        	ie7.setValue("--");
        }else{
            ie7.setValue(String.valueOf(mapget.get("IM_IND3")));
        }

        list.add(ie7);
        //获取video指标
        mapget = hailwayLineDao.getVideoIndex(startTime,endTime,lineId);
        IndexEntity ie8 = new IndexEntity();
        ie8.setId("VIDEO_IND1");
        ie8.setName("播放成功率(%)");
        if(mapget == null || mapget.get("VIDEO_IND1")==null){
            ie8.setValue("--");
        }else{
            ie8.setValue(String.valueOf(mapget.get("VIDEO_IND1")));
        }

        list.add(ie8);
        IndexEntity ie9 = new IndexEntity();
        ie9.setId("VIDEO_IND2");
        ie9.setName("视频下载速率（kbps）");
        if(mapget == null || mapget.get("VIDEO_IND2")==null){
        	ie9.setValue("--");
        }else{
            ie9.setValue(String.valueOf(mapget.get("VIDEO_IND2")));
        }

        list.add(ie9);
        //获取uu指标
        mapget = hailwayLineDao.getUUIndex(startTime,endTime,lineId);
        IndexEntity ie10 = new IndexEntity();
        ie10.setId("UU_IND1");
        ie10.setName("RRC连接建立成功率");
        if(mapget == null  || mapget.get("UU_IND1")==null){
        	ie10.setValue("--");
        }else{
            ie10.setValue(String.valueOf(mapget.get("UU_IND1")));
        }

        list.add(ie10);
        //获取s1mme指标
        mapget = hailwayLineDao.getS1mmeIndex(startTime,endTime,lineId);
        IndexEntity ie11 = new IndexEntity();
        ie11.setId("S1MME_IND1");
        ie11.setName("ATTACH成功率");
        if(mapget == null  || mapget.get("S1MME_IND1")==null){
        	ie11.setValue("--");
        }else{
            ie11.setValue(String.valueOf(mapget.get("S1MME_IND1")));
        }

        list.add(ie11);
        IndexEntity ie12 = new IndexEntity();
        ie12.setId("S1MME_IND2");
        ie12.setName("TAU成功率");
        if(mapget == null || mapget.get("S1MME_IND2")==null){
        	ie12.setValue("--");
        }else{
            ie12.setValue(String.valueOf(mapget.get("S1MME_IND2")));
        }
        
        list.add(ie12);
        return list;
    }

    @Override
    public List<IndexEntity> getIndexByVolte(String time, String lineId) {
        List<IndexEntity> list = new ArrayList<IndexEntity>();
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
        Map<String,String> mapget = new HashMap<String, String>();
        //获取VOLTE附着阶段
        mapget = volteIndexDao.getVolteAccrete(startTime,endTime,lineId);
        IndexEntity attach = new IndexEntity();
        attach.setId("S1MME_IND1");
        attach.setName("ATTACH成功率(%)");
        attach.setValue("--");
        IndexEntity tau = new IndexEntity();
        tau.setId("S1MME_IND2");
        tau.setName("TAU成功率(%)");
        tau.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("S1MME_IND1"))){
                attach.setValue(mapget.get("S1MME_IND1"));
            }
            if(!strIsBlack(mapget.get("S1MME_IND2"))){
                tau.setValue(mapget.get("S1MME_IND2"));
            }
        }
        list.add(attach);
        list.add(tau);

        //获取VOLTE持续阶段得分
        mapget = volteIndexDao.getVolteContinue(startTime,endTime,lineId);
        IndexEntity ims = new IndexEntity();
        ims.setId("VOLTE_IND5");
        ims.setName("IMS注册成功率(%)");
        ims.setValue("--");
        IndexEntity startVoice = new IndexEntity();
        startVoice.setId("VOLTE_IND1");
        startVoice.setName("语音始呼网络接通率(%)");
        startVoice.setValue("--");
        IndexEntity endVoice = new IndexEntity();
        endVoice.setId("VOLTE_IND2");
        endVoice.setName("语音终呼网络接通率(%)");
        endVoice.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("VOLTE_IND5"))){
                ims.setValue(mapget.get("VOLTE_IND5"));
            }
            if(!strIsBlack(mapget.get("VOLTE_IND1"))){
                startVoice.setValue(mapget.get("VOLTE_IND1"));
            }
            if(!strIsBlack(mapget.get("VOLTE_IND2"))){
                endVoice.setValue(mapget.get("VOLTE_IND2"));
            }
        }
        list.add(ims);
        list.add(startVoice);
        list.add(endVoice);

        //获取MOS RTP丢包率
        mapget = volteIndexDao.getMOS(startTime,endTime,lineId);
        IndexEntity rtp = new IndexEntity();
        rtp.setId("MOS_IND1");
        rtp.setName("RTP丢包率");
        rtp.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("MOS_IND1"))){
                rtp.setValue(mapget.get("MOS_IND1"));
            }
        }
        list.add(rtp);

        //获取ESRVCC切换完成率
        mapget = volteIndexDao.getESRVCCSwitch(startTime,endTime,lineId);
        IndexEntity sv = new IndexEntity();
        sv.setId("SV_IND1");
        sv.setName("ESRVCC切换完成率");
        sv.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("SV_IND1"))){
                sv.setValue(mapget.get("SV_IND1"));
            }
        }
        list.add(sv);

        //获取RRC连接建立成功率
        mapget = volteIndexDao.getRRCLogin(startTime,endTime,lineId);
        IndexEntity rpc = new IndexEntity();
        rpc.setId("UU_IND1");
        rpc.setName("RRC连接建立成功率");
        rpc.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("UU_IND1"))){
                rpc.setValue(mapget.get("UU_IND1"));
            }
        }
        list.add(rpc);

        //获取X2切换成功率
        mapget = volteIndexDao.getX2Switch(startTime,endTime,lineId);
        IndexEntity x2 = new IndexEntity();
        x2.setId("X2_IND1");
        x2.setName("X2切换成功率");
        x2.setValue("--");
        if(!mapIsBlack(mapget)){
            if(!strIsBlack(mapget.get("X2_IND1"))){
                x2.setValue(mapget.get("X2_IND1"));
            }
        }
        list.add(x2);
        return list;
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
