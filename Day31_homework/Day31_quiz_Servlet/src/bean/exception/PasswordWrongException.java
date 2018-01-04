package bean.exception;

public class PasswordWrongException extends LoginException {
    @Override
    public String getMessage() {
        return "密码错误！";
    }
}
