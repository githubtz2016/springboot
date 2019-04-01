layui
		.use(
				[ 'form', 'laydate' ],
				function() {
					var form = layui.form; // 只有执行了这一步，部分表单元素才会自动修饰成功
					var laydate = layui.laydate;
					var nowTime = new Date();
					laydate.render({
						elem : '#queryDateSelectInput1',// 指定元素
						type : "date",
						format : 'yyyy-MM-dd',
						value : nowTime
					});
					laydate.render({
						elem : '#queryDateSelectInput2',// 指定元素
						type : "datetime",
						format : 'yyyy-MM-dd HH'
					});
					form.on('select(timeSize)', function(data) {
						lay(data);
					});

					function lay(data) {
						if (data.value == "1") {
							document.getElementById("queryDateSelectInput1").style.display = 'block';
							document.getElementById("queryDateSelectInput2").style.display = 'none';
						} else if (data.value == '2') {
							document.getElementById("queryDateSelectInput1").style.display = 'none';
							document.getElementById("queryDateSelectInput2").style.display = 'block';
						}
					}
					/* ***********************条形图的数据** */

					/** **********************仪表盘的数据**************** */
					var dash_VolteAccrete;// VOLTE附着阶段得分
					var dash_ImsRegister;// IMS注册阶段得分
					var dash_VolteContinue;// VOLTE持续阶段得
					var dash_RtpLose;// RTP丢包率得分
					var dash_ESRVCC_Switch;// ESRVCC切换得分
					var dash_RRC_Login;// RRC连接得分
					var dash_X2_Switch;// x2切换得分
					/** **********************饼图的数据****************** */
					var pie;
					/* 初始化铁路线 */
					getRailLineName();
					/* 初始化指标 */
					init_QuotaByTimeAndRailline();

					/* 初始化饼图的方法 */
					//initial_circle();
					/* 初始化趋势分析柱形图的方法 */
					// init_trend('','','','','','','','','','');
					$("#top_middle_circle1").click(function() {
						getdata('top_middle_circle1');
					});
					$("#top_middle_circle2").click(function() {
						getdata('top_middle_circle2');
					});
					$("#top_middle_circle3").click(function() {
						getdata('top_middle_circle3');
					});
					$("#top_middle_circle4").click(function() {
						getdata('top_middle_circle4');
					});
					$("#main1").click(function() {
						getdata('main1');
					});
					$("#main2").click(function() {
						getdata('main2');
					});
					$("#main3").click(function() {
						getdata('main3');
					});

					// 默认加载
					getdata('top_middle_circle1');

					/* 初始化表格的方法 */
					init_table();
				});

/** **********************仪表盘的数据Title**************** */
var VolteAccreteTitle;// VOLTE附着阶段得分
var ImsRegisterTitle;// IMS注册阶段得分
var VolteContinueTitle;// VOLTE持续阶段得
var VolteContinueTimeDelayTitle;// RTP丢包率得分
var ESRVCC_SwitchTitle;// ESRVCC切换得分
var RRC_LoginTitle;// RRC连接得分
var X2_SwitchTitle;// x2切换得分
/** ******************************************************* */
$("#top_middle_circle1").on('click', function() {
	setTitle('top_middle_circle1')
});
$("#top_middle_circle2").on('click', function() {
	setTitle('top_middle_circle2')
});
$("#top_middle_circle3").on('click', function() {
	setTitle('top_middle_circle3')
});
$("#top_middle_circle4").on('click', function() {
	setTitle('top_middle_circle4')
});
$("#main1").on('click', function() {
	setTitle('main1')
});
$("#main2").on('click', function() {
	setTitle('main2')
});
$("#main3").on('click', function() {
	setTitle('main3')
});

// 动态的给top5的标题赋值
function setTitle(e) {
	var title = $("#setTitle");
	if (e == "top_middle_circle1") {
		title.html("volte附着阶段top5");
	} else if (e == "top_middle_circle2") {
		title.html("IMS注册阶段top5");
	} else if (e == "top_middle_circle3") {
		title.html("volte持续阶段top5");
	} else if (e == "top_middle_circle4") {
		title.html("RTP丢包率top5");
	} else if (e == "main1") {
		title.html("ESRVCC切换TOP5");
	} else if (e == "main2") {
		title.html("RRC连接TOP5");
	} else if (e == "main3") {
		title.html("X2切换TOP5");
	}
}

// 初始化表格
function init_table() {
	var time = new Date();
	var timeStr = dateFormat(time);
	var data = {
		'railLine' : "1",
		'quotaId' : "top_middle_circle1",
		'time' : timeStr
	};
	ajax_sync('volte/getQuotaData', 'get', data, function(responseData) {
		var table = $("#quota_table");
		var table_tbody;
		var table_th;
		table_th = "<tr><td>排名</td><td>地市</td><td>"
				+ responseData.data.quotaName.firstQuotaName + "</td><td>"
				+ responseData.data.quotaName.secondQuotaName + "</td><td>"
				+ responseData.data.quota.firstQuotaName + "</td><td>"
				+ responseData.data.quota.secondQuotaName + "</td></tr>";
		for (var i = 0; i < responseData.data.quota.quotaData.length; i++) {
			table_tbody += "<tr><td>" + (i + 1) + "</td><td>"
					+ responseData.data.quota.quotaData[i].city_name
					+ "</td><td>" + responseData.data.quota.quotaData[i].quota1
					+ "</td><td>" + responseData.data.quota.quotaData[i].quota1
					+ "</td><td>" + responseData.data.quota.quotaData[i].quota3
					+ "</td><td>" + responseData.data.quota.quotaData[i].quota4
					+ "</td></tr>";// 差+
		}
		table.html(table_th);
		table.append(table_tbody);
	});

}

/** 初始化页面高铁线路* */
function getRailLineName() {
	// 获取页面加载标签
	var hailway = $("#railLine");
	var addhtml;
	// 页面加载时发送ajax请求
	ajax_asyn("/hailwayLine/getAllHailwayLine", "post", {}, function(
			responedata) {
		if (responedata != null && responedata != "") {
			for (var i = 0; i < responedata.length; i++) {
				// 追加li标签
				addhtml = "<option value='" + responedata[i].id + "'>"
						+ responedata[i].name + "</option>";
				hailway.append(addhtml);
			}
		}
		layui.form.render("select");
	});
}

/**
 * 初始化各个指标
 * 
 * @returns
 */
function init_QuotaByTimeAndRailline() {
	// 默认线路
	var railLine = 1;
	// 默认时间
	var time = new Date();
	var timeStr = dateFormat(time);
	ajax_asyn("/hailwayLine/getIndexByVolte", "get", {
		"lineId" : railLine,
		"time" : timeStr
	}, function(res) {
		if (res.data != null) {
			loadIndex(res.data);
		}
	});

}

// 加载指标--仪表盘
function loadIndex(data) {
	// 判断是否有指标存在
	for (var i = 0; i < data.length; i++) {
		if (data[i].value == "--") {
			data[i].value = "0%";
		}
	}
	// VOLTE附着阶段得分
	init_circle1(data[0].value, data[1].value);
	// IMS注册阶段得分
	init_circle2(data[2].value);
	// VOLTE持续阶段得分
	init_circle3(data[3].value, data[4].value);
	// RTP丢包率得分
	init_circle4(data[5].value);
	// ESRVCC切换得分
	init_dash1(data[6].value);
	// RRC连接得分
	/* init_dash2(data[7].value); */
	// x2切换得分
	init_dash3(data[8].value);
}

/**
 * 点击按钮查询指标数据
 * 
 * @returns
 */
function selectQuotaByTimeAndRailline() {
	var railLine = $("#railLine").val();
	var timeSize = $("#timeSize").val();
	var time;
	if (timeSize == "1") {
		time = $("#queryDateSelectInput1").val();
	} else if (timeSize == "2") {
		time = $("#queryDateSelectInput2").val();
	}
	if (time == null || time == "" || time == "undefind") {
		layer.alert("必须选择查询时间");
		return;
	}
	ajax_sync("/hailwayLine/getIndexByVolte", "get", {
		"lineId" : railLine,
		"time" : time
	}, function(res) {
		if (res.data != null) {
			loadIndex(res.data);
		}
	});

}
/**
 * 点击仪表盘指标查询数据
 * 
 * @returns
 */
function selectQuotaByQuotaId(e) {
	var railLine = $("#railLine").val();
	var quotaId = e;
	var timeSize = $("#timeSize").val();
	var time;
	if (timeSize == 1) {
		time = $("#queryDateSelectInput1").val();
	} else if (timeSize == 2) {
		time = $("#queryDateSelectInput2").val();
	}
	var data = {
		'railLine' : railLine,
		'quotaId' : quotaId,
		'time' : time
	};
	ajax_sync('volte/getQuotaData', 'get', data, function(responseData) {
		var table = $("#quota_table");
		var table_tbody;
		var table_th;
		if (e == "top_middle_circle1" || e == "top_middle_circle3") {
			table_th = "<tr><td>排名</td><td>地市</td><td>"
					+ responseData.data.quotaName.firstQuotaName + "</td><td>"
					+ responseData.data.quotaName.secondQuotaName + "</td><td>"
					+ responseData.data.quota.firstQuotaName + "</td><td>"
					+ responseData.data.quota.secondQuotaName + "</td></tr>";
		} else {
			table_th = "<tr><td>排名 </td><td> 地市 </td><td>"
					+ responseData.data.quota.firstQuotaName + "</td><td>"
					+ responseData.data.quota.secondQuotaName + "</td></tr>";
		}
		for (var i = 0; i < responseData.data.quota.quotaData.length; i++) {
			if (e == "top_middle_circle1" || e == "top_middle_circle3") {
				table_tbody += "<tr><td>" + (i + 1) + "</td><td>"
						+ responseData.data.quota.quotaData[i].city_name
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota1
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota1
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota3
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota4
						+ "</td></tr>";// 差+
			} else {
				table_tbody += "<tr><td>" + (i + 1) + "</td><td>"
						+ responseData.data.quota.quotaData[i].city_name
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota1
						+ "</td><td>"
						+ responseData.data.quota.quotaData[i].quota2
						+ "</td></tr>";// 差+
			}
		}
		table.html(table_th);
		table.append(table_tbody);
	});
	//详情
    ajax_sync('volte/getInfoByQuota', 'get', data, function(res) {
		if(res.data){
			$("#tbodytop10").empty();
			var html = "";
			for(var i=0;i<res.data.length;i++){
				html += "<tr><td>"+res.data[i].community_name+"</td><td>"+res.data[i].city_name+"</td><td>"+res.data[i].percent+"</td></tr>";
			}
            $("#tbodytop10").append(html);
		}
	});
}

function getdata(e) {
	var railLine = $("#railLine").val();
	var timeSize = $("#timeSize").val();
	var quotaId = e;
	var time;
	if (timeSize == 1) {
		time = $("#queryDateSelectInput1").val();
	} else if (timeSize == 2) {
		time = $("#queryDateSelectInput2").val();
	}
	var data = {
		'railLine' : railLine,
		'quotaId' : quotaId,
		'time' : time
	};
	var dataAxis = new Array();
	var data0 = new Array();
	var data1 = new Array();
	var data2 = new Array();
	var data3 = new Array();
	var data4 = new Array();
	var data5 = new Array();
	var title1;
	var title2;
	var title3;
	var title4;
	var title5;
	var title6;

	data.railLine = data.railLine ? data.railLine : "1";
	data.time = data.time ? data.time : dateFormat(new Date()) + "";
	if (timeSize == 1) {
		ajax_sync(
				'/volte/getWeekQuotaData',
				'get',
				data,
				function(responseData) {
					if (e == "top_middle_circle1" || e == "top_middle_circle3") {
						title1 = responseData.data.quotaName.firstQuotaName;
						title2 = responseData.data.quotaName.secondQuotaName;
						title3 = responseData.data.quota.firstQuotaName;
						title4 = responseData.data.quota.secondQuotaName;
						title5 = responseData.data.quotaName.firstQuotaName
								+ '成功率';// .slice(0,-2)+'成功率'
						title6 = responseData.data.quota.firstQuotaName + "成功率";// .slice(0,-2)+'成功率'
						var quotaData = responseData.data.quota.quotaData;
						for (var i = 0; i < quotaData.length; i++) {
							dataAxis[i] = quotaData[i].time;
							data0[i] = quotaData[i].quota1;
							data1[i] = quotaData[i].quota2;
							data4[i] = (data1[i] / data0[i] * 100).toFixed(2);
							data2[i] = quotaData[i].quota3;
							data3[i] = quotaData[i].quota4;
							data5[i] = (data3[i] / data2[i] * 100).toFixed(2);

						}
						init_trend(dataAxis, data0, data1, data2, data3, data4,
								data5, title1, title2, title3, title4, title5,
								title6);
					} else {
						title1 = responseData.data.quota.firstQuotaName;
						title2 = responseData.data.quota.secondQuotaName;
						title3 = '';
						title4 = '';
						title5 = '';
						title6 = responseData.data.quota.firstQuotaName + '成功率';
						for (var i = 0; i < responseData.data.quota.quotaData.length; i++) {
							dataAxis[i] = responseData.data.quota.quotaData[i].time;
							data0[i] = responseData.data.quota.quotaData[i].quota1;
							data1[i] = responseData.data.quota.quotaData[i].quota2;
							data2[i] = null;
							data3[i] = null;
							data4[i] = null;
							data5[i] = (data1[i] / data0[i] * 100).toFixed(2);
						}
						init_trend(dataAxis, data0, data1, data2, data3, data4,
								data5, title1, title2, title3, title4, title5,
								title6);
					}
				});
	} else {
		ajax_sync(
				'/volte/getWeekQuotaForHour',
				'get',
				data,
				function(responseData) {
					if (e == "top_middle_circle1" || e == "top_middle_circle3") {
						var quotaData = [];
						quotaData = responseData.data.quotaHour.quotaData;
						title1 = responseData.data.quotaHour.firstQuotaName;
						title2 = responseData.data.quotaHour.secondQuotaName;
						title3 = responseData.data.quotaHourFirst.firstQuotaName;
						title4 = responseData.data.quotaHourFirst.secondQuotaName;
						title5 = responseData.data.quotaHour.firstQuotaName
								+ '成功率';
						title6 = responseData.data.quotaHour.quotaHourFirst
								+ '成功率';
						for (var i = 0; i < quotaData.length; i++) {
							dataAxis[i] = quotaData[i].time;
							data0[i] = quotaData[i].quota1;
							data1[i] = quotaData[i].quota2;
							data4[i] = ((data1[i] / data0[i]) * 100).toFixed(2);
							data2[i] = quotaData[i].quota3;
							data3[i] = quotaData[i].quota4;
							data5[i] = ((data3[i] / data2[i]) * 100).toFixed(2);

						}
						init_trend(dataAxis, data0, data1, data2, data3, data4,
								data5, title1, title2, title3, title4, title5,
								title6);
					} else {
						title1 = responseData.data.quota.firstQuotaName;
						title2 = responseData.data.quota.secondQuotaName;
						title3 = '';
						title4 = '';
						title5 = '';
						title6 = responseData.data.quota.firstQuotaName + '成功率';
						for (var i = 0; i < responseData.data.quota.quotaData.length; i++) {
							dataAxis[i] = responseData.data.quota.quotaData[i].time;
							data0[i] = responseData.data.quota.quotaData[i].quota1;
							data1[i] = responseData.data.quota.quotaData[i].quota2;
							data2[i] = null;
							data3[i] = null;
							data4[i] = null;
							data5[i] = data1[i] / data0[i] * 100;
						}
						init_trend(dataAxis, data0, data1, data2, data3, data4,
								data5, title1, title2, title3, title4, title5,
								title6);
					}
				});
	}
}

function init_circle1(data1, data2) {
	dash_VolteAccrete = (data1.split('%')[0] * 0.5 + data2.split('%')[0] * 0.5)
			.toFixed(2);
	var myChart1 = echarts.init(document.getElementById('top_middle_circle1'));

	/*
	 * option1 = { tooltip: { trigger: 'item', formatter: "{a} <br/>{b}: {c}
	 * ({d}%)" }, legend: { show: false, orient: 'vertical', x: 'left', data:
	 * ['20%-成本管理', '20%-绩效管理', '15%-对外财务-报告决策', '15%-内部控制', '30%-规划预算-编制与预测'] },
	 * graphic:{ type:'text', left:'center', top:'center', style:{ text:'20分',
	 * textAlign:'center', fill:'#000', width:30, height:30 } }, series: [ {
	 * name:'访问来源', type: 'pie', radius: ['90%','70%'], itemStyle: { normal:{
	 * label:{show:false}, color:['orange'], title:{ text:'aaaa' }, labelLine:{
	 * show:false, lineStyle:{color:'#3c4858'} } }, emphasis: { shadowBlur: 10,
	 * shadowOffsetX: 0, shadowColor: 'rgba(0, 0, 0, 0.5)', textColor:'#000' } },
	 * data:[20] } ], color:
	 * ['rgb(61,171,232)','rgb(95,193,215)','rgb(146,198,96)','rgb(59,175,134)','rgb(53,128,198)'] };
	 * myChart1.setOption(option1);
	 */
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'VOLTE附着阶段成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},
			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			data : [ {
				value : dash_VolteAccrete
			} ]
		} ]
	};
	myChart1.setOption(option)
}

function init_circle2(data) {
	console.log(typeof data.split('%')[0] * 1.0);
	dash_ImsRegister = (data.split('%')[0] * 1.0).toFixed(2);
	var myChart1 = echarts.init(document.getElementById('top_middle_circle2'));

	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'IMS注册阶段成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},
			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			data : [ {
				value : dash_ImsRegister
			} ]
		} ]
	};
	myChart1.setOption(option);
}

function init_circle3(data1, data2) {
	dash_VolteContinue = (data1.split('%')[0] * 0.5 + data2.split('%')[0] * 0.5)
			.toFixed(2);
	var myChart1 = echarts.init(document.getElementById('top_middle_circle3'));
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'VOLTE接续阶段成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},

			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			data : [ {
				value : dash_VolteContinue
			} ]
		} ]
	};
	myChart1.setOption(option);
}

function init_circle4(data) {
	if (data.split('%')[0] == 0) {
		dash_RtpLose = 0;
	} else {
		dash_RtpLose = (data.split('%')[0] * 1).toFixed(2);
	}
	var myChart1 = echarts.init(document.getElementById('top_middle_circle4'));
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'RTP丢包率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			// 分割段数，默认为5
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},
			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			data : [ {
				value : dash_RtpLose
			} ]
		} ]
	};
	myChart1.setOption(option);
}

function init_dash1(data) {
	dash_ESRVCC_Switch = (data.split('%')[0] * 1).toFixed(2);
	var ec = echarts.init(document.getElementById('main1'));
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'ESRVCC切换成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			// 分割段数，默认为5
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},
			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			data : [ {
				value : dash_ESRVCC_Switch
			} ]
		} ]
	};
	ec.setOption(option);
}

function init_dash2(data) {
	dash_RRC_Login = (data.split('%')[0] * 1).toFixed(2);
	var ec = echarts.init(document.getElementById('main2'));
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'RRC连接成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},

			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 4
			},
			/*
			 * title : { show : true, offsetCenter: [0, '-40%'], // x, y，单位px
			 * textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE fontWeight: 'bolder' } },
			 */
			/*
			 * detail : { formatter:'{value}%', textStyle: { //
			 * 其余属性默认使用全局文本样式，详见TEXTSTYLE color: 'auto', fontWeight: 'bolder' } },
			 */
			data : [ {
				value : dash_RRC_Login,
				name : ''
			} ]
		} ]
	};
	ec.setOption(option);
}

function init_dash3(data) {
	dash_X2_Switch = (data.split('%')[0] * 1).toFixed(2);
	var ec = echarts.init(document.getElementById('main3'));
	option = {
		tooltip : {
			formatter : "{a} <br/>{b} : {c}%"
		},
		title : {
			text : 'X2切换成功率',
			x : 'center',
			textStyle : {
				fontSize : 10
			}
		},
		series : [ {
			name : '业务指标',
			type : 'gauge',
			axisLine : { // 坐标轴线
				lineStyle : { // 属性lineStyle控制线条样式
					color : [ [ 0.2, 'red' ], [ 0.6, 'yellow' ], [ 1, 'green' ] ],
					width : 8
				}
			},
			axisTick : {
				show : false
			},
			axisLabel : { // 坐标轴文本标签，详见axis.axisLabel
				show : false
			},
			splitLine : { // 分隔线
				show : false
			// 默认显示，属性show控制显示与否
			},
			pointer : {
				width : 5
			},
			/*
			 * title : { show : true, offsetCenter: [0, '-40%'], // x, y，单位px
			 * textStyle: { // 其余属性默认使用全局文本样式，详见TEXTSTYLE fontWeight: 'bolder' } },
			 */
			/*
			 * detail : { formatter:'{value}%', textStyle: { //
			 * 其余属性默认使用全局文本样式，详见TEXTSTYLE color: 'auto', fontWeight: 'bolder' } },
			 */
			data : [ {
				value : dash_X2_Switch
			} ]
		} ]
	};
	ec.setOption(option);
}

function initial_circle() {
	var myechart = echarts.init(document.getElementById('circle'));
	option = {
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)"
		},
		legend : {
			x : 'center',
			y : 'bottom',
			data : [ '核心网', '终端', '用户' ]
		},
		series : [ {
			name : '访问来源',
			type : 'pie',
			radius : '55%',
			center : [ '50%', '60%' ],
			data : [ {
				value : 335,
				name : '核心网'
			}, {
				value : 310,
				name : '终端'
			}, {
				value : 234,
				name : '用户'
			} ]
		} ]
	};
	myechart.setOption(option);
}

function init_trend(dataAxis, data0, data1, data2, data3, data4, data5, title1,
		title2, title3, title4, title5, title6) {
	/*
	 * dataAxis = [ '2018-05-25', '2018-05-26', '2018-05-27', '2018-05-28',
	 * '2018-05-29' ]; data0 = [ 100000, 520000, 600000, 250000, 500000 ]; data1 = [
	 * 100000, 520000, 100000, 150000, 450000 ];
	 */
	myChart = echarts.init(document.getElementById('echart'));

	option = {
		color : [ '#3398DB' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend : {
			itemWidth : 20,
			itemHeight : 10,
			itemGap : 10,
		/***********************************************************************
		 * data : / [ { name : 'volte附着请求次数', icon : 'rect' }, { name :
		 * 'voLTE附着成功次数', icon : 'rect' }, { name : 'voLTE附着成功率', icon : 'rect' }, {
		 * name : 'IMS网络PON连接成功率', icon : 'rect' }, { name : 'voLTE默认承载建立成功率',
		 * icon : 'rect' } ]
		 */
		/* lengendTrend, */
		/* right: '4%' */
		},
		grid : {
			left : '2%',
			right : '2%',
			bottom : '3%',
			containLabel : true
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			data : dataAxis,
			splitLine : {

				show : false

			},
			axisTick : {
				alignWithLabel : true
			}
		} ],
		yAxis : [ {
			type : 'value',
			name : '',
			position : 'left',
			splitLine : {
				show : false
			},
			axisLabel : {
				formatter : '{value} 次'
			}
		}, {
			type : 'value',
			name : '',
			/*
			 * min: 0, max: 1,
			 */
			position : 'right',
			splitLine : {
				show : false
			},
			axisLabel : {
				show : true,
				interval : 'auto',
				formatter : '{value} %'
			}
		}, ],
		series : [ {
			name : title1,
			type : 'bar',
			barWidth : '20%',
			yAxis : 1,
			itemStyle : {
				normal : {
					color : 'orange'
				}
			},
			data : data0,
			barGap : 0
		}, {
			name : title2,
			type : 'bar',
			barWidth : '20%',
			/* yAxisIndex: 1, */
			itemStyle : {
				normal : {
					color : '#9ACD32'
				}
			},
			data : data1
		}, {
			name : title3,
			type : 'bar',
			/* yAxisIndex : 1, */
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#836FFF'
				}
			},
			data : data2,
		}, {
			name : title4,
			type : 'bar',
			/* yAxisIndex : 1, */
			symbol : 'none',
			itemStyle : {
				normal : {
					color : '#8B795E'
				}
			},
			data : data3,
		}, {
			name : title5,
			type : 'line',
			yAxisIndex : 1,
			/* symbol : 'none', */
			itemStyle : {
				normal : {
					color : '#9F79EE'
				}
			},
			data : data4,
		}, {
			name : title6,
			type : 'line',
			yAxisIndex : 1,
			/* symbol : 'none', */
			itemStyle : {
				normal : {
					color : '#9F79EE'
				}
			},
			data : data5,
		}

		]
	};
	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}

// 日期格式处理
function dateFormat(time) {
	var year = time.getFullYear();
	var month = (time.getMonth() + 1) < 10 ? ("0" + (time.getMonth() + 1))
			: (time.getMonth() + 1);
	var day = time.getDate() < 10 ? "0" + time.getDate() : time.getDate();
	var timeStr = year + "-" + month + "-" + day;
	return timeStr;
}
