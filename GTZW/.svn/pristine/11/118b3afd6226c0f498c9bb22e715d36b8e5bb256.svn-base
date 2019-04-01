$(document).ready(function(){
	//初始化数据
    init_Index();
    init_CIByIndex();
    //初始化4G时长图表
	/*init_4g();*/
})


function init_4g(){
	   // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('echart'));

        // 指定图表的配置项和数据
        var option = {
            tooltip: {},
            xAxis: {
                data: ["杭长线","昌九线","浙赣线","合福线"]
            },
            yAxis: {},
            series: [{
                name: '时长驻留比',
                type: 'bar',
                data: [5, 20, 36, 10] 
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
}

function init_hailway_line() {
    var addhtml;
    //页面加载时发送ajax请求
    ajax_asyn("/hailwayLine/getAllHailwayLine","post",{},function (responedata){
        if(responedata!=null&&responedata!=""){
            for(var i=0;i<responedata.length;i++){
                //追加li标签
                addhtml="<option value='"+responedata[i].id+"'>"+responedata[i].name+"</option>"
                $("#hailway_line").append(addhtml);
            }
            layui.form.render("select");
        }
    });

}

function init_Index(){
    //默认数据参数
    var time = new Date();
    var timeStr = dateFormat(time);
    var data = {"lineId":"1","time":timeStr}
    ajax_sync("/hailwayLine/getIndexByHailwayLine","get",data,function (responseDate) {
        if(responseDate.data!=null){
            loadDataByIndex(responseDate.data,"1",timeStr);
        }
    });

}

function selectDataByParam(){
    //获取高铁线路
    var hailway = $('#hailway_line').val();
    //获取时间粒度
    var timeSize = $('#timeSize').val();
    //获取查询时间
    var time1 = $('#queryDateSelectInput1').val();
    var time2= $('#queryDateSelectInput2').val();
    var time;
    if(timeSize=='1'){
    	time =time1
    }else if(timeSize=='2'){
    	time=time2;
    }
    if(time==null||time==""||time=="undefind"){
        layer.alert("必须选择查询时间");
        return;
    }
    //清空之前的数据
    $("#quotaList").empty();
    //发送ajax
    ajax_sync("/hailwayLine/getIndexByHailwayLine","get",{"lineId":hailway,"time":time},function (responseDate) {
        if(responseDate.data!=null){
            loadDataByIndex(responseDate.data,hailway,time)
        }
    });
}

//点击指标给top5赋值
function selectCIByIndex(tr,railLine,time) {
    //获取点击的tr指标参数
    var quota = tr.find("input").val();
    //清空tr选中样式并重新赋予选中的样式
    $(".sel-tr").removeClass("select-tr");
    tr.addClass("select-tr");
    //获取指标的名字,设置表头
    var IndexName = tr.find("td:eq(0)").text();
    $("#mapDiv").html(IndexName+"_地图一览");
    $("#topDiv").html("小区TOP5_"+IndexName);
    $("#lastDiv").html("小区低用户TOP5_"+IndexName);
    //发送ajax,重新更新数据表格
    ajax_asyn("/index/getQuota","get",{"quota":quota,"railLine":railLine,"time":time},function (responseData){
        if(responseData.data!=null){
            loadDataByCI(responseData.data);
        }

    });
}
//初始化top5
function init_CIByIndex() {
    //获取点击的tr指标参数
    var quota = $(".sel-tr").eq(0).find("input").val();
    //加载地图

    //时间格式处理
    var time = new Date();
    var timeStr = dateFormat(time);
    //获取指标的名字,设置表头
    var IndexName =  $(".sel-tr").eq(0).find("td:eq(0)").text();
    $("#mapDiv").html(IndexName+"_地图一览");
    $("#topDiv").html("小区TOP5_"+IndexName);
    $("#lastDiv").html("小区低用户TOP5_"+IndexName);
    //发送ajax,重新更新数据表格
    ajax_asyn("/index/getQuota","get",{"quota":quota,"railLine":"1","time":timeStr},function (responseData){
        if(responseData.data!=null){
            loadDataByCI(responseData.data);
        }

    });
}

//加载数据方法--指标
function loadDataByIndex(data, lineId, time){
    //判断是否为空
    var dataValue = "--";
    //循环添加tr
    for(var i=0;i<data.length;i++){
        if(data[i].value){
            dataValue = data[i].value;
        }
        var addHtml = "<tr class='sel-tr'><td>"+data[i].name+"</td><td>"+dataValue+"</td><input type='hidden' value='"+data[i].id+"' /></tr>";
        $("#quotaList").append(addHtml);
    }
    //给tr绑定点击事件
    $(".sel-tr").bind("click",function () {
        //加载表格
        selectCIByIndex($(this),lineId,time);
        //加载地图
        mapColor($(this));
    });
}

//加载数据方法--小区
function loadDataByCI(data) {
    //清空之前的数据
    $("#tbodytop5").empty();
    $("#tbodylast5").empty();
    var html1="";
    var html2="";
    var top5 = "--";
    var last5 = "--";
    for(var i = 0; i<data.first5.length;i++){
        if(data.first5[i].value){
            top5 = data.first5[i].value;
        }
        if(data.last5[i].value){
            last5 = data.last5[i].value;
        }
        html1 +="<tr><td>"+data.first5[i].community_name+"</td><td>"+data.first5[i].city_name+"</td><td>"+top5+"</td></tr>";
        html2 +="<tr><td>"+data.last5[i].community_name+"</td><td>"+data.last5[i].city_name+"</td><td>"+last5+"</td></tr>";
    }
    $("#tbodytop5").html(html1);
    $("#tbodylast5").html(html2);
}

//导出首页数据到excel
function downloadData(){
    //获取高铁线路
    var hailway = $('#hailway_line').val();
    //获取时间粒度
    var timeSize = $('#timeSize').val();
    //获取查询时间
    var time1 = $('#queryDateSelectInput1').val();
    var time2= $('#queryDateSelectInput2').val();
    var time;
    if(timeSize=='1'){
        time =time1
    }else if(timeSize=='2'){
        time=time2;
    }
    if(time==null||time==""||time=="undefind"){
        layer.alert("必须选择导出时间");
        return;
    }
    window.location.href = "download/getfirstPage?lineId="+hailway+"&time="+time;
    // ajax_asyn("/hailwayLine/getfirstPage","get",{"lineId":hailway,"time":time},function (rep){
    //     if(rep.data){
    //         window.location.href = "/download/firstPage?path="+rep.data;
    //         // var form=$("<form>");//定义一个form表单
    //         //  form.attr("style","display:none");
    //         //  form.attr("target","");
    //         //  form.attr("method","post");
    //         //  form.attr("action","download/firstPage?filepath="+rep.data);
    //         //  var input1=$("<input>");
    //         //  input1.attr("type","hidden");
    //         //  input1.attr("name","exportData");
    //         //  input1.attr("value",(new Date()).getMilliseconds());
    //         //  $("body").append(form);//将表单放置在web中
    //         //  form.append(input1);
    //         //  form.submit();//表单提交
    //     }
    // });
}
