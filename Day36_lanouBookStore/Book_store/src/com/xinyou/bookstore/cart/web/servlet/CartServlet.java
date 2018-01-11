package com.xinyou.bookstore.cart.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.book.domain.Book;
import com.xinyou.bookstore.book.service.BookService;
import com.xinyou.bookstore.cart.domain.Cart;
import com.xinyou.bookstore.cart.domain.CarOderItem;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")
public class CartServlet extends BaseServlet {
    public void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String bid = request.getParameter("bid");
        String count = request.getParameter("count");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Book bookByBid = BookService.findBookByBid(bid);
        cart.getCar().put(bid,new CarOderItem(bookByBid,Integer.parseInt(count)));
        request.getSession().setAttribute("cart",cart);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/cart/list.jsp");
    }
    public void clear(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        request.getSession().setAttribute("cart",cart);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/cart/list.jsp");
    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String bid = request.getParameter("bid");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.delete(bid);
        request.getSession().setAttribute("cart",cart);
        response.setStatus(302);
        response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/cart/list.jsp");
    }
}
