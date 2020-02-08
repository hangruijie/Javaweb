<%--
  Created by IntelliJ IDEA.
  User: hrj
  Date: 2019-09-24
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
<center>
<h1 style="color: red; font-size: 50px">登录成功</h1>
    <h1 style="color: red; font-size: 50px">在线人数：<%=session.getServletContext().getAttribute("count")%></h1>
<form action="/logoutServlet", method="post">
    <button type="submit" style="color:#BC8F8F; width: 100px; height: 40px; font-size: 30px">
        退出
    </button>
</form>
</center>
</body>
</html>
