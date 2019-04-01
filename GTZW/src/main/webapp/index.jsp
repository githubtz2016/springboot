<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript"
	src="webjars/echarts/4.0.4/dist/echarts.js"></script>

<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="common/js/common.js"></script>
<title>四川移动4G高铁专网质量分析系统</title>
<style type="text/css">
.div-height-100 {
	height: 100%;
}

.index-main-div {
	height: 100%;
	top: 44px;
}

.select-tr {
	background-color: #cce7fb;
}

</style>
</head>
<body class="layui-layout-body" style="overflow: auto;">
	<div class="layui-layout layui-layout-admin">
		<jsp:include page="top.jsp"></jsp:include>
		<!-- 查询条件 -->
		<div class="layui-row padding-top-5">
			<div class="layui-form">
				<div class="layui-form-item" style="margin-bottom: 2px;">
					<div class="layui-inline">
						<label class="layui-form-label">线路</label>
						<div class="layui-input-inline">
							<select name="hailway_line" lay-filter="aihao" id="hailway_line">

							</select>
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">时间粒度</label>
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
							<input type="text" name="date" value="" id="queryDateSelectInput1"
								lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
								class="layui-input">
							<input style="display:none;" type="text" name="date" value="" id="queryDateSelectInput2"
								lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
								class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<button class="layui-btn sel_btn" onclick="selectDataByParam()" />
						查询
						</button>
						<button class="layui-btn download_btn" onclick="downloadData()" />
						导出
						</button>
					</div>
				</div>
			</div>
		</div>

		<!-- 正文三大块分区开始 -->
		<div style="padding: 10px; background-color: #F2F2F2;">
			<div class="layui-row layui-col-space15">
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">高铁各项指标一览</div>
						<div class="layui-card-body" style="padding: 2px;">
							<table class="layui-table" style="margin-top: 0;" id="quotaList">
								<tbody>
								</tbody>
							</table>
						</div>
					</div>

					<!-- <div class="layui-card" style="margin-top: 10px;">
						<div class="layui-card-header">4G时长驻留比</div>
						<div class="layui-card-body" style="padding: 2px;">
							<div style="height: 200px;" id="echart">
								
							</div>
						</div>
					</div> -->
				</div>

				<!-- 正文中间地图 -->
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" id="mapDiv">地图一览</div>
						<div class="layui-card-body">
							<div style="width: 100%; height: 527px;" id="map"></div>
						</div>
					</div>
				</div>

				<!-- 正文右侧 -->
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header" id="topDiv">小区TOP5_</div>
						<div class="layui-card-body" style="padding: 2px;min-height:220px;">
							<table class="layui-table" style="margin-top: 0;">
								<thead>
									<tr>
										<th>小区名称</th>
										<th style="width:45px;">归属地</th>
										<th>值</th>
									</tr>
								</thead>
								<tbody id="tbodytop5">
								</tbody>
							</table>
						</div>
					</div>

					<div class="layui-card">
						<div class="layui-card-header" id="lastDiv">小区低用户TOP5_</div>
						<div class="layui-card-body" style="padding: 2px;min-height:220px;">
							<table class="layui-table" style="margin-top: 0;">
								<thead>
									<tr>
										<th>小区名称</th>
										<th style="width:45px;">归属地</th>
										<th>值</th>
									</tr>
								</thead>
								<tbody id="tbodylast5">

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=rO7sMXRQeY0cikMDTj0Ml5onv3ds8dzg"></script>
<script src="common/js/hailwayLine_baiduapiForIndex.js"></script>
	<script type="text/javascript">

layui.use(['form','laydate'], function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  var laydate = layui.laydate;
	  var nowTime = new Date();
	  laydate.render({
		    elem: '#queryDateSelectInput1',//指定元素
		    type: "date",
		    format:'yyyy-MM-dd',
		  	value:nowTime
		  });
	  laydate.render({
		    elem: '#queryDateSelectInput2',//指定元素
		    type: "datetime",
		    format:'yyyy-MM-dd HH',
		  	value:nowTime
		  });
	  form.on('select(timeSize)', function(data){
		  lay(data);
	  });
	  function lay(data){
		  if(data.value=="1"){
			  document.getElementById("queryDateSelectInput1").style.display='block';
			  document.getElementById("queryDateSelectInput2").style.display='none';
		  }else if(data.value=='2'){
			  document.getElementById("queryDateSelectInput1").style.display='none';
			  document.getElementById("queryDateSelectInput2").style.display='block';
		  }
	  }
	  //但是，如果你的HTML是动态生成的，自动渲染就会失效
	  //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
      //初始化下拉框
	  init_hailway_line();

	});
</script>
</body>
<script src="common/js/index.js"></script>
</html>