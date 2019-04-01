<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <script type="text/javascript" src="/webjars/echarts/4.0.4/dist/echarts.js"></script>
  <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
  <script src="common/js/common.js"></script>
  
<!--   <script src="js/index.js"></script> -->
  <title>四川移动4G高铁专网质量分析系统</title>
  <style type="text/css">
  
  	/* #top_middle_circle1,#top_middle_circle2,#top_middle_circle3,#top_middle_circle4{margin:0 30px;} */
  </style>
</head>
<body class="layui-layout-body" style="overflow: auto;">
<div class="layui-layout layui-layout-admin">
	<div id="top">
	<jsp:include page="top.jsp"></jsp:include>
	</div>
	<!--  查询条件-->
	<div class="layui-row padding-top-5">
		<div class="layui-form">
			<div class="layui-form-item" style="margin-bottom: 2px;">
				<div class="layui-inline">
					<label class="layui-form-label">线路</label>
					<div class="layui-input-inline">
						<select name="railLine" lay-filter="railLine" id="railLine">
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">时间颗粒度</label>
					<div class="layui-input-inline">
						<select name="timeSize" lay-filter="timeSize" id="timeSize">
							<option value="1" selected="">天</option>
							<option value="2">小时</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">查询时间</label>
					<div class="layui-input-inline">
						 <input type="text" name="date" id="queryDateSelectInput1"  lay-verify="date" placeholder="yyyy-MM-dd"
						  autocomplete="off" class="layui-input">
					</div>
					<div class="layui-input-inline">
							<input style="display:none;" type="text" name="date" value="" id="queryDateSelectInput2"
								lay-verify="date" placeholder="yyyy-MM-dd HH" autocomplete="off"
								class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<button class="layui-btn" onclick="selectQuotaByTimeAndRailline()">查询</button>
                    <button class="layui-btn" onclick="">导出</button>
				</div>
			</div>
		</div>
	</div>
<!-- 	第一部分 -->
<div style="padding: 10px; background-color: #F2F2F2;">
			<div class="layui-row layui-col-space15">
	<div class="layui-row" id="bod" >
		<!--第一部分的左 四个仪表盘 -->
		 <!-- <div class="layui-col-md7">
		 	<div class="layui-row"> 	
		 	<div class="layui-col-md12" >
		 		<div class="layui-card">
						<div class="layui-card-body">
							<div class="layui-row">
					 			<div class="layui-col-md3" id="top_middle_circle1" style="height:144px;padding-left:30px;" onclick="selectQuotaByQuotaId('top_middle_circle1')"></div>
					 			<div class="layui-col-md3" id="top_middle_circle2" style="height:144px;" onclick="selectQuotaByQuotaId('top_middle_circle2')"></div>
					 			<div class="layui-col-md3" id="top_middle_circle3" style="height:144px;" onclick="selectQuotaByQuotaId('top_middle_circle3')"></div>
					 			<div class="layui-col-md3" id="top_middle_circle4" style="height:144px;margin-rirht:-30px;" onclick="selectQuotaByQuotaId('top_middle_circle4')"></div>
					 		</div>
						</div>
					</div>
		 	</div>
		 	</div>
		</div> -->
		<!--第一部分右边三个仪表盘  -->
		<!--  <div class="layui-col-md5">
		 	<div class="layui-row">
		 		 <div class="layui-row" style="background-color:white;height:154px;padding-top:10px;" >
			 		<div class="layui-col-md4" id="main1" style="height:144px;" onclick="selectQuotaByQuotaId('main1')"></div>
			 		<div class="layui-col-md4" id="main2" style="height:144px;" onclick="selectQuotaByQuotaId('main2')"></div>
			 		<div class="layui-col-md4" id="main3" style="height:144px;" onclick="selectQuotaByQuotaId('main3')"></div>
		 		</div>
		 	</div>
		 </div> -->
		 
		 <!-- 仪表盘 -->
		 <div class="layui-col-md12" >
		 		<div class="layui-card">
						<div class="layui-card-body">
							<div class="layui-row">
					 			<div class="layui-col-md2" id="top_middle_circle1" style="height:144px;padding-left:30px;" onclick="selectQuotaByQuotaId('top_middle_circle1')"></div>
					 			<div class="layui-col-md2" id="top_middle_circle2" style="height:144px;" onclick="selectQuotaByQuotaId('top_middle_circle2')"></div>
					 			<div class="layui-col-md2" id="top_middle_circle3" style="height:144px;" onclick="selectQuotaByQuotaId('top_middle_circle3')"></div>
					 			<div class="layui-col-md2" id="top_middle_circle4" style="height:144px;margin-rirht:-30px;" onclick="selectQuotaByQuotaId('top_middle_circle4')"></div>
					 			<div class="layui-col-md2" id="main1" style="height:144px;" onclick="selectQuotaByQuotaId('main1')"></div>
			 					<div class="layui-col-md2" id="main3" style="height:144px;" onclick="selectQuotaByQuotaId('main3')"></div>
					 		</div>
						</div>
					</div>
		 	</div>
		 
		 
	</div>
	
	<!--第二部分  -->
	<div class="layui-row" id="bod2">
		<!--第二部分左边  -->
		<div class="layui-col-md7" id="bod2_1">
			<div class="layui-row" id="bod2_1_1" style="min-height:150px;">
			<div class="layui-card">
						<div class="layui-card-header" id="setTitle">volte附着阶段得分</div>
						<div class="layui-card-body" style="padding: 2px;min-height: 231px;">
							<table class="layui-table" style="margin-top: 0;" id="quota_table">
							  <thead>
							    <tr>
							      <th>排名</th>
							      <th>地市</th>
							      <th>volte附着请求次数</th>
							      <th>volte附着请求成功次数</th>
							    </tr> 
							  </thead>
							  <tbody>
								</tbody>
							</table>
						</div>
					</div>
			</div>
			<div class="layui-row">
					<div class="layui-card">
						<div class="layui-card-header">趋势分析</div>
						<div class="layui-card-body">
							<div style="width: 100%;height: 200px;" id="echart">

							</div>
						</div>
					</div>
			</div>
		</div>
		<!--第二部分右边  -->
		<div class="layui-col-md5" >
		    <div class="layui-row" style="margin-left:10px;">
		    	<div class="layui-card">
						<div class="layui-card-header">详情展示</div>
						<%--<div class="layui-card-body" style="height:488px;">--%>
							<%--<div id="circle" style="height:488px;width:400px;margin-top:-120px;margin-left:100px;">--%>
						<%----%>
							<%--</div>--%>
						<%--</div>--%>
						<div class="layui-card-body" style="padding: 2px;min-height:220px;">
							<table class="layui-table" style="margin-top: 0;">
								<thead>
								<tr>
									<th>小区名称</th>
									<th style="width:45px;">归属地</th>
									<th>值</th>
								</tr>
								</thead>
								<tbody id="tbodytop10">

								</tbody>
							</table>
						</div>
					</div>
		    </div>			
		</div>
	</div>
</div>
</div>

		<jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
<script src="common/js/quota.js"></script>
</html>