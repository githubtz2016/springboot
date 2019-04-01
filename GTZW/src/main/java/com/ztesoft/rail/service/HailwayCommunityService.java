package com.ztesoft.rail.service;

import com.github.pagehelper.Page;
import com.ztesoft.rail.domain.HailwayCommunity;
import com.ztesoft.rail.utils.PerformanceUtil;

import java.util.List;
import java.util.Map;

public interface HailwayCommunityService {
    List<HailwayCommunity> lineData(Integer id);
    Page<PerformanceUtil> allData(Integer pageNum, Integer pageSize, String startTime, String endTime, String index, String sequence, Integer line);
    List<PerformanceUtil> allIndexData(String startTime, String endTime, String index, Integer line);
}
