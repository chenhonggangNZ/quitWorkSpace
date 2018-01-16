package action.exception;

public class PasswordMismatchingException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码输入不一致";
    }
}
