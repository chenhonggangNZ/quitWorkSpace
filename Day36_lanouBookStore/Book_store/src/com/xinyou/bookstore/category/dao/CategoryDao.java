package com.xinyou.bookstore.category.dao;

import com.xinyou.C3P0Util;
import com.xinyou.bookstore.category.domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    private static QueryRunner queryRunner = new QueryRunner();
    public static List<Category> findAll() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql="SELECT * FROM category";
        List<Category> query = queryRunner.query(connection, sql, new BeanListHandler<Category>(Category.class));
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static Category findCategoryByCname(String cname) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM category WHERE cname=?";
        Category query = queryRunner.query(connection, sql, new BeanHandler<Category>(Category.class), cname);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static String findMaxCid() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT max(cid) FROM category";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>());
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void addCategory(String cid, String cname) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "INSERT INTO category VALUES(?,?)";
        queryRunner.update(connection,sql,cid,cname);
        C3P0Util.release(null,null,connection);
    }

    public static void delete(String cid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "DELETE FROM category WHERE cid=?";
        queryRunner.update(connection, sql, cid);
        C3P0Util.release(null,null,connection);
    }
}
