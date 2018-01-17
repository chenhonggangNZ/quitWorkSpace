package action;

import action.exception.LoginException;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDao;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class LoginAction extends ActionSupport{
    private User user = new User();
    private static int key = 50;
    @SkipValidation
    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = UserService.login(username, password);
        } catch (Exception e) {
            e.printStackTrace();
            String message = e.getMessage();
            request.setAttribute("message",message);
            return "wrong";
        }
        request.getSession().setAttribute("user",user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static void setKey(int key) {
        LoginAction.key = key;
    }

    public  static String keySet(String value){
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
        }
        return new String(bytes);
    }
}
