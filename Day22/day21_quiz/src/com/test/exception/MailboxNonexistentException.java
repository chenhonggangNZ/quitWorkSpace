package com.test.exception;

public class MailboxNonexistentException extends NonexistentException {
    @Override
    public String getMessage() {
        return "不存在的邮箱！";
    }
}
