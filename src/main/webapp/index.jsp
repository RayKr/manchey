<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Manchey</title>

    <link href="/resources/css/default.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/resources/js/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/js/themes/icon.css"/>
    <script type="text/javascript" src="/resources/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/resources/js/jquery.easyui.min.js"></script>

    <script type="text/javascript">

        var loginDialog;

        $(function () {
            loginDialog = $('#loginDialog').dialog({
                closable: false,
                modal: true,
                buttons: [{
                    text: '登录',
                    handler: function () {
                        $.ajax({
                            type: 'POST',
                            url: 'index',
                            data: {
                                operno: $('#loginDialog input[name=operno]').val(),
                                password: $('#loginDialog input[name=password]').val()
                            },
                            cache: false,
                            dataType: 'json',
                            success: function (r) {
                                console.info(r);
                            }
                        });
                    }
                }]
            });
        });


    </script>

</head>
<body>

<div id="loginDialog" title="登录Manchey" style="width: 230px; height: 140px">
    <table>
        <tr>
            <td align="right">用户名</td>
            <td><input type="text" name="operno"></td>
        </tr>
        <tr>
            <td align="right">密码</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>
</div>
</body>
</html>
