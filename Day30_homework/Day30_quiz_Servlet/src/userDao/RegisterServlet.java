package userDao;

import bean.Person;
import org.apache.commons.beanutils.BeanUtils;
import util.SetInTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Person person = new Person();
        try {
            BeanUtils.populate(person,parameterMap);
            if (SetInTools.SetIn(person)){
                resp.setStatus(302);
                resp.sendRedirect("http://localhost:8080"+req.getContextPath()+"/login.jsp");
            } else {
                resp.setStatus(302);
                resp.sendRedirect("http://localhost:8080"+req.getContextPath()+"/Register.html");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
