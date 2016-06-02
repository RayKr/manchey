<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h2>登录曼奇管理系统</h2>
<%-- 使用html表单 --%>
<form action="index" method="post">
    用户名：<input type="text" name="operno">
    密&nbsp;&nbsp;码：<input type="password" name="password">
    <input type="submit" value="登录">
</form>

<%-- 使用SpringMVC表单 --%>
<%--<form:form action="index" method="post" modelAttribute="operator">
    用户名：<form:input path="operator"/>
    密码：<form:input path="password"/>
    <input type="submit" value="登录">
</form:form>--%>
</body>
</html>
