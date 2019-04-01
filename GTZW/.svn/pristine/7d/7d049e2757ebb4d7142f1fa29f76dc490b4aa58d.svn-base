package com.ztesoft.rail.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuotaVoltePageDao {

	/* 取VOLTE附著階段的數據 */
	public List<Map<String, String>> getVolteAccrete(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取IMS附著階段的數據 */
	public List<Map<String, String>> getImsRegister(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取VOLTE持续階段的數據 */
	public List<Map<String, String>> getVolteContinue(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取VOLTE持續時延階段的數據 */
	public List<Map<String, String>> getVolteContinueTimeDelay(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取ESRVCC切換得分數據 */
	public List<Map<String, String>> getEsrvccSwitch(@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取RRC連接得分數據 */
	public List<Map<String, String>> getRrcLogin(@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("railLine") String railLine);

	/* 取x2切換得分數據 */
	public List<Map<String, String>> getX2Switch(@Param("startTime") String startTime, @Param("endTime") String endTime,
			@Param("railLine") String railLine);

	/* 获取一周的volte附着阶段的数据 */
	public List<Map<String, String>> getWeekVolteAccrete(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 获取IMS附着阶段一周的数据 */
	public List<Map<String, String>> getWeekImsRegister(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取VOLTE一周持续階段的數據 */
	public List<Map<String, String>> getWeekVolteContinue(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取VOLTE一周持續時延階段的數據 */
	public List<Map<String, String>> getWeekVolteContinueTimeDelay(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取ESRVCC一周切換得分數據 */
	public List<Map<String, String>> getWeekEsrvccSwitch(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取RRC一周連接得分數據 */
	public List<Map<String, String>> getWeekRrcLogin(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/* 取x2一周切換得分數據 */
	public List<Map<String, String>> getWeekX2Switch(@Param("startTime") String satrtTime,
			@Param("endTime") String endTime, @Param("railLine") String railLine);

	/*
	 * 获取一周内某个时段的数据
	 */
	public List<Map<String, String>> getWeekVolteAccreteHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekImsRegisterHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekVolteContinueHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekVolteContinueTimeDelayHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekEsrvccSwitcHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekRrcLoginHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);

	public List<Map<String, String>> getWeekX2SwitchHour(@Param("quota") List<String> quota,
			@Param("railLine") String railLine);
}
