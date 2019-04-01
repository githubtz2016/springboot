<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>四川移动4G高铁专网质量分析系统-性能指标分析</title>
  <style type="text/css">
  	.div-height-100{height: 100%;}
  	.index-main-div{height: 100%;top: 44px;}
  </style>

	<%--<!-- 点聚合引用 -->
<script type="text/javascript" src="http://api.map.baidu.com/library/TextIconOverlay/1.2/src/TextIconOverlay_min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/MarkerClusterer/1.2/src/MarkerClusterer_min.js"></script>--%>



</head>
<body class="layui-layout-body" style="overflow: auto;">
<div class="layui-layout layui-layout-admin">
	<jsp:include page="top.jsp"></jsp:include>
	<!-- 查询条件 -->
	<div class="layui-row padding-top-5">
		<div class="layui-form" id="form_btn">
			<div class="layui-form-item" style="margin-bottom: 2px;">
				<div class="layui-inline">
			      	<label class="layui-form-label">时间</label>
					<div class="layui-input-inline" style="width: 100px;">
						<input type="text" name="date" id="queryDateSelectInputStart" lay-verify="date" placeholder="yyyy-MM-dd"
						  autocomplete="off" class="layui-input">
					</div>
					<div class="layui-form-mid">-</div>
					<div class="layui-input-inline" style="width: 100px;">
				    	<input type="text" name="date" id="queryDateSelectInputEnd" lay-verify="date" placeholder="yyyy-MM-dd"
						  autocomplete="off" class="layui-input">
				  </div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">高铁线路</label>
					<div class="layui-input-inline">
						<select name="interest" lay-filter="aihao11" id="road_secton">

						</select>

					</div>
				</div>

				<div class="layui-inline">
					<button class="layui-btn">查询</button>
				</div>
			</div>
		</div>
	</div>
		
	<!-- 正文三大块分区开始 -->
	<div style="background-color: #F2F2F2;">
		<div id="baiduMapMainDiv" style="position: absolute;height: 500px;background-color: #f2f2f2;width: 100%;">
			<%--地图--%>
		</div>
		<div class="layui-row">
			<div class="layui-col-md4 layui-col-md-offset8" style="padding: 10px;">
				<div class="layui-card">
					<!-- <div class="layui-card-header">高铁用户数</div> -->
					<div class="layui-card-body" style="padding: 0px;">
						<form class="layui-form" action="" style="background-color: #1E9FFF;color: white;padding-top: 3px;">
							<div class="layui-form-item" style="margin-bottom: 2px;">
								<div class="layui-inline">
									<label class="layui-form-label">排名指标</label>
									<div class="layui-input-inline" style="color: black;">
									<select name="interest" lay-filter="aihao" id="index">
										<option value="HTTP_IND1">网页浏览类页面响应成功率(%)</option>
										<option value="HTTP_IND2">页面响应平均时延(ms)</option>
										<option value="HTTP_IND5">HTTP下载速率(kbps)</option>
										<option value="FTP_IND1">应用下载速率(kbps)</option>
										<option value="IM_IND1">IM登陆成功率(%)</option>
										<option value="IM_IND2">IM 200KB以上上传速率（kbps）</option>
										<option value="IM_IND3">IM 200KB以上下载速率（kbps）</option>
										<option value="VIDEO_IND1">播放成功率(%)</option>
										<option value="VIDEO_IND2">视频下载速率（kbps）</option>
										<option value="UU_IND1">RRC连接建立成功率</option>
										<option value="S1MME_IND1">ATTACH成功率</option>
										<option value="S1MME_IND2">TAU成功率</option>

										<option value="S1MME_IND1_VOLTE">ATTACH成功率_VOLTE</option>
										<option value="S1MME_IND2_VOLTE">TAU成功率_VOLTE</option>
										<option value="VOLTE_IND5">IMS注册成功率</option>
										<option value="VOLTE_IND1">语音始呼网络接通率</option>
										<option value="VOLTE_IND2">语音终呼网络接通率</option>
										<option value="SV_IND1">ESRVCC切换完成率</option>
										<option value="MOS_IND1">RTP丢包率</option>
										<option value="UU_IND1">RRC连接建立成功率</option>
										<option value="X2_IND1">X2切换成功率</option>
									</select>

								</div>
									<input id="sequence" type="checkbox" name="open" checked="" lay-filter="switchData"  lay-skin="switch" lay-text="升序|降序">
                                        <%--<input type="radio" name="sex" value="ASC" title="升序" checked="">
                                        <input type="radio" name="sex" value="DESC" title="降序">--%>
								</div>
							</div>
						</form>
						
						<table class="layui-table" style="margin-top: 0;" >
							<thead>
							    <tr>
							      <th>小区名称</th>
							      <th id="dataIndex">页面显示成功率</th>
							    </tr> 
							  </thead>
							<tbody id="tData">

							</tbody>
						</table>
						<%--分页--%>
							<div id="demo0" style="text-align: center;" ></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</div>
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>

<%--百度API引入--%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=34dIa4NXIBEPTTlzRxXlqulgtRajP1cx"></script>

<script type="text/javascript" src="${request.getContextPath}/layui/layui.js"></script>

<script type="text/javascript" src="${request.getContextPath}/common/js/common.js"></script>


<%--高铁线路--%>
<script type="text/javascript" src="${request.getContextPath}/common/js/hailwayLine.js"></script>

<%--分页--%>
<script type="text/javascript" src="${request.getContextPath}/common/js/performanceAnalysis_pageData.js"></script>
<%--百度API--%>
<script type="text/javascript" src="${request.getContextPath}/common/js/hailwayLine_baiduapi.js"></script>
</body>
</html>