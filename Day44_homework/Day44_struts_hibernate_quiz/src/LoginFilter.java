import bean.Admin;
import org.apache.struts2.ServletActionContext;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if (request.getServletPath().contains("login")){
            chain.doFilter(req,resp);
        }
        if (request.getServletPath().equals("")||request.getServletPath() == null){
            chain.doFilter(req,resp);
        }
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin == null ||admin.getUsername() == null ||admin.getUsername().equals("")){

        } else {
           chain.doFilter(req,resp);
        }
        request.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
