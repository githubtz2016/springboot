/*调用百度API地图*/
var map = new BMap.Map("map");
/*创建地图实例  */
var point = new BMap.Point(104.07, 30.67);
/*创建点坐标  */
map.centerAndZoom(point, 9);
/*初始化地图，设置中心点坐标和地图级别  */
map.addControl(new BMap.NavigationControl);

/*鼠标滚轮缩放*/
map.enableScrollWheelZoom(true);
/*平移缩放控件*/
map.addControl(new BMap.NavigationControl());
/*比例尺*/
map.addControl(new BMap.ScaleControl());


/*缩略地图*/
map.addControl(new BMap.OverviewMapControl());
/*地图类型*/
map.addControl(new BMap.MapTypeControl());
/*地图样式模板*/
map.setMapStyle({style:'googlelite'});

var carMk;
var myBeginIcon = new BMap.Icon("http://e.hiphotos.baidu.com/image/pic/item/7e3e6709c93d70cfaf72bca2f0dcd100bba12b90.jpg", new BMap.Size(25,37), {imageOffset: new BMap.Size(0, 0)});//人
var myEndIcon = new BMap.Icon("http://b.hiphotos.baidu.com/image/pic/item/b58f8c5494eef01f534c096ae8fe9925bd317dc0.jpg", new BMap.Size(25,37), {imageOffset: new BMap.Size(0, 0)});//人

/*var list = [];*/
var dataIndexLine=null;
var timeData;
function time(){
    var timeSize = $('#timeSize').val();
    //获取查询时间
    var time1 = $('#queryDateSelectInput1').val();
    var time2= $('#queryDateSelectInput2').val();
    if(timeSize=='1'){
        timeData =time1
    }else if(timeSize=='2'){
        timeData=time2;
    }
   /* if(timeData==null||timeData==""||timeData=="undefind"){
        layer.alert("必须选择查询时间");
        return;
    }*/
}

/*根据指标数据改变地图颜色*/
function mapColor(tr){
    time();
    var paramData={
        startTime:timeData,
        endTime:timeData,
        index:tr.find("input").val(),
        line:$("#hailway_line").val()
    }

    /*paramData.index="HTTP_IND1";*/
    ajax_sync("/hailwayCommunity/getAllIndexData","post",paramData,function (responseData) {
        if(responseData.length != 0){
            dataIndexLine=responseData;
            var zb=0;
            zb=dataIndexLine.length/2;
            var data=Math.ceil(zb);
            /*console.log(data);*/

            coordinate(responseData[data].ruLong,responseData[data].ruLat);

            drawIcon();
        }
    });
    if(dataIndexLine!=null){
        dataIndexLine.length=0;
    }
}

$(".sel_btn").click(function () {
    Init_mapColor();
});


/*根据指标数据改变地图颜色*/
function Init_mapColor(){
    time();
   /* var time = new Date();
    var timeStr = dateFormat(time);*/
    var paramData={
        startTime:timeData,
        endTime:timeData,
        index:$(".sel-tr").eq(0).find("input").val(),
        line:$("#hailway_line").val()
    }

    /*paramData.index="HTTP_IND1";*/
    ajax_sync("/hailwayCommunity/getAllIndexData","post",paramData,function (responseData) {
        if(responseData.length != 0){
            dataIndexLine=responseData;
            var zb=0;
            zb=dataIndexLine.length/2;
            var data=Math.ceil(zb);


            coordinate(responseData[data].ruLong,responseData[data].ruLat);

            drawIcon();
        }
    });
    if(dataIndexLine!=null){
        dataIndexLine.length=0;
    }
}

/*地图画线*/
function drawGreenLine(point1,point2){      //point
    var color='gray';
    var index = $(".select-tr ").find("input").val();
    if(index == "HTTP_IND1" || index == "VIDEO_IND1" || index == "IM_IND1" ||
        index == "S1MME_IND1" || index == "S1MME_IND2"){
        color = setPointColor(point2,color);
    }
    var polyline = new BMap.Polyline([
        new BMap.Point(point1.ruLong,point1.ruLat),//起始点的经纬度
        new BMap.Point(point2.ruLong,point2.ruLat)//终点的经纬度
    ], {strokeColor:color,//设置颜色
        strokeWeight:6, //宽度
        strokeOpacity:1});//透明度

    map.addOverlay(polyline);
    return;
}


/*画线遍历两点*/
function drawIcon(){
    //var listLast = list.length-1;
    if(carMk){
        map.removeOverlay(carMk);
    }
    for(var i=0;i<dataIndexLine.length-1;i++){
        drawGreenLine(dataIndexLine[i],dataIndexLine[i+1]);//list[i]
    }
}

/*设置点的颜色*/
function setPointColor(point,color){
    if(point.indexData>=95 && point.indexData<=100){
        color='#1E9FFF';
    }
    if(point.indexData>=90 && point.indexData<95){
        color='yellow';
    }
    if(point.indexData>=0 && point.indexData<90){
        color='red';
    }
    if(point.indexData == ""||point.indexData=="null"||point.indexData==null){
        color='gray';
    }
    return color;
}