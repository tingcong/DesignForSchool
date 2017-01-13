<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%--
  Created by IntelliJ IDEA.
  User: zy
  Date: 2016/12/14
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>

<%
    ;
    String basePath = request.getContextPath();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>首页</title>
    <meta http-equiv="pragma" content="username-cache">
    <meta http-equiv="cache-control" content="username-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">
    <!-- 可选的Bootstrap主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap-theme.min.css">
    <!-- styles.css -->
    <link rel="stylesheet" href="${ctx}/css/styles.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <%--<script src="/jquery-3.1.1.min.js"></script>--%>
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <!-- cookie操作 -->
    <script type="text/JavaScript" src="${ctx}/js/jquery.cookies.2.2.0.min.js"></script>
    <%--<script type="text/JavaScript" src="/js/jQuery.cookie.js"></script>--%>
    <script>
        //确认登陆
        function confirm() {
            var no = $.trim($("#username").val());
            var password = $.trim($("#password").val());
            if (no == "" || password == "") {
                alert("用户名/密码不能为空");
                return;
            }

            $.post("${ctx}/checkUserPwd.htm", {username: no, password: password}, function (data) {
                if ($.trim(data) == "") {
                    alert("用户名或密码错误");
                    return;
                }
                alert(data);
                //username存入cookie
                $.cookies.set("username", no);
                $.cookies.set("role", data);
                location.href = "/homepage.jsp";
            });
        }
    </script>

</head>
<body>
${ctx}******************111111111
<div class="container">
    <!-- 标题 -->
    <div class="row">
        <div class="col-md-3 col-md-offset-4 page-header">
            <h3>选修课安排系统</h3>
        </div>
    </div>
    <!-- 登陆表单 -->
    <div class="row">
        <div class="col-md-3 col-md-offset-4 page-header">
            用户名 <input id="username" type="text" class="form-control"
                       placeholder="请输入用户名"/>密码 <input id="password" type="password"
                                                       class="form-control" placeholder="请输入密码"/>
            <button class="btn btn-link">用户注册</button>
            <button class="btn btn-primary btn-block" onclick="confirm();">登录</button>
        </div>
    </div>
</div>


</body>
</html>
