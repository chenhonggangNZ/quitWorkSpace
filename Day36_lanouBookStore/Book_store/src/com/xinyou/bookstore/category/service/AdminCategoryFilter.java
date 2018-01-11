package com.xinyou.bookstore.category.service;

import com.xinyou.bookstore.user.domain.Admin;
import com.xinyou.bookstore.user.service.UserService;
import com.xinyou.bookstore.user.service.exception.AdminException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(filterName = "AdminCategoryFilter",urlPatterns = "/adminCategory")
public class AdminCategoryFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        try {
            if (UserService.isAdmin(admin)){
                chain.doFilter(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500);
        } catch (AdminException e) {
            String message = e.getMessage();
            response.getWriter().write(message);
            response.setStatus(302);
            response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"/adminjsps/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
