package action;

import com.opensymphony.xwork2.ActionSupport;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import java.io.IOException;

public class CodeImgAction extends ActionSupport {
    @SkipValidation
    public String codeImg() throws IOException{
        String output1 = VerifyCode.getInstance().output(ServletActionContext.getResponse().getOutputStream());
        ServletActionContext.getRequest().setAttribute("focs",output1);
        return SUCCESS;
    }
}
