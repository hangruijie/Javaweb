<%--
  Created by IntelliJ IDEA.
  User: hrj
  Date: 2019-09-24
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>基于model2登录</title>
</head>
<body>
<center>
    <h1 style="color:red; font-size: 40px" >登录</h1>
    <form id="indexform" name="indexForm" action="/loginServlet" method="post" >
        <table border="0">
            <tr>
                <td style="font-size: 40px">账号：</td>
                <td><input style="font-size: 40px" type="text" name="username" id="username"></td>
            </tr>
            <tr>
                <td style="font-size: 40px">密码：</td>
                <td><input style="font-size: 40px" type="password" name="password" id="password">
                </td>
            </tr>
        </table>
        <br>
        <button type="submit" style="color:#BC8F8F; width: 100px; height: 40px; font-size: 30px">
            登录
        </button>
    </form>



</center>
</body>
</html>