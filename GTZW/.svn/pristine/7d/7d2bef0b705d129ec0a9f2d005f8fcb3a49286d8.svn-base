package com.ztesoft.rail.service;

import java.util.List;
import java.util.Map;

import com.ztesoft.rail.domain.VolteEntityTop5;

public interface IQuotaVoltePageService {
	public Map<String, VolteEntityTop5> getQuotaByQuotaIdAndTimeAndRailLine(String time, String quotaId,
			String railLine);

	public Map<String, VolteEntityTop5> getWeekQuotaByTimeAndRailLine(String time, String quotaId, String railLine);

	public Map<String, VolteEntityTop5> getWeekQuotaForHour(String time, String quotaId, String railLine);

	List<Map<Object,Object>> getInfoByQuota(String quotaId,String time,String lineId);
}
