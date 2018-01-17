package interceptor;

import bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

public class MyInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");

        if (user != null && user.getUsername()!=null){

            return actionInvocation.invoke();
        }
        if (ServletActionContext.getRequest().getParameter("method").equals("register")){
            return actionInvocation.invoke();
        }
            return "success";
    }
}
