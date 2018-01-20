package action;

import bean.Admin;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

public class AllInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
//        Admin admin = (Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
//        if (admin == null ||admin.getUsername() == null ||admin.getUsername().equals("")){
////            System.out.println("dfgg");
//            return actionInvocation.invoke();
//        } else {
//            String invoke = actionInvocation.invoke();
//            return invoke;
//        }
        return actionInvocation.invoke();
    }
}
