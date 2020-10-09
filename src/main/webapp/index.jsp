<%--
  Created by IntelliJ IDEA.
  User: 25377
  Date: 2020/9/20
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>

<%--<c:if test="${sessionScope.isSuccessLogin!=true}">&lt;%&ndash;没半个小时登陆一次&ndash;%&gt;--%>
<%--用过滤器解决<%--%>
<%--  response.sendRedirect(request.getContextPath()+"/loginServlet");--%>
<%--%>--%>
<%--</c:if>--%>
<div>
    <p class="bg-success" style="text-align: center;font-size: 30px;margin:15px;padding: 10px">欢迎您，${sessionScope.username}</p>
</div>


<div align="center">
    <a
            href="findUserByPageServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
</div>
</body>
</html>