package com.ztesoft.rail.controller;

import com.ztesoft.rail.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ztesoft.rail.service.IQuotaIndexPageService;

@RestController
@RequestMapping("/index")
public class IndexPageQuotaController {
	@Autowired
	private IQuotaIndexPageService quotaServ;

	@RequestMapping(value = "/getQuota")
	public ResultMsg selectQuotaTop5(String railLine, String quota, String time) {
		ResultMsg resultMsg = new ResultMsg();
		resultMsg.setData(quotaServ.getVillageTop5(railLine, quota,  time));
		return resultMsg;
	}
}
