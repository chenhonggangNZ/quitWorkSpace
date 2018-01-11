package com.xinyou.bookstore.book.dao;

import com.xinyou.C3P0Util;
import com.xinyou.bookstore.book.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {

    private static QueryRunner queryRunner = new QueryRunner();

    public static Book findBookByBid(String bid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql="SELECT * FROM book WHERE bid=? AND 'delete'=0";
        Book query = queryRunner.query(connection, sql, new BeanHandler<Book>(Book.class), bid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static List<Book> findBookByCid(String cid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql="SELECT * FROM book WHERE cid=? AND 'delete'=0";
        List<Book> query = queryRunner.query(connection, sql, new BeanListHandler<Book>(Book.class), cid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static List<Book> findAllBook() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM book WHERE 'delete'=0";
        List<Book> query = queryRunner.query(connection, sql, new BeanListHandler<Book>(Book.class));
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static String findMaxBid() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT max(bid) FROM book WHERE 'delete'=0";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>());
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void saveBook(Book book) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "INSERT INTO book VALUES(?,?,?,?,?,?,0)";
        queryRunner.update(connection,sql,book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCid());
        C3P0Util.release(null,null,connection);
    }

    public static void editDelete(String bid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "UPDATE book SET 'delete'=0 WHERE bid=?";
        queryRunner.update(connection,sql,bid);
        C3P0Util.release(null,null,connection);
    }

    public static void deleteBook(String bid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "UPDATE book SET 'delete'=1 WHERE bid=?";
        queryRunner.update(connection,sql,bid);
        C3P0Util.release(null,null,connection);
    }

    public static void editBook(Book book) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "UPDATE book SET bid=?,bname=?,price=?,author=?,image=?,cid=?";
        queryRunner.update(connection,sql,book.getBid(),book.getBname(),book.getPrice(),book.getAuthor(),book.getImage(),book.getCid());
        C3P0Util.release(null,null,connection);
    }
}
