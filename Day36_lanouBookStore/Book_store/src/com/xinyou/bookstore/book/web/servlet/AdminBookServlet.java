package com.xinyou.bookstore.book.web.servlet;

import com.xinyou.bookstore.book.domain.Book;
import com.xinyou.bookstore.book.service.AdminBaseServlet;
import com.xinyou.bookstore.book.service.BookService;
import com.xinyou.bookstore.category.domain.Category;
import com.xinyou.bookstore.category.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminBookServlet",urlPatterns = "/adminBook")
public class AdminBookServlet extends AdminBaseServlet {

    public void addPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Map<String,String> form = (Map<String, String>) request.getAttribute("form");
            Book book = BookService.generateBook(form);
            BookService.saveBook(book);
            findAllBook(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            String message = e.getMessage();
        }
    }

    public void findAllBook(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException, ServletException {
        List<Book> findAllBook = BookService.findAllBook();
        request.setAttribute("findAllBook",findAllBook);
        request.getRequestDispatcher("adminjsps/admin/book/list.jsp").forward(request,response);
    }

    public void load(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
            String bid = request.getParameter("bid");
            Book book = BookService.findBookByBid(bid);
        List<Category> all = CategoryService.findAll();
        request.setAttribute("allCategory",all);
        request.setAttribute("book",book);
            request.getRequestDispatcher("adminjsps/admin/book/desc.jsp").forward(request,response);
        }
    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        String bid = request.getParameter("bid");
        BookService.deleteBook(bid);
        findAllBook(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Map<String,String> form = new HashMap<>();
        form.put("bid",request.getParameter("bid"));
        form.put("bname",request.getParameter("bname"));
        form.put("price",request.getParameter("price"));
        form.put("author",request.getParameter("author"));
        form.put("image",request.getParameter("image"));
        form.put("cid",request.getParameter("cid"));
        Book book = BookService.generateBook(form);
        BookService.editBook(book);
        findAllBook(request,response);
    }

}
