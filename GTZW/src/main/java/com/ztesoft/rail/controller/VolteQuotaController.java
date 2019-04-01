package com.ztesoft.rail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ztesoft.rail.service.IQuotaVoltePageService;
import com.ztesoft.rail.utils.ResultMsg;

@RestController
@RequestMapping("/volte")
public class VolteQuotaController {

	@Autowired
	private IQuotaVoltePageService volteService;

	/**
	 * 取各個指指標的數據
	 * 
	 * @return
	 */
	@GetMapping("/getQuotaData")
	public ResultMsg getQuotaData(String time, String quotaId, String railLine) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setData(volteService.getQuotaByQuotaIdAndTimeAndRailLine(time, quotaId, railLine));
		return resultMsg;
	}

	/**
	 * 获取一周的数据按天分组
	 * 
	 * @param time
	 * @param quotaId
	 * @param railLine
	 * @return
	 */
	@GetMapping("/getWeekQuotaData")
	public ResultMsg getWeekQuotaData(String time, String quotaId, String railLine) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setData(volteService.getWeekQuotaByTimeAndRailLine(time, quotaId, railLine));
		return resultMsg;
	}

	//获取一周的数据按小时分组
	@GetMapping("/getWeekQuotaForHour")
	public ResultMsg getWeekQuotaDataForHour(String time, String quotaId, String railLine) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setData(volteService.getWeekQuotaForHour(time, quotaId, railLine));
		return resultMsg;
	}

	//获取指标详情信息
	@GetMapping("/getInfoByQuota")
	public ResultMsg getInfoByQuota(String quotaId,String time,String railLine) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setData(volteService.getInfoByQuota(quotaId,time,railLine));
		return resultMsg;
	}
}
