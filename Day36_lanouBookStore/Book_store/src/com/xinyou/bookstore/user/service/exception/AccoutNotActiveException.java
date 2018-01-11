package com.xinyou.bookstore.user.service.exception;

public class AccoutNotActiveException extends LoginException {
    @Override
    public String getMessage() {
        return "账号尚未激活，请先激活账号！";
    }
}
