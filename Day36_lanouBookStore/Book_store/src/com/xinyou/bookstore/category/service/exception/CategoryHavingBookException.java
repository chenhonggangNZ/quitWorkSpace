package com.xinyou.bookstore.category.service.exception;

public class CategoryHavingBookException extends CategoryException {

    @Override
    public String getMessage() {
        return "该分类下存在关联的图书！";
    }
}
