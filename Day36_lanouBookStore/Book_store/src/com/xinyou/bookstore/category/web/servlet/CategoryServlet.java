package com.xinyou.bookstore.category.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.category.dao.CategoryDao;
import com.xinyou.bookstore.category.domain.Category;
import com.xinyou.bookstore.category.service.CategoryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends BaseServlet{
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Category> findAllCategory = CategoryService.findAll();
        request.getSession().setAttribute("findAll",findAllCategory);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/left.jsp");
    }
}
