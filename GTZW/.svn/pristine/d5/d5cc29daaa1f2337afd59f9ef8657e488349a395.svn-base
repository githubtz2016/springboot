/*调用百度API地图*/
var map = new BMap.Map("baiduMapMainDiv");
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

var dataIndexLine=null;

function mapLine() {
    var paramData={
        startTime:$("#queryDateSelectInputStart").val(),
        endTime:$("#queryDateSelectInputEnd").val(),
        index:$("#index").val(),
        line:$("#road_secton").val()
    }
    if(paramData.startTime==""||paramData.endTime==""){
        var time = new Date();
        paramData.startTime = dateFormat(time);
        paramData.endTime = dateFormat(time);
    }
   /* paramData.startTime =paramData.endTime = "20180808";*//*用于数据测试，之后删除*/
    ajax_sync("/hailwayCommunity/getAllIndexData","post",paramData,function (responseData) {
       if(responseData.length!=0){
            dataIndexLine=responseData;
            var zb=0;
            zb=dataIndexLine.length/2
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
    if($("#index").val() == "HTTP_IND1" || $("#index").val() == "VIDEO_IND1" || $("#index").val() == "IM_IND1" ||
        $("#index").val() == "S1MME_IND1" || $("#index").val() == "S1MME_IND1_VOLTE" ||  $("#index").val() == "S1MME_IND2_VOLTE" ||
        $("#index").val() == "VOLTE_IND5" || $("#index").val() == "VOLTE_IND1" || $("#index").val() == "VOLTE_IND2" ||
        $("#index").val() == "SV_IND1" || $("#index").val() == "MOS_IND1" || $("#index").val() == "UU_IND1" ||
        $("#index").val() == "X2_IND1" || $("#index").val() == "S1MME_IND2"){
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


