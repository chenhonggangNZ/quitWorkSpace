package web;

import bean.exception.LoginException;
import dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            int istrue = LoginDao.istrue(username, password);
            if (istrue == -12){
                resp.setStatus(302);
                resp.sendRedirect("http://localhost:8080"+req.getContextPath()+"/login.jsp");
            } else {
                req.getSession().setAttribute("username",username);
                req.getSession().setAttribute("before",username);
                //req.getServletContext().setAttribute("uid",istrue);
                resp.setStatus(302);
                resp.sendRedirect("http://localhost:8080"+req.getContextPath()+"/index.jsp");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            e.printStackTrace();
        }

    }
}
