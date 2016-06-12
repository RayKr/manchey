<%--
  Created by IntelliJ IDEA.
  User: Ray
  Date: 2016/6/2
  Time: 11:12
  引用easyui样式
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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