package com.xinyou.bookstore.user.dao;

import com.xinyou.C3P0Util;
import com.xinyou.bookstore.user.domain.Admin;
import com.xinyou.bookstore.user.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private static QueryRunner queryRunner = new QueryRunner();

    public static User findByUsername(String username) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM user WHERE username=?";
        User query = queryRunner.query(connection, sql, new BeanHandler<User>(User.class), username);
        C3P0Util.release(null,null,connection);
        return query;
    }
    public static String getUsername(String username) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT username FROM user WHERE username=?";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>(), username);
        C3P0Util.release(null,null,connection);
        return query;
    }
    public static void saveUser(User user) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "INSERT INTO user VALUES(?,?,?,?,?,?)";
        queryRunner.update(connection, sql,user.getUid(), user.getUsername(), user.getPassword(), user.getEmail(), user.getCode(), user.getState());
        C3P0Util.release(null,null,connection);
    }

    public static int getMaxUid() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT MAX(uid) FROM user";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>());
        C3P0Util.release(null,null,connection);

        return Integer.parseInt(query);
    }

    public static boolean setState(String uid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "UPDATE user SET state=true WHERE uid=?";
        int update = queryRunner.update(connection, sql, uid);
        C3P0Util.release(null,null,connection);
        return true;
    }

    public static String getCode(String uid) throws SQLException {
       Connection connection = C3P0Util.getConnection();
       String sql = "SELECT code FROM user WHERE uid=?";
       String query = queryRunner.query(connection, sql, new ScalarHandler<String>(), uid);
       C3P0Util.release(null,null,connection);
       return query;
    }

    public static Admin findAdminByadminname(String adminname) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM admin WHERE adminname=?";
        Admin query = queryRunner.query(connection, sql, new BeanHandler<Admin>(Admin.class), adminname);
        C3P0Util.release(null,null,connection);
        return query;
    }
}
