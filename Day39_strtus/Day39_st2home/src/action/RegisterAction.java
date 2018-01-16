package action;

import action.exception.RegisterException;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.ServletActionContext;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegisterAction extends ActionSupport {
    public String register() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        try {
            UserService.register(username,password,nickname);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            request.setAttribute("message",message);
            return "wrong";
        }
        return SUCCESS;
    }
}
