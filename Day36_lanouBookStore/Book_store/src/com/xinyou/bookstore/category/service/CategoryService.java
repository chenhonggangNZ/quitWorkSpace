package com.xinyou.bookstore.category.service;

import com.xinyou.bookstore.book.dao.BookDao;
import com.xinyou.bookstore.book.domain.Book;
import com.xinyou.bookstore.category.dao.CategoryDao;
import com.xinyou.bookstore.category.domain.Category;
import com.xinyou.bookstore.category.service.exception.CategoryException;
import com.xinyou.bookstore.category.service.exception.CategoryExistException;
import com.xinyou.bookstore.category.service.exception.CategoryHavingBookException;
import com.xinyou.bookstore.order.dao.OrderDao;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    public static List<Category> findAll() throws SQLException {
        return CategoryDao.findAll();
    }

    public static void addCategory(String cname) throws SQLException,CategoryException {
        Category category = CategoryDao.findCategoryByCname(cname);
        if (category != null&&category.getCname().equals(cname)){
            throw new CategoryExistException();
        }
        String i = CategoryDao.findMaxCid();
        int cid = 0;
        try{
            cid = Integer.parseInt(i);
            cid++;
        }catch (java.lang.NumberFormatException e){}
        CategoryDao.addCategory(String.valueOf(cid),cname);
    }

    public static void delete(String cid) throws SQLException,CategoryException {
        List<Book> bookByCid = BookDao.findBookByCid(cid);
        if (bookByCid != null && bookByCid.size() > 0){
            throw new CategoryHavingBookException();
        }
        CategoryDao.delete(cid);
    }

    public static void edit(String cid, String cname) throws SQLException {
        OrderDao.edit(cid,cname);
    }
}
