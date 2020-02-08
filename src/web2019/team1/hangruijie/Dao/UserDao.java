package web2019.team1.hangruijie.Dao;

import web2019.team1.hangruijie.User.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    public User GetUser() {
        User u =new User();
        // 初始化Context，使用InitialContext初始化Context

        try {
            Context ctx=new InitialContext();
            DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/dstest");
            // 获取数据库连接
            Connection conn=ds.getConnection();
            // 获取Statement
            Statement stmt=conn.createStatement();
            // 执行查询，返回ResulteSet对象
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
            {
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
             //   System.out.println(rs.getString("username"));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return u;
    }

}
