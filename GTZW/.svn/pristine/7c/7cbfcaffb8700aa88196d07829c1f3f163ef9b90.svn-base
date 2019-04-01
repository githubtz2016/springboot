
var num=0;/*数据库返回的数据作为页码计算*/

var switchData ="ASC";/*  true ASC  false DESC*/
$(function () {
    mapLine();

});

$(".layui-btn").click(function () {
    /*时间的判定是否合法*/
    var startDate = new Date($("#queryDateSelectInputStart").val().replace(/-/g,"/"));
    var endDate = new Date($("#queryDateSelectInputEnd").val().replace(/-/g,"/"));
    if(startDate>endDate){
        layer.alert("时间不合法！！！");
        return false;
    }else {
        mapLine();
        load_init(1);
    }
});

/*ajax请求返回数据*/
function load_init(n){
    $("#tData").empty();
    var param = {
        pageNum:n,
        pageSize:5,
        startTime:$("#queryDateSelectInputStart").val(),    /*$("#queryDateSelectInputStart").val()*/
        endTime:$("#queryDateSelectInputEnd").val(),      /*$("#queryDateSelectInputEnd").val()*/
        index:$("#index").val(),
        sequence:switchData,
        line:$("#road_secton").val()
    };
   /* param.startTime =param.endTime = "20180808";*//*用于数据测试，之后删除*/
    ajax_sync("/hailwayCommunity/getAllData","post",param,function (responseData) {
        if(responseData.list.length>0){
            for(var i=0;i<responseData.list.length;i++){
                if(responseData.list[i].indexData == null){
                    responseData.list[i].indexData="-";
                }
                var tr = "<tr><td>"+responseData.list[i].communityName+"</td>";
                tr += "<td>"+responseData.list[i].indexData+"</td>";
                $("#tData").append(tr);
            }
        }
        /*重新渲染*/
        //执行一个laypage实例
        layui.laypage.render({
            elem: 'demo0' ,//注意，这里的 test1 是 ID，不用加 # 号
            count: responseData.total ,//数据总数，从服务端得到
            curr:n,
            limit:5,  /*每页5条数据*/
            groups:5,//连续出现页码个数
            jump: function(obj, first){
                //首次不执行
                if(!first){
                    //do something
                    load_init(obj.curr);
                }
            }
        });
    });

}

/*layui渲染页面*/
layui.use(['laydate','laypage',"form"], function(){
    /* layui.form.read();*/
    var laypage = layui.laypage;
    var form = layui.form;
    form.on('select(aihao)', function(data){
        load_init(1);
        /*指标改变重新加载*/
        mapLine();
        /*alert("123")*/

        /*加载各个指标的头的指标信息*/
        pageDataIndexValue();

    });

    /*检验开关是否开启，升序或者降序*/
    form.on('switch(switchData)', function(data){
        console.log(data.elem.checked); //开关是否开启，true或者false
        /* console.log(data.value); //开关value值，也可以通过data.elem.value得到*/
        /*  true ASC  false DESC*/
        if(data.elem.checked==false){
            switchData="DESC"; /*降序*/
            load_init(1);
        }
        if (data.elem.checked==true){
            switchData="ASC";  /*升序*/
            load_init(1);
        }


    });


    //执行一个laypage实例
    laypage.render({
        elem: 'demo0' ,//注意，这里的 test1 是 ID，不用加 # 号
        count: num ,//数据总数，从服务端得到
        limit:5,  /*每页5条数据*/
        groups:5,//连续出现页码个数
        jump: function(obj, first){
            //首次不执行
            if(!first){
                //do something
                load_init(obj.curr);
            }
        }
    });

    var laydate = layui.laydate;

    var myDate=new Date();
    laydate.render({
        elem : '#queryDateSelectInputStart',//指定元素
        type : 'date',
        value:myDate
    });
    laydate.render({
        elem : '#queryDateSelectInputEnd',//指定元素
        type : 'date',
        value:myDate

    });
    load_init(1);

});

function pageDataIndexValue() {
    var headIndex=$("#index").val();
    var dataIndex=$("#dataIndex");
    if(headIndex == "HTTP_IND1"){
        dataIndex.html("页面显示成功率")
    }
    if(headIndex == "HTTP_IND2"){
        dataIndex.html("页面响应平均时延(ms)")
    }
    if(headIndex == "HTTP_IND5"){
        dataIndex.html("HTTP下载速率(kbps)")
    }
    if(headIndex == "FTP_IND1"){
        dataIndex.html("应用下载速率(kbps)")
    }
    if(headIndex == "IM_IND1"){
        dataIndex.html("IM登陆成功率(%)")
    }
    if(headIndex == "IM_IND2"){
        dataIndex.html("IM 200KB以上上传速率（kbps）")
    }
    if(headIndex == "IM_IND3"){
        dataIndex.html("IM 200KB以上下载速率（kbps）")
    }
    if(headIndex == "VIDEO_IND1"){
        dataIndex.html("播放成功率(%)")
    }
    if(headIndex == "VIDEO_IND2"){
        dataIndex.html("视频下载速率（kbps）")
    }
    if(headIndex == "UU_IND1"){
        dataIndex.html("RRC连接建立成功率")
    }
    if(headIndex == "S1MME_IND1"){
        dataIndex.html("ATTACH成功率")
    }
    if(headIndex == "S1MME_IND2"){
        dataIndex.html("TAU成功率")
    }
    if(headIndex == "S1MME_IND1_VOLTE"){
        dataIndex.html("ATTACH成功率_VOLTE")
    }
    if(headIndex == "S1MME_IND2_VOLTE"){
        dataIndex.html("TAU成功率_VOLTE")
    }
    if(headIndex == "VOLTE_IND5"){
        dataIndex.html("IMS注册成功率")
    }
    if(headIndex == "VOLTE_IND1"){
        dataIndex.html("语音始呼网络接通率")
    }
    if(headIndex == "VOLTE_IND2"){
        dataIndex.html("语音终呼网络接通率")
    }
    if(headIndex == "SV_IND1"){
        dataIndex.html("ESRVCC切换完成率")
    }
    if(headIndex == "MOS_IND1"){
        dataIndex.html("RTP丢包率")
    }
    if(headIndex == "UU_IND1"){
        dataIndex.html("RRC连接建立成功率")
    }
    if(headIndex == "X2_IND1"){
        dataIndex.html("X2切换成功率")
    }
}
