package util.exception;

public class AdminNotExistException extends AdminException {
    @Override
    public String getMessage() {
        return "对不起，没有找到此管理员的信息！";
    }
}
