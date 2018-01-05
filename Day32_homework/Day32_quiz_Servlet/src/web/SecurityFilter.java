package web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFilter",urlPatterns = {"/savebook","/getbooks","/info"})
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        Object username = request.getSession().getAttribute("username");
        if (username != null){
            chain.doFilter(req,resp);
            return;
        }
        //重定向要加上项目名
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
