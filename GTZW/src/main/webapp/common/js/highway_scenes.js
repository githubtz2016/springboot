$(function () {
    //获取现在的时间参数
    //var timeParam = dateFormatToHour(new Date());
    timeParam = '2019032708';
    //初始化总计数据
    init_total(timeParam);
    //初始化用户终端分布图
    initChart_rose();
    //初始化仪表盘
    init_dashboard(timeParam);
    //初始化高人流量车站
    init_station(timeParam);
    //初始化用户变化图
    init_userChange(timeParam);
    //初始化用户类型图
    initChart_userType();
    //初始化地图
    init_map(timeParam);
})

function init_total(timeParam) {
    ajax_asyn("/sceneMonitor/getTotalData","get",{"time":timeParam},function(res){
        var userNum = res.data[0] || 0;
        var volte = res.data[1] || 0;
        var flowTotal = res.data[2] || 0;
        var obj = $("#leftDataShowTable1 .numberProminent");
        obj.eq(0).text(userNum==0?0:userNum.userNum);
        obj.eq(1).text(volte==0?0:volte.volteUser);
        obj.eq(2).text(flowTotal==0?0:flowTotal.flowTotal);
        obj.eq(3).text(volte==0?0:volte.volteERL);

    });
}

function init_dashboard(timeParam) {
    ajax_asyn("/sceneMonitor/getDashboard","get",{"time":timeParam},function(res){
        var data1 = res.data[0] || 0;
        var data2 = res.data[1] || 0;
        var data3 = res.data[2] || 0;
        var data4 = res.data[3] || 0;
        initChart_dashboard1(data1==0?0:data1.X2_IND1);
        initChart_dashboard2(data2==0?0:data2.S1MME_IND4);
        initChart_dashboard3(data3==0?0:data3.HTTP_IND5);
        initChart_dashboard4(data4==0?0:data4.VOLTE_IND1);
    });
}

function init_map(timeParam){
    ajax_asyn("/sceneMonitor/getMapData","get",{"time":timeParam},function(res){
        if(res.data!=null){
            initChart_map(res.data);
        }
    });
}

function init_userChange(timeParam){
    ajax_asyn("/sceneMonitor/getUserChange","get",{"time":timeParam},function(res){
        if(res.data!=null){
            initChart_userChange(res.data);
        }
    });
}

function init_station(timeParam){
    ajax_asyn("/sceneMonitor/getStationData","get",{"time":timeParam},function(res){
        if(res.data){
            initChart_station(res.data);
        }
    });
}

function initChart_rose() {
    //基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('rose'));

    var option = {
        title : {
            text: '',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:['苹果','步步高','华为','小米','OPPO','三星','联想','宇龙酷派'],
            textStyle: {
                color: '#FFF',
            }
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'面积模式',
                type:'pie',
                radius : [30, 110],
                center : ['50%', 200],
                roseType : 'area',
                x: '50%',               // for funnel
                max: 40,                // for funnel
                sort : 'ascending',     // for funnel
                color: ['#f2c955', '#00a69d', '#46d185', '#ec5845','#CA8EC2','#E0E0E0','#FF8000','#AFAF61'],
                data:[
                    {value:10, name:'苹果'},
                    {value:5, name:'步步高'},
                    {value:15, name:'华为'},
                    {value:25, name:'小米'},
                    {value:20, name:'OPPO'},
                    {value:35, name:'三星'},
                    {value:30, name:'联想'},
                    {value:40, name:'宇龙酷派'}
                ]
            }
        ]
    };
    myChart.setOption(option);

}

function initChart_dashboard1(data) {
    var myChart = echarts.init(document.getElementById('dashboard1'));
    var option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        series : [
            {
                name:'',
                type:'gauge',
                startAngle: 140,
                endAngle : -140,
                min: 0,                     // 最小值
                max: 100,                   // 最大值
                precision: 0,               // 小数精度，默认为0，无小数点
                splitNumber: 10,             // 分割段数，默认为5
                axisLine: {            // 坐标轴线
                    show: true,        // 默认显示，属性show控制显示与否
                    lineStyle: {
                        color: [[0.1,'#ff4500'],[0.2,'skyblue'],[1,'lightgreen']],
                        width: 10
                    }
                },
                splitLine: {           // 分隔线
                    show: true,        // 默认显示，属性show控制显示与否
                    length :10,         // 属性length控制线长
                    lineStyle: {
                        color: '#fff',
                        width: 2,
                        type: 'solid'
                    }
                },
                title : {
                    show : true,
                    offsetCenter: [0, 80],
                    textStyle: {
                        color: 'white',
                        fontSize : 16
                    }
                },
                detail : {
                    offsetCenter: [-50, 10],
                    formatter:'{value}%',
                    textStyle: {
                        color: 'lightgreen',
                        fontSize : 18
                    }
                },
                data:[{value: data, name: 'X2切换成功率'}]
            }
        ]
    };
    myChart.setOption(option);

}

function initChart_dashboard2(data) {
    var myChart = echarts.init(document.getElementById('dashboard2'));
    var option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        series : [
            {
                name:'',
                type:'gauge',
                startAngle: 140,
                endAngle : -140,
                min: 0,                     // 最小值
                max: 100,                   // 最大值
                precision: 0,               // 小数精度，默认为0，无小数点
                splitNumber: 10,             // 分割段数，默认为5
                axisLine: {            // 坐标轴线
                    show: true,        // 默认显示，属性show控制显示与否
                    lineStyle: {
                        color: [[0.05,'lightgreen'],[0.5,'skyblue'],[1,'#ff4500']],
                        width: 10
                    }
                },
                splitLine: {           // 分隔线
                    show: true,        // 默认显示，属性show控制显示与否
                    length :10,         // 属性length控制线长
                    lineStyle: {
                        color: '#fff',
                        width: 2,
                        type: 'solid'
                    }
                },
                title : {
                    show : true,
                    offsetCenter: [0, 80],
                    textStyle: {
                        color: 'white',
                        fontSize : 16
                    }
                },
                detail : {
                    offsetCenter: [-50, 10],
                    formatter:'{value}%',
                    textStyle: {
                        color: 'lightgreen',
                        fontSize : 18
                    }
                },
                data:[{value: data, name: '无线掉线率'}]
            }
        ]
    };
    myChart.setOption(option);

}

function initChart_dashboard3(data) {
    var myChart = echarts.init(document.getElementById('dashboard3'));
    var option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        series : [
            {
                name:'',
                type:'gauge',
                startAngle: 140,
                endAngle : -140,
                min: 0,                     // 最小值
                max: 5000,                   // 最大值
                precision: 0,               // 小数精度，默认为0，无小数点
                splitNumber: 10,             // 分割段数，默认为5
                axisLine: {            // 坐标轴线
                    show: true,        // 默认显示，属性show控制显示与否
                    lineStyle: {
                        color: [[0.1,'#ff4500'],[0.5,'skyblue'],[1,'lightgreen']],
                        width: 10
                    }
                },
                splitLine: {           // 分隔线
                    show: true,        // 默认显示，属性show控制显示与否
                    length :10,         // 属性length控制线长
                    lineStyle: {
                        color: '#fff',
                        width: 2,
                        type: 'solid'
                    }
                },
                title : {
                    show : true,
                    offsetCenter: [0, 80],
                    textStyle: {
                        color: 'white',
                        fontSize : 16
                    }
                },
                detail : {
                    offsetCenter: [-50, 10],
                    formatter:'{value}',
                    textStyle: {
                        color: 'lightgreen',
                        fontSize : 18
                    }
                },
                data:[{value: data, name: 'HTTP下载速率(kbps)'}]
            }
        ]
    };
    myChart.setOption(option);

}

function initChart_dashboard4(data) {
    var myChart = echarts.init(document.getElementById('dashboard4'));
    var option = {
        tooltip : {
            formatter: "{a} <br/>{b} : {c}%"
        },
        series : [
            {
                name:'',
                type:'gauge',
                startAngle: 140,
                endAngle : -140,
                min: 0,                     // 最小值
                max: 100,                   // 最大值
                precision: 0,               // 小数精度，默认为0，无小数点
                splitNumber: 10,             // 分割段数，默认为5
                axisLine: {            // 坐标轴线
                    show: true,        // 默认显示，属性show控制显示与否
                    lineStyle: {
                        color: [[0.5,'lightgreen'],[0.8,'skyblue'],[1,'#ff4500']],
                        width: 10
                    }
                },
                splitLine: {           // 分隔线
                    show: true,        // 默认显示，属性show控制显示与否
                    length :10,         // 属性length控制线长
                    lineStyle: {
                        color: '#fff',
                        width: 2,
                        type: 'solid'
                    }
                },
                title : {
                    show : true,
                    offsetCenter: [0, 80],
                    textStyle: {
                        color: 'white',
                        fontSize : 16
                    }
                },
                detail : {
                    offsetCenter: [-50, 10],
                    formatter:'{value}%',
                    textStyle: {
                        color: 'lightgreen',
                        fontSize : 18
                    }
                },
                data:[{value: data, name: 'VOLTE网络接通率'}]
            }
        ]
    };
    myChart.setOption(option);

}

function initChart_station(data) {
    var data_station = new Array();
    var data_num = new Array();
    for(var i=0;i<data.length;i++){
        if(data[i].userNum){
            data_num.push(data[i].userNum);
            data_station.push(data[i].state_name);
        }else{
            data_num.push("--");
            data_station.push(data[i].state_name);
        }
    }
	var myChart = echarts.init(document.getElementById("station"));
    var option = {
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'value',
                axisLabel:{
                    show : false
                },
                splitLine:{
                    show : false
                }
            }
        ],
        yAxis : [
            {
                type : 'category',
                axisTick : {show: false},
                data : data_station,
                axisLabel:{
                    textStyle:{
                        color:"#fff",
                    }
                }
            }
        ],
        grid : {
            left : 80
        },
        series : [
            {
                name:'人数',
                type:'bar',
                barWidth : 20,
                itemStyle: {normal: {
                        label : {show: true}
                    }},
                itemStyle:{
                    normal:{
                        color:'#8CEA00'
                    }
                },
                data:data_num
            }

        ]
    };
	myChart.setOption(option);
}

function initChart_userChange(data) {
    //获取时间list
    var timeList = new Array();
    for(var a=3;a>=0;a--){
        //timeList.push(dateFormatToHour(new Date(new Date().getTime()-a*3600*1000)));
        //27号数据
        var t15 = new Date(new Date().getTime()-3600*2*24*1000);
        timeList.push(dateFormatToHour(new Date(t15.getTime()-(a+3)*3600*1000)));
    }
    //匹配数据
    var dataTime = new Array();
    var dataValue = new Array();
    for(var i=0;i<timeList.length;i++){
        dataValue[i] = new Array();
        //拼接时间
        dataTime.push(timeList[i].substr(8,9)+":00");
        //通过key获取后台数据
        var hourData = data[timeList[i]];
        if(hourData!=null&&hourData!='undefined'&&hourData!=""){
            for(var j=0;j<hourData.length;j++){
                if(hourData[j].userNum){
                    dataValue[i][j] = hourData[j].userNum;
                }else{
                    dataValue[i][j] = 0;
                }
            }
        }else{
            //没有查到数据为0
            for(var j=0;j<7;j++){
                dataValue[i][j] = 0;
            }
        }
    }

    var myChart = echarts.init(document.getElementById('userChange'));
    var option = {
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['兰渝铁路支线','兰渝高铁主线','成绵乐高铁','成渝客专','成达高铁','西成客专','遂渝高铁'],
            textStyle: {
                color: '#FFF',
                fontSize: 14
            }
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : dataTime,
                axisLabel:{
                    textStyle:{
                        color:"#fff",
                    }
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel:{
                    textStyle:{
                        color:"#fff",
                    }
                }
            }
        ],
        series : [
            {
                name: '兰渝铁路支线',
                type:'line',
                data:[dataValue[0][0], dataValue[1][0], dataValue[2][0], dataValue[3][0]]
            },
            {
                name:'兰渝高铁主线',
                type:'line',
                data:[dataValue[0][1], dataValue[1][1], dataValue[2][1], dataValue[3][1]]
            },
            {
                name:'成绵乐高铁',
                type:'line',
                data:[dataValue[0][2], dataValue[1][2], dataValue[2][2], dataValue[3][2]]
            },
            {
                name:'成渝客专',
                type:'line',
                data:[dataValue[0][3], dataValue[1][3], dataValue[2][3], dataValue[3][3]]
            },
            {
                name:'成达高铁',
                type:'line',
                data:[dataValue[0][4], dataValue[1][4], dataValue[2][4], dataValue[3][4]]
            },
            {
                name:'西成客专',
                type:'line',
                data:[dataValue[0][5], dataValue[1][5], dataValue[2][5], dataValue[3][5]]
            },
            {
                name:'遂渝高铁',
                type:'line',
                data:[dataValue[0][6], dataValue[1][6], dataValue[2][6], dataValue[3][6]]
            }
        ]
    };
    myChart.setOption(option);
}

function initChart_userType() {

}

function initChart_map(data) {
    var initData = [
        { name: '阿坝藏族羌族自治州', value: '--' },
        { name: '巴中市', value: '--' },
        { name: '成都市', value: '--' },
        { name: '达州市', value: '--' },
        { name: '德阳市', value: '--' },
        { name: '甘孜藏族自治州', value: '--' },
        { name: '广安市', value: '--' },
        { name: '广元市', value: '--' },
        { name: '乐山市', value: '--' },
        { name: '凉山彝族自治州', value: '--' },
        { name: '泸州市', value: '--' },
        { name: '眉山市', value: '--' },
        { name: '绵阳市', value: '--' },
        { name: '内江市', value: '--' },
        { name: '南充市', value: '--' },
        { name: '攀枝花市', value: '--' },
        { name: '遂宁市', value: '--' },
        { name: '雅安市', value: '--' },
        { name: '宜宾市', value: '--' },
        { name: '资阳市', value: '--' },
        { name: '自贡市', value: '--' }
    ];
    for(var i=0;i<initData.length;i++){
        for(var j=0;j<data.length;j++){
            if(initData[i].name.substr(0,1)==data[j].city_name.substr(0,1)){
                initData[i].value = data[j].wlan;
            }
        }
    }
    var myChart = echarts.init(document.getElementById('map'));
    var option = {
        title:{
            text: '',
        },
        tooltip: {
            trigger: 'item',
            formatter: function (param) {
                if(param.data.value=='--'){
                    return param.name+'<br/>无线利用率 -- '
                }else{
                    return param.name+'<br/>无线利用率 '+param.data.value
                }
            }
        },
        toolbox: {
            show: false,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        series:[
            {
                name: '',
                type: 'map',//type必须声明为 map 说明该图标为echarts 中map类型
                mapType: '四川',
                selectedMode:'single',
                itemStyle: {
                    normal: {//未选中状态
                        borderWidth:2,//边框大小
                        borderColor:'#FFFF6F',
                        areaColor: '#2F4056',//背景颜色
                        label: {
                            show: true,//显示名称
                            textStyle: {
                                color: '#fff'
                            }
                        }
                    },
                    emphasis: {// 也是选中样式
                        areaColor: '#6385b1',
                        label: {
                            show: true,
                            textStyle: {
                                color: '#aaa'
                            }
                        }
                    }
                },
                data: initData
            }
        ]
    };
    myChart.setOption(option);
}


/*
 * 去掉F11键的默认事件控制控制导航栏消失和出现
 */
$(document).on('keydown', function (e) {
	       var e = event || window.event || arguments.callee.caller.arguments[0];
	       if(e && e.keyCode == 122){//捕捉F11键盘动作
	        e.preventDefault();  //阻止F11默认动作
	         var el = document.documentElement;
	         var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen;//定义不同浏览器的全屏API
	　　　　　　//全屏
	         if (typeof rfs != "undefined" && rfs) {
	               rfs.call(el);
	         } else if(typeof window.ActiveXObject != "undefined"){
	              var wscript = new ActiveXObject("WScript.Shell");
	              if (wscript!=null) {
	                  wscript.SendKeys("{F11}");
	              }
	        }
	　　　　　　//监听不同浏览器的全屏事件，并件执行相应的代码
	        document.addEventListener("webkitfullscreenchange", function() {//
	            if (document.webkitIsFullScreen) {
	                
	            /*	document.getElementById('topDiv').style.display='none';*/
	            	$("#topDiv").css('display','none');
	            }else{
	               
	            	$("#topDiv").css('display','block');
	        　　}
	        }, false);
	 
	        document.addEventListener("fullscreenchange", function() {
	            if (document.fullscreen) {
	             
	            	$("#topDiv").css('display','none');
	            }else{
	              
	            	$("#topDiv").css('display','block');
	            }
	        }, false);
	 
	        document.addEventListener("mozfullscreenchange", function() {
	            if (document.mozFullScreen) {
	                 
	            	$("#topDiv").css('display','none');
	           }else{
	                
	        	   $("#topDiv").css('display','block');
	           }
	       }, false);
	 
	        document.addEventListener("msfullscreenchange", function() {
	            if (document.msFullscreenElement) {
	                
	            	$("#topDiv").css('display','none');
	            }else{
	                 
	            	$("#topDiv").css('display','block');
	            }
	        }, false)
	     }
	 });    
