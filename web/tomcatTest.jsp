<%--
  Created by IntelliJ IDEA.
  User: hrj
  Date: 2019/10/8
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@ page import="javax.naming.*,java.sql.*,javax.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>����Tomcat����Դ</title>
</head>
<body>
<%
    // ��ʼ��Context��ʹ��InitialContext��ʼ��Context
    Context ctx=new InitialContext();
/*
ͨ��JNDI��������Դ����JNDIΪjava:comp/env/jdbc/dstest���ֳ���������
java:comp/env��Tomcat�̶��ģ�Tomcat�ṩ��JNDI�󶨶�����Ӹ�ǰ׺
jdbc/dstest�Ƕ�������Դʱ������Դ��
*/
    DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dstest");
// ��ȡ���ݿ�����
    Connection conn=ds.getConnection();
// ��ȡStatement
    Statement stmt=conn.createStatement();
// ִ�в�ѯ������ResulteSet����
    ResultSet rs=stmt.executeQuery("select * from users");
    while(rs.next())
    {
        out.println(rs.getString(2)
                + "\t" + rs.getString(3) + "<br/>");
    }
%>
</body>
</html>
