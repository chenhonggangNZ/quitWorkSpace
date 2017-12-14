package Java.util.exception;

public class PasswordNotSafeException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不够安全！";
    }
}
