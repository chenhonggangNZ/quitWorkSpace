package com.xinyou.bookstore.user.service.exception;

public class UnreasonableUserNameException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名过短或过长或用户名不合法！";
    }
}
