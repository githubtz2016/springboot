<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="common/css/common.css">

<div class="layui-header ">
    <div class="layui-logo">四川移动4G高铁专网质量分析系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
      <li class="layui-nav-item"><a href="sceneMonitoring.jsp">场景监控</a></li>
      <li class="layui-nav-item"><a href="performanceAnalysis.jsp">性能分析</a></li>
      <li class="layui-nav-item"><a href="quota.jsp">VOLTE</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">管理员
        </a>
        <!-- <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl> -->
      </li>
      <li class="layui-nav-item"><a href="http://10.109.209.100:9081/uac" onclick="logout()">退出</a></li>
    </ul>
  </div>
<script>
    function logout(){
        $.ajax({
            url:"/user/logout",
            type:"get",
            dataType:"json",
            success:function(res){
            }
        });
    }
</script>