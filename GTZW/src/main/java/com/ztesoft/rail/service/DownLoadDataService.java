package com.ztesoft.rail.service;

import java.util.List;
import java.util.Map;

public interface DownLoadDataService {
	List<Map<String,String>> getfirstPage(String time,String lineId);
	List<Map<String,String>> getvoltePage(String time,String lineId);
}
