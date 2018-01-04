package web;

import bean.Person;
import dao.PersonDao;
import net.sf.json.JSONArray;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="SelectServlet",urlPatterns = "/info")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Object username = req.getSession().getAttribute("username");
        if(username == null || username.equals("")){
            resp.getWriter().write("请登录！");
        } else {
//            int uid = (int) req.getServletContext().getAttribute("uid");
            resp.setContentType("text/html;charset=utf-8");
            List<Person> persons = null;
            try {
                persons = PersonDao.query(new Person());
                JSONArray jsonArray = JSONArray.fromObject(persons);
                resp.getWriter().write(jsonArray.toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
