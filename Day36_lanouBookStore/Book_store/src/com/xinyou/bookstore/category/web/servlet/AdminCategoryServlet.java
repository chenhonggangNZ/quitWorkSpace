package com.xinyou.bookstore.category.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.category.domain.Category;
import com.xinyou.bookstore.category.service.CategoryService;
import com.xinyou.bookstore.category.service.exception.CategoryException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet",urlPatterns = "/adminCategory")
public class AdminCategoryServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> findAllCategory = null;
        try {
            findAllCategory = CategoryService.findAll();
            request.setAttribute("findAll",findAllCategory);
            request.getRequestDispatcher("/adminjsps/admin/category/list.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
    public void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cname = request.getParameter("cname");
        try {
            CategoryService.addCategory(cname);
            request.setAttribute("msg","添加成功！");
            request.getRequestDispatcher("/adminjsps/admin/category/add.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500);
        } catch (CategoryException e) {
            String message = e.getMessage();
            request.setAttribute("msg",message);
            request.getRequestDispatcher("/adminjsps/admin/category/add.jsp").forward(request,response);
        }
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        try {
            CategoryService.delete(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CategoryException e) {
            String message = e.getMessage();
            request.setAttribute("msg",message);
        }
        findAll(request,response);
    }

    public void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        String cname = request.getParameter("cname");
        try {
            CategoryService.edit(cid,cname);
            findAll(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500);
        }
    }
}
