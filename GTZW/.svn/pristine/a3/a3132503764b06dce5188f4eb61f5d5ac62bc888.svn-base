package com.ztesoft.rail.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.ztesoft.rail.dao.IQuotaIndexPageDao;
import com.ztesoft.rail.service.IQuotaIndexPageService;

@Service
public class QuotaIndexPageImpl implements IQuotaIndexPageService {
	@Autowired
	private IQuotaIndexPageDao quotaDao;

	@Override
	public Map<String, List<?>> getVillageTop5(String railLine, String quota,String timeStr) {
//		if (StringUtils.isEmpty(quota) || StringUtils.isEmpty(timeStr)) {
//			return null;
//		}
		Map<String, List<?>> map = new HashMap<String, List<?>>();
		List<Map<String,String>> listFirst5 = new ArrayList<Map<String, String>>();
		List<Map<String,String>> listLast5 = new ArrayList<Map<String, String>>();
		//日期处理
		String time = timeStr.replace("-","").replace(" ", "");
		//判断时间位数
		String startTime = "";
		String endTime = "";
		if(time.length()==8){
			startTime = time+"00";
			endTime = time+"24";
		}else{
			startTime = time;
			endTime = time;
		}
		if (quota.equals("HTTP_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByHTTP_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByHTTP_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		}else if (quota.equals("HTTP_IND2")) {
			listFirst5 = quotaDao.getFirstTop5ByHTTP_IND2(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByHTTP_IND2(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("HTTP_IND5")) {
			listFirst5 = quotaDao.getFirstTop5ByHTTP_IND5(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByHTTP_IND5(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("FTP_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByFTP_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByFTP_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("IM_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByIM_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByIM_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("IM_IND2")) {
			listFirst5 = quotaDao.getFirstTop5ByIM_IND2(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByIM_IND2(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("IM_IND3")) {
			listFirst5 = quotaDao.getFirstTop5ByIM_IND3(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByIM_IND3(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("VIDEO_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByVIDEO_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByVIDEO_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("VIDEO_IND2")) {
			listFirst5 = quotaDao.getFirstTop5ByVIDEO_IND2(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByVIDEO_IND2(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("UU_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByUU_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByUU_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("S1MME_IND1")) {
			listFirst5 = quotaDao.getFirstTop5ByS1MME_IND1(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByS1MME_IND1(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		} else if (quota.equals("S1MME_IND2")) {
			listFirst5 = quotaDao.getFirstTop5ByS1MME_IND2(railLine,quota,startTime,endTime);
			listLast5 = quotaDao.getLastTop5ByS1MME_IND2(railLine,quota,startTime,endTime);
			map.put("first5", listFirst5);
			map.put("last5", listLast5);
		}
		return map;
	}
}
