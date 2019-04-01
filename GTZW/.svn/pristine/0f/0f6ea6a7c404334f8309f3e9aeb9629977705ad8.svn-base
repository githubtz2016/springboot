<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>四川移动4G高铁专网质量分析系统-场景监控</title>
  <style type="text/css">
  	.div-height-100{height: 100%;}
  	.index-main-div{height: 100%;top: 44px;}
  	#leftDataShowTable1 td{padding: 10px 5px;}
  	#leftDataShowTable2 td{padding: 8px 5px;}
  	.numberProminent{font-size: 20px;color: #ff5722;font-weight:800;font-style: oblique;}
  </style>
	<script type="text/javascript" src="webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="common/js/common.js"></script>
	<script type="text/javascript" src="common/js/highway_scenes.js"></script>
	<script type="text/javascript" src="/webjars/echarts/4.0.4/dist/echarts.min.js"></script>
	<script type="text/javascript" src="/webjars/echarts/4.0.4/map/js/province/sichuan.js"></script>
</head>
<style>
	#leftDataShowTable1,#leftDataShowTable2{
		font-size: 10px;
	}
</style>
<body class="layui-layout-body" style="overflow: auto;background-color: #2F4056;color: white;font-size:16px;">
<div class="layui-layout layui-layout-admin">
	<div id="topDiv">
		<jsp:include page="top.jsp"></jsp:include>
	</div>
		
	<!-- 正文 -->
	<div class="layui-row">
		<!-- 左侧 -->
		<div class="layui-col-xs4">
			<!-- 左侧第一块 -->
			<div style="padding: 5px 10px;font-size: 36px;font-weight:900;color: yellow;">
				<div >高铁场景监控—<span style="font-size: 24px;">全路线</span></div>
			</div>
			<div class="layui-row">
				<table style="width: 100%;" id="leftDataShowTable1">
					<tr>
						<td style="text-align: right;">4G用户数：</td>
						<td><span class="numberProminent">36128</span>  人</td>
						<td style="text-align: right;">VOLTE活跃用户数：</td>
						<td><span class="numberProminent">36128</span>  人</td>
					</tr>
					<tr>
						<td style="text-align: right;">总流量：</td>
						<td><span class="numberProminent">36128</span>  GB</td>
						<td style="text-align: right;">VOLTE话务量（ERL）：</td>
						<td><span class="numberProminent">36128</span>  小时</td>
					</tr>
				</table>
			</div>
			<!-- 左侧第二块 -->
			<div style="padding: 5px 10px;font-size: 26px;font-weight:900;color: yellow;">
				<div><i class="layui-icon" style="font-size:36px;">&#xe604;</i>  热门应用TOP3</div>
			</div>
			<div class="layui-row">
				<table style="width: 100%;" id="leftDataShowTable2">
					<tr>
						<td style="text-align:center;" colspan="1">（HTTP类）流量</td>
						<td style="text-align:center;" colspan="1">（视频类）流量</td>
						<td style="text-align:center;" colspan="1">（IM类）流量</td>
						<td style="text-align:center;" colspan="1">（FTP下载类）流量</td>
					</tr>
					<tr>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
					</tr>
					<tr>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
					</tr>
					<tr>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
						<td style="text-align: right;">应用名称：    MB</td>
					</tr>
					<%--<tr>--%>
						<%--<td style="text-align: right;">话务量：</td>--%>
						<%--<td><span class="numberProminent">36128</span>  万人</td>--%>
						<%--<td style="text-align: right;">4G流量：</td>--%>
						<%--<td><span class="numberProminent">36128</span>  GB</td>--%>
					<%--</tr>--%>
				</table>
			</div>
			
			<!-- 左侧第三块 -->
			<div style="padding: 5px 10px;font-size: 26px;font-weight:900;color: yellow;">
				<div><i class="layui-icon" style="font-size:36px;">&#xe66a;</i>  用户终端分布</div>
			</div>
			<div class="layui-row" style="height: 450px;width: 100%;margin-top: -50px;" id="rose">

			</div>
		</div>
		<!-- 中部 -->
		<div class="layui-col-xs4">
			<div class="layui-row">
				<div id="map" style="height: 600px;margin-top: -100px;">
				</div>
			</div>
			
			<!-- 中部第二块 -->
			<div style="padding: 5px 10px;font-size: 26px;font-weight:900;color: yellow;margin-top: -100px;">
				<div><i class="layui-icon" style="font-size:36px;">&#xe62c;</i>  高铁用户变化趋势</div>
			</div>
			<div class="layui-row">
				<div id="userChange" style="height: 300px;"></div>
			</div>
		</div>
		<!-- 右侧 -->
		<div class="layui-col-xs4">
			<!-- 四个图表 -->
			<div class="layui-row" style="">
				<div class="layui-col-xs6" id="dashboard1" style="min-height: 180px;text-align: center;">

				</div>
				<div class="layui-col-xs6" id="dashboard2" style="min-height: 180px;text-align: center;">

				</div>
				<div class="layui-col-xs6" id="dashboard3" style="min-height: 180px;text-align: center;">

				</div>
				<div class="layui-col-xs6" id="dashboard4" style="min-height: 180px;text-align: center;">

				</div>
			</div>
			<!--  -->
			<div style="padding: 5px 10px;font-size: 26px;font-weight:900;color: yellow;margin-top: 30px;">
				<div><i class="layui-icon" style="font-size:36px;">&#xe62a;</i>  高流量车站用户数</div>
			</div>
			<div class="layui-row" id="station" style="height: 300px;margin-top: -50px;">

			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</div>


<script type="text/javascript">

layui.use(['form','laydate'], function(){
	  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
	  
	  //但是，如果你的HTML是动态生成的，自动渲染就会失效
	  //因此你需要在相应的地方，执行下述方法来手动渲染，跟这类似的还有 element.init();
	  form.render();
	  
	  var laydate = layui.laydate;
	  laydate.render({
		    elem: '#queryDateSelectInput',//指定元素
		    type: 'datetime'
		  });
	});      
</script>
</body>
</html>