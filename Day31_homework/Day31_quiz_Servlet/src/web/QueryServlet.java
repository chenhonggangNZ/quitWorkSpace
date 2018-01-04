package web;

import bean.Book;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "QueryServlet",urlPatterns = "/getbooks")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Book> bookList = null;
//        try {
//            bookList = dao.BookDao.query();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        JSONArray jsonArray = JSONArray.fromObject(bookList);
//        System.out.println(jsonArray.toString());
//        response.getWriter().write(jsonArray.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object username = request.getSession().getAttribute("username");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        if(username == null || username.equals("")){
            response.getWriter().write("请登录！");
        } else {
            List<Book> bookList = null;
            try {
                bookList = dao.BookDao.query();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            JSONArray jsonArray = JSONArray.fromObject(bookList);
            response.getWriter().write(jsonArray.toString());
        }
    }
}
