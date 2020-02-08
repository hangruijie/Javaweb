package web2019.team1.hangruijie.Servlet;

import web2019.team1.hangruijie.Dao.UserDao;
import web2019.team1.hangruijie.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao ud = new UserDao();
        User loginUser = ud.GetUser();
        // 获取 session
        HttpSession session = request.getSession();
        // 设置编码格式
        response.setCharacterEncoding("UTF-8");
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        // 获取前端的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名、密码是否正确
        if (loginUser.getUsername().equals(username)&&loginUser.getPassword().equals(password)){

            request.setAttribute("result", "登录成功！");
            //将用户存入session
            session.setAttribute("loginUser",loginUser);
            //登录成功，跳转到登录成功界面
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }else{

            request.setAttribute("result", "登录失败！");
            //登录失败，页面跳转
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        //System.out.println("hhhhhh...........");

    }


    }

    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //}

//}
