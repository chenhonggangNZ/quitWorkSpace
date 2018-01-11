package com.xinyou.bookstore.user.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.category.domain.Category;
import com.xinyou.bookstore.category.service.CategoryService;
import com.xinyou.bookstore.user.domain.Admin;
import com.xinyou.bookstore.user.service.UserService;
import com.xinyou.bookstore.user.service.exception.LoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = request.getParameter("adminname");
        String password = request.getParameter("password");

        try {
            Admin admin = UserService.adminLogin(adminname,password);
            String encryption = UserService.encryption(admin.getPassword());
            admin.setPassword(encryption);
            List<Category> all = CategoryService.findAll();
            request.getSession().setAttribute("allCategory",all);
            request.getSession().setAttribute("admin",admin);
            request.getRequestDispatcher("/adminjsps/admin/main.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            String message = e.getMessage();
            StackTraceElement[] stackTrace = e.getStackTrace();
            request.setAttribute("msg",message);
            request.setAttribute("msgPlace",stackTrace);
            request.getRequestDispatcher("/adminjsps/msg.jsp").forward(request,response);
        } catch (LoginException e) {
            String message = e.getMessage();
            request.setAttribute("msg",message);
            StackTraceElement[] stackTrace = e.getStackTrace();
            request.setAttribute("msgPlace",stackTrace);
            request.getRequestDispatcher("/adminjsps/msg.jsp").forward(request,response);
        }

    }
}
