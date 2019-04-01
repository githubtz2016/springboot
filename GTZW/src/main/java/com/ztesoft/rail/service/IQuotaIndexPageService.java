package com.ztesoft.rail.service;

import java.util.List;
import java.util.Map;

public interface IQuotaIndexPageService {
	public Map<String, List<?>> getVillageTop5(String railLine, String quota, String time);
}
