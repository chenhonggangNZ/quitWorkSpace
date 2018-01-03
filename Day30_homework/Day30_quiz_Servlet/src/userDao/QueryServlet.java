package userDao;

import bean.Book;
import net.sf.json.JSONArray;
import util.BookTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet",urlPatterns = "/getbooks")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = BookTools.query();
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        System.out.println(jsonArray.toString());
        response.getWriter().write(jsonArray.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = BookTools.query();
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        System.out.println(jsonArray.toString());
        response.getWriter().write(jsonArray.toString());
    }
}
