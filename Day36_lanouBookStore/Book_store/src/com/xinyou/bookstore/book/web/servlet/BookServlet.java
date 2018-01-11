package com.xinyou.bookstore.book.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.book.domain.Book;
import com.xinyou.bookstore.book.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet" ,urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    public void load(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String bid = request.getParameter("bid");
        Book book = BookService.findBookByBid(bid);
        request.getSession().setAttribute("book",book);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/book/desc.jsp");
    }
    public void findBookByCid(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        String cid = request.getParameter("cid");
        List<Book> findBookByCid = BookService.findBookByCid(cid);
        request.getSession().setAttribute("findBookByCid",findBookByCid);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/book/list.jsp");
    }
    public void findAllBook(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {
        List<Book> findAllBook = BookService.findAllBook();
        request.getSession().setAttribute("findAllBook",findAllBook);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/book/list.jsp?cid=all");
    }
}
