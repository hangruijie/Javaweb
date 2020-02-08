package web2019.team1.hangruijie.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;

        //获取资源请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录相关资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")||uri.contains("/tomcatTest.jsp")){
        //放行
            chain.doFilter(req, resp);
        }else {
         //不包含，需要验证用户是否登录
         //从session中获取user
            HttpSession session = request.getSession();
         if (session.getAttribute("loginUser") !=null){
             chain.doFilter(req, resp);
         }else{

             //没有登录，跳转登录页面
             request.setAttribute("login_msg","您未登录，请登录");
             request.getRequestDispatcher("/login.jsp").forward(request,resp);
         }


        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
