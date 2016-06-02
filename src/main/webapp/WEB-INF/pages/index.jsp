<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2016/6/2
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>曼奇管理系统</title>

    <spring:url value="/resources/jquery-easyui-1.4.5/jquery.min.js" var="jQuery"/>
    <spring:url value="/resources/jquery-easyui-1.4.5/jquery.easyui.min.js" var="jEasyUi"/>
    <spring:url value="/resources/jquery-easyui-1.4.5/themes/default/easyui.css" var="easyuiCss"/>
    <spring:url value="/resources/jquery-easyui-1.4.5/themes/icon.css" var="iconCss"/>
    <spring:url value="/resources/jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js" var="langCss"/>

    <script type="text/javascript" src="${jQuery}"></script>
    <script type="text/javascript" src="${jEasyUi}"></script>
    <link href="${easyuiCss}" rel="stylesheet">
    <link href="${iconCss}" rel="stylesheet">
    <script type="text/javascript" src="${langCss}"></script>

    <script type="text/javascript">
        function showcontent(s) {
            $('#content').html('关于' + s + '语言的介绍');
        }
    </script>

</head>
<body>
<div class="easyui-layout" style="width:400px;height:200px;">
    <div region="west" split="true" title="Navigator" style="width:150px;">
        <p style="padding:5px;margin:0;">Select language:</p>
        <ul>
            <li><a href="javascript:void(0)" onclick="showcontent('java')">Java</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('cshape')">C#</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('vb')">VB</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('erlang')">Erlang</a></li>
        </ul>
    </div>
    <div id="content" region="center" title="Language" style="padding:5px;">
    </div>
</div>
</body>
</html>
