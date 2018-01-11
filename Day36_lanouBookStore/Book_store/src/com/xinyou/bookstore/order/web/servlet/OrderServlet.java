package com.xinyou.bookstore.order.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.book.dao.BookDao;
import com.xinyou.bookstore.book.domain.Book;
import com.xinyou.bookstore.book.service.BookService;
import com.xinyou.bookstore.cart.domain.Cart;
import com.xinyou.bookstore.order.domain.Order;
import com.xinyou.bookstore.order.domain.OrderItem;
import com.xinyou.bookstore.order.service.OrderService;
import com.xinyou.bookstore.order.service.exception.OrderException;
import com.xinyou.bookstore.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet {
    public void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            User user = (User) request.getSession().getAttribute("user");
            System.out.println(user);
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            System.out.println(cart);
            Order order = OrderService.addOrder(user.getUid(), cart);
            System.out.println("success");
            OrderService.saveOrder(order);
            System.out.println("success");
            System.out.println(order);
            request.getSession().setAttribute("order", order);
            request.getSession().setAttribute("orders", cart);
            request.getSession().setAttribute("cart", new Cart());
            response.setStatus(302);
            response.sendRedirect("http://localhost:8080/" + request.getContextPath() + "jsps/order/desc.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void myOrders(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String uid = user.getUid();
        List<Order> myOrders = OrderService.getOrders(uid);
        List<String> bid = OrderService.getOrderBid(myOrders);
        Map<String,Book> orderbooks = BookService.findBookByBid(bid);
        request.setAttribute("myOrders",myOrders);
        request.setAttribute("orderbooks",orderbooks);
        request.getRequestDispatcher("jsps/order/list.jsp").forward(request,response);
    }

    public void confirm(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String oid = request.getParameter("oid");
        try {
            String message = OrderService.queryState(oid);
            request.setAttribute("confirmState",message);
            request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);

        } catch (OrderException e) {
            String message = e.getMessage();
            request.setAttribute("confirmState",message);
            request.getRequestDispatcher("/jsps/order/msg.jsp").forward(request,response);
        }
    }
    public void load(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String oid = request.getParameter("oid");
        Order order =OrderService.getOrderByOid(oid);
        List<String> orderBid = OrderService.getOrderBid(order);
        Map<String, Book> bookByBid = BookService.findBookByBid(orderBid);
        request.setAttribute("order",order);
        request.setAttribute("orderLoad",bookByBid);
        request.getRequestDispatcher("/jsps/order/desc.jsp").forward(request,response);
    }
}
