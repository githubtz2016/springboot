package com.ztesoft.rail.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuotaIndexPageDao {
	// 通过网页浏览类页面响应成功率(%)
	public List<Map<String,String>> getFirstTop5ByHTTP_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByHTTP_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// 通过页面平均时延
	public List<Map<String,String>> getFirstTop5ByHTTP_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByHTTP_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// HTTP下载速率
	public List<Map<String,String>> getFirstTop5ByHTTP_IND5(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByHTTP_IND5(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// 应用下载下载速率
	public List<Map<String,String>> getFirstTop5ByFTP_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByFTP_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// IM登陆成功率(%)
	public List<Map<String,String>> getFirstTop5ByIM_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByIM_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// IM 200KB以上上传速率（kbps）
	public List<Map<String,String>> getFirstTop5ByIM_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByIM_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// IM 200KB以上下载速率（kbps）
	public List<Map<String,String>> getFirstTop5ByIM_IND3(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByIM_IND3(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// 播放成功率(%)
	public List<Map<String,String>> getFirstTop5ByVIDEO_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByVIDEO_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// 视频下载速率
	public List<Map<String,String>> getFirstTop5ByVIDEO_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByVIDEO_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// RRC连接建立成功率
	public List<Map<String,String>> getFirstTop5ByUU_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByUU_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// ATTACH成功率
	public List<Map<String,String>> getFirstTop5ByS1MME_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByS1MME_IND1(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	// TAU成功率
	public List<Map<String,String>> getFirstTop5ByS1MME_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public List<Map<String,String>> getLastTop5ByS1MME_IND2(@Param("railLine")String railLine, @Param("quota")String quota,@Param("startTime")String startTime,@Param("endTime")String endTime);

}
