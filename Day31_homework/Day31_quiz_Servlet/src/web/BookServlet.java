package web;

import bean.Book;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "BookServlet",urlPatterns = "/savebook")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
        Object attribute = request.getSession().getAttribute("username");
        if(attribute == null || attribute.equals("")){
            response.setStatus(302);
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        } else {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Book book = new Book();
            try {
                BeanUtils.populate(book,parameterMap);
                if(dao.BookDao.save(book)){
                    response.setStatus(200);
                    response.getWriter().write("success");
                } else {
                    response.getWriter().write("false");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
