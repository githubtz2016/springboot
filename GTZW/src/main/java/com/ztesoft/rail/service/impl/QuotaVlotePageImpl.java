package com.ztesoft.rail.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ztesoft.rail.dao.VolteIndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztesoft.rail.dao.IQuotaVoltePageDao;
import com.ztesoft.rail.domain.VolteEntityTop5;
import com.ztesoft.rail.service.IQuotaVoltePageService;

@Service
public class QuotaVlotePageImpl implements IQuotaVoltePageService {
	@Autowired
	private IQuotaVoltePageDao volteDao;
	@Autowired
	private VolteIndexDao volteIndexDao;
	Date date;
	/* String startTime; */

	@Override
	public Map<String, VolteEntityTop5> getQuotaByQuotaIdAndTimeAndRailLine(String timeStr, String quotaId,
			String railLine) {
		String time = timeStr.replace("-", "").replace(" ", "");
		String startTime = "";
		String endTime = "";
		if (time.length() == 8) {
			startTime = time + "00";
			endTime = time + "24";
		} else {
			startTime = time;
			endTime = time;
		}
		Map<String, VolteEntityTop5> map = new HashMap<String, VolteEntityTop5>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		VolteEntityTop5 vol = new VolteEntityTop5();
		VolteEntityTop5 volForAccrete = new VolteEntityTop5();// 第一个指标有两个子指标用该对象封装子字标的名字
		if (quotaId.equals("top_middle_circle1")) {
			list = volteDao.getVolteAccrete(startTime, endTime, railLine);
			vol.setFirstQuotaName("ATTACH请求次数");
			vol.setSecondQuotaName("ATTACH成功次数");
			volForAccrete.setFirstQuotaName("TAU请求次数");
			volForAccrete.setSecondQuotaName("TAU成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
			map.put("quotaName", volForAccrete);
		} else if (quotaId.equals("top_middle_circle2")) {
			list = volteDao.getImsRegister(startTime, endTime, railLine);
			vol.setFirstQuotaName("IMS注册请求次数");
			vol.setSecondQuotaName("IMS注册成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("top_middle_circle3")) {
			list = volteDao.getVolteContinue(startTime, endTime, railLine);
			vol.setQuotaData(list);
			vol.setFirstQuotaName("语音始呼次数");
			vol.setSecondQuotaName("语音网络始呼接通次数");
			volForAccrete.setFirstQuotaName("语音终呼次数");
			volForAccrete.setSecondQuotaName("语音网络终呼接通次数");
			map.put("quota", vol);
			map.put("quotaName", volForAccrete);
		} else if (quotaId.equals("top_middle_circle4")) {
			list = volteDao.getVolteContinueTimeDelay(startTime, endTime, railLine);// 暂时改为RTP丢包率
			vol.setFirstQuotaName("RTP总包数");
			vol.setSecondQuotaName("RTP丢包数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main1")) {
			list = volteDao.getEsrvccSwitch(startTime, endTime, railLine);
			vol.setQuotaData(list);
			vol.setFirstQuotaName("ESRVCC切换请求次数");
			vol.setSecondQuotaName("ESRVCC切换完成次数");
			map.put("quota", vol);
		} else if (quotaId.equals("main2")) {
			list = volteDao.getRrcLogin(startTime, endTime, railLine);
			vol.setQuotaData(list);
			vol.setFirstQuotaName("RRC连接建立请求次数");
			vol.setSecondQuotaName("RRC连接建立成功次数");
			map.put("quota", vol);
		} else if (quotaId.equals("main3")) {
			list = volteDao.getX2Switch(startTime, endTime, railLine);
			vol.setFirstQuotaName("X2切换请求次数");
			vol.setSecondQuotaName("X2切换成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		}
		return map;
	}

	/**
	 * 获取一周的指标数据 按天查
	 */
	@Override
	public Map<String, VolteEntityTop5> getWeekQuotaByTimeAndRailLine(String timeStr, String quotaId, String railLine) {
		String time = timeStr.replace("-", "");
		String timeNew = time.replace(" ", "");
		String startTime = "";
		String endTime = "";
		if (time.equals(timeNew)) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(timeStr);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.WEEK_OF_YEAR, -1);
				date = calendar.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat(" yyyyMMdd");
				startTime = sdf.format(date);
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (time.length() == 8) {
			startTime = startTime + "00";
			endTime = time + "24";
		} else {
			startTime = time;
			endTime = time;
		}
		/*
		 * else if (!time.equals(timeNew)) { try { date = new
		 * SimpleDateFormat("yyyy-MM-dd HH").parse(timeStr); Calendar calendar =
		 * Calendar.getInstance(); calendar.setTime(date);
		 * calendar.add(Calendar.WEEK_OF_YEAR, -1); date = calendar.getTime();
		 * SimpleDateFormat sdf = new SimpleDateFormat(" yyyyMMddHH"); startTime =
		 * sdf.format(date); System.out.println(date); } catch (ParseException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } }
		 */
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		VolteEntityTop5 vol = new VolteEntityTop5();
		VolteEntityTop5 volForAccrete = new VolteEntityTop5();// 第一个指标有两个子指标用该对象封装子字标的名字
		Map<String, VolteEntityTop5> map = new HashMap<String, VolteEntityTop5>();
		if (quotaId.equals("top_middle_circle1")) {
			list = volteDao.getWeekVolteAccrete(startTime, endTime, railLine);
			vol.setFirstQuotaName("ATTACH请求次数");
			vol.setSecondQuotaName("ATTACH成功次数");
			volForAccrete.setFirstQuotaName("TAU请求次数");
			volForAccrete.setSecondQuotaName("TAU成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
			map.put("quotaName", volForAccrete);
		} else if (quotaId.equals("top_middle_circle2")) {
			list = volteDao.getWeekImsRegister(startTime, endTime, railLine);
			vol.setFirstQuotaName("IMS注册请求次数");
			vol.setSecondQuotaName("IMS注册请求成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("top_middle_circle3")) {
			list = volteDao.getWeekVolteContinue(startTime, endTime, railLine);
			vol.setFirstQuotaName("语音始呼次数");
			vol.setSecondQuotaName("语音网络始呼接通次数");
			volForAccrete.setFirstQuotaName("语音终呼次数");
			volForAccrete.setSecondQuotaName("语音网络终呼接通次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
			map.put("quotaName", volForAccrete);
		} else if (quotaId.equals("top_middle_circle4")) {
			list = volteDao.getWeekVolteContinueTimeDelay(startTime, endTime, railLine);// 这指标暂时改为irtp丢包率的
			vol.setFirstQuotaName("RTP总包数");
			vol.setSecondQuotaName("RTP丢包数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main1")) {
			list = volteDao.getWeekEsrvccSwitch(startTime, endTime, railLine);
			vol.setFirstQuotaName("ESRVCC切换请求次数");
			vol.setSecondQuotaName("ESRVCC切换完成次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main2")) {
			list = volteDao.getWeekRrcLogin(startTime, endTime, railLine);
			vol.setFirstQuotaName("RRC连接建立请求次数");
			vol.setSecondQuotaName("RRC连接建立成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main3")) {
			list = volteDao.getWeekX2Switch(startTime, endTime, railLine);
			vol.setFirstQuotaName("X2切换请求次数");
			vol.setSecondQuotaName("X2切换成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		}
		return map;
	}

	/**
	 * 获取一周的数据按小时查
	 */

	@Override
	public Map<String, VolteEntityTop5> getWeekQuotaForHour(String time, String quotaId, String railLine) {
		List<String> quota = new ArrayList<String>();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String timStr = time.replace("-", "").replaceAll(" ", "");
		quota.add(timStr);
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH").parse(time);
			SimpleDateFormat sdf = new SimpleDateFormat(" yyyyMMddHH");
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(date);
			rightNow.add(Calendar.DATE, -1);
			Date dt1 = rightNow.getTime();
			String time1 = sdf.format(dt1);
			quota.add(time1);

			rightNow.setTime(dt1);
			rightNow.add(Calendar.DATE, -1);
			Date dt2 = rightNow.getTime();
			String time2 = sdf.format(dt2);
			quota.add(time2);

			rightNow.setTime(dt2);
			rightNow.add(Calendar.DATE, -1);
			Date dt3 = rightNow.getTime();
			String time3 = sdf.format(dt3);
			quota.add(time3);

			rightNow.setTime(dt3);
			rightNow.add(Calendar.DATE, -1);
			Date dt4 = rightNow.getTime();
			String time4 = sdf.format(dt4);
			quota.add(time4);

			rightNow.setTime(dt4);
			rightNow.add(Calendar.DATE, -1);
			Date dt5 = rightNow.getTime();
			String time5 = sdf.format(dt5);
			quota.add(time5);

			rightNow.setTime(dt5);
			rightNow.add(Calendar.DATE, -1);
			Date dt6 = rightNow.getTime();
			String time6 = sdf.format(dt6);
			quota.add(time6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Map<String, VolteEntityTop5> map = new HashMap<String, VolteEntityTop5>();
		VolteEntityTop5 vol = new VolteEntityTop5();
		VolteEntityTop5 volTwo = new VolteEntityTop5();
		if (quotaId.equals("top_middle_circle1")) {
			vol.setFirstQuotaName("ATTACH请求次数");
			vol.setSecondQuotaName("ATTACH成功次数");
			volTwo.setFirstQuotaName("TAU请求次数");
			volTwo.setSecondQuotaName("TAU成功次数");
			list = volteDao.getWeekVolteAccreteHour(quota, railLine);
			vol.setQuotaData(list);
			map.put("quotaHourFirst", volTwo);
			map.put("quotaHour", vol);
		} else if (quotaId.equals("top_middle_circle2")) {
			vol.setFirstQuotaName("IMS注册请求次数");
			vol.setSecondQuotaName("IMS注册请求成功次数");
			list = volteDao.getWeekImsRegisterHour(quota, railLine);
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("top_middle_circle3")) {
			vol.setFirstQuotaName("语音始呼次数");
			vol.setSecondQuotaName("语音网络始呼接通次数");
			volTwo.setFirstQuotaName("语音终呼次数");
			volTwo.setSecondQuotaName("语音网络终呼接通次数");
			list = volteDao.getWeekVolteContinueHour(quota, railLine);
			vol.setQuotaData(list);
			map.put("quotaHourFirst", volTwo);
			map.put("quotaHour", vol);
		} else if (quotaId.equals("top_middle_circle4")) {
			list = volteDao.getWeekVolteContinueTimeDelayHour(quota, railLine);
			vol.setFirstQuotaName("RTP总包数");
			vol.setSecondQuotaName("RTP丢包数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main1")) {
			vol.setFirstQuotaName("ESRVCC切换请求次数");
			vol.setSecondQuotaName("ESRVCC切换完成次数");
			list = volteDao.getWeekEsrvccSwitcHour(quota, railLine);
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main2")) {
			list = volteDao.getWeekRrcLoginHour(quota, railLine);
			vol.setFirstQuotaName("RRC连接建立请求次数");
			vol.setSecondQuotaName("RRC连接建立成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		} else if (quotaId.equals("main3")) {
			list = volteDao.getWeekX2SwitchHour(quota, railLine);
			vol.setFirstQuotaName("X2切换请求次数");
			vol.setSecondQuotaName("X2切换成功次数");
			vol.setQuotaData(list);
			map.put("quota", vol);
		}
		return map;
	}

	@Override
	public List<Map<Object, Object>> getInfoByQuota(String quotaId, String time, String lineId) {
		List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
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
		if(quotaId.equals("main3")){
			list = volteIndexDao.getX2SwitchInfo(startTime,endTime,lineId);
		}else if(quotaId.equals("main1")){
			list = volteIndexDao.getESRVCCInfo(startTime,endTime,lineId);
		}else if(quotaId.equals("top_middle_circle1")){
			list = volteIndexDao.getVolteAccreteInfo(startTime,endTime,lineId);
		}else if(quotaId.equals("top_middle_circle2")){
			list = volteIndexDao.getImsRegisterInfo(startTime,endTime,lineId);
		}else if(quotaId.equals("top_middle_circle3")){
			list = volteIndexDao.getVolteContinueInfo(startTime,endTime,lineId);
		}else if(quotaId.equals("top_middle_circle4")){
			list = volteIndexDao.getRTPInfo(startTime,endTime,lineId);
		}
		return list;
	}

	public List<Map<String, String>> addTime(List<Map<String, String>> list, List<String> timeList) {
		for(int i=0;i<list.size();i++) {
			for(int j = 0;j<timeList.size();j++) {
				/*if(!list[i]==timeList[j])*/
			}
		}
		return null;
	}

}
