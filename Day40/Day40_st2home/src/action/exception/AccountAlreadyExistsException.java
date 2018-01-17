package action.exception;

public class AccountAlreadyExistsException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在！";
    }
}
