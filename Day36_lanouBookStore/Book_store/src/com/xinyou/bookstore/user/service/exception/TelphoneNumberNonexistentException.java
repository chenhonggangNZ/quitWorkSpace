package com.xinyou.bookstore.user.service.exception;

public class TelphoneNumberNonexistentException extends NonexistentException {
    @Override
    public String getMessage() {
        return "不存在的手机号码！";
    }
}
