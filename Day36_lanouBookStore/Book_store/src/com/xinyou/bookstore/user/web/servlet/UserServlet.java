package com.xinyou.bookstore.user.web.servlet;
import com.lanou.servlet.BaseServlet;
import com.xinyou.bookstore.cart.domain.Cart;
import com.xinyou.bookstore.user.dao.UserDao;
import com.xinyou.bookstore.user.domain.User;
import com.xinyou.bookstore.user.service.UserService;
import com.xinyou.bookstore.user.service.exception.LoginException;
import com.xinyou.bookstore.user.service.exception.RegisterException;
import com.xinyou.bookstore.user.util.RegisterTools;
import net.sf.json.JSONArray;
import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
   public void register(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException, MessagingException {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      String email = request.getParameter("email");
      request.setAttribute("username",username);
      request.setAttribute("password",password);
      request.setAttribute("email",email);
      User user = new User(null,username,password,email,null,null);
      try {
         if ( RegisterTools.security(username,password,email)) {
            User user1 = RegisterTools.setInfo(user);
            UserDao.saveUser(user1);
            response.getWriter().write("REGISTER SUCCESS!");
            response.setStatus(302);
            response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"/jsps/msg.jsp");
         }
      } catch (RegisterException e) {
         user.getError().setError(e.getMessage());
         response.setContentType("application/json");
         JSONArray jsonArray = JSONArray.fromObject(user);
         response.getWriter().write(jsonArray.toString());
      }
   }
   public void login(HttpServletRequest request,HttpServletResponse response) throws IOException {
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      try {
         User service = UserService.toBeSafe(UserService.service(username, password));
         request.getSession().setAttribute("username",username);
         request.getSession().setAttribute("user",service);
         Cart cart = new Cart();
         request.getSession().setAttribute("cart",cart);
         response.setStatus(302);
         response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"/index.jsp");
      } catch (LoginException e) {
         request.setAttribute("username",username);
         request.setAttribute("password",password);
         System.out.println(e.getMessage());
         response.setStatus(302);
         response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"jsps/user/login.jsp?error="+e.getMessage());
//         response.getWriter().write(e.getMessage());
      }
   }
   public void active(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
      String uid = request.getParameter("uid");
      String code = request.getParameter("code");
      RegisterTools.active(uid,code);
      response.setStatus(302);
      response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"index.jsp");
   }

   public void quit(HttpServletRequest request,HttpServletResponse response) throws IOException {
      request.getSession().setAttribute("user",null);
      request.getSession().setAttribute("username",null);
      request.getSession().setAttribute("book",null);
      request.getSession().setAttribute("cart",null);
      response.setStatus(302);
      response.sendRedirect("http://localhost:8080/"+request.getContextPath()+"index.jsp");
   }
}
