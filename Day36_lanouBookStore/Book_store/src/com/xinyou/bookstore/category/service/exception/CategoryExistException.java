package com.xinyou.bookstore.category.service.exception;

public class CategoryExistException extends CategoryException {
    @Override
    public String getMessage() {
        return "该分类已经存在！";
    }
}
