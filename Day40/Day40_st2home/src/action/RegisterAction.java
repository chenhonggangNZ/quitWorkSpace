package action;

import action.exception.RegisterException;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegisterAction extends ActionSupport {
    private User user = new User();


    public String register() throws SQLException {
        UserService.register(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
