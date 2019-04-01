//共通ajax异步方法
function ajax_asyn(url,reqType,data,func){
    $.ajax({
        async: true,
        type: reqType,
        url: url,
        dataType: "json",
        data: data,
        error: function (responseData) {
            //请求失败时被调用的函数
            alert(responseData);
        },
        success: function (responseData) {
            func(responseData);
        }
    });
}

//共通ajax同步方法
function ajax_sync(url,reqType,data,func){
    $.ajax({
        async: false,
        type: reqType,
        url: url,
        dataType: "json",
        data: data,
        error: function (responseData) {
            //请求失败时被调用的函数
            alert("请求响应失败");
        },
        success: function (responseData) {
            func(responseData);
        }
    });
}

//日期格式处理
function dateFormat(time){
    var year = time.getFullYear();
    var month = (time.getMonth()+1)<10?("0"+(time.getMonth()+1)):(time.getMonth()+1);
    var day = time.getDate()<10?"0"+time.getDate():time.getDate();
    var timeStr = year+"-"+month+"-"+day;
    return timeStr;
}

//日期格式处理(精确到小时)
function dateFormatToHour(time){
    var year = time.getFullYear();
    var month = (time.getMonth()+1)<10?("0"+(time.getMonth()+1)):(time.getMonth()+1);
    var day = time.getDate()<10?"0"+time.getDate():time.getDate();
    var hour = time.getHours()<10?"0"+time.getHours():time.getHours();
    var timeStr = (year+"-"+month+day+hour).replace('-','');
    return timeStr;
}

/*设置中心坐标为屏幕中心*/
function coordinate(RU_long,RU_lat) {
    if(RU_long!=null&&RU_lat!=null){
        map.clearOverlays();
        var new_point=new BMap.Point(RU_long,RU_lat);
        map.panTo(new_point);
    }
}















