<%--
  Created by IntelliJ IDEA.
  User: 侯振东
  Date: 2021/8/12
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>

<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
</head>
<body>
<h1>系统主页v1.0</h1>
<h1><shiro:principal/></h1>
<shiro:authenticated>
    认证之后展示内容<br/>
</shiro:authenticated>
<shiro:notAuthenticated>
    没有认证之后展示内容
</shiro:notAuthenticated>
<a href="${pageContext.request.contextPath}/user/logout">退出用户</a>

<ul>
    <span>多个用户只可以看到的</span>
    <shiro:hasAnyRoles name="user,admin">
        <li><a href="#">用户管理</a></li>
        <ul>
            <shiro:hasPermission name="user:add:*">
                <li><a href="#">添加</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:delete:*">
                <li><a href="#">删除</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="user:update:*">
                <li><a href="#">修改</a></li>
            </shiro:hasPermission>
            <shiro:hasPermission name="order:find:*">
                <li><a href="#">查询</a></li>
            </shiro:hasPermission>
        </ul>
    </shiro:hasAnyRoles>
    <span>admin用户可以看到的</span>
    <shiro:hasRole name="admin">
        <li><a href="#">商品管理</a></li>
        <li><a href="#">订单管理</a></li>
        <li><a href="#">物流管理</a></li>
    </shiro:hasRole>
</ul>
</body>
</html>
