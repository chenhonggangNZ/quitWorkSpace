package action;

import bean.Admin;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.AdminService;
import util.exception.LoginException;

public class LoginAction extends ActionSupport {
    private Admin admin = new Admin() ;

    public String login(){
        try {
            String parameter = ServletActionContext.getRequest().getParameter("admin.username");
            admin.setUsername(parameter);
            admin.setPassword(ServletActionContext.getRequest().getParameter("admin.password"));
            if (AdminService.istrue(admin)){
                ServletActionContext.getRequest().getSession().setAttribute("admin",admin);
            }
        } catch (LoginException e) {
            String message = e.getMessage();
            ServletActionContext.getRequest().setAttribute("message",message);
            return ERROR;
        }
        return SUCCESS;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
