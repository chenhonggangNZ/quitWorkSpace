package bean.exception;

public class UserNotExistException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在！";
    }
}
