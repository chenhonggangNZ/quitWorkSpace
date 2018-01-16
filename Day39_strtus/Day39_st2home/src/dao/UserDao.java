package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private static QueryRunner queryRunner = new QueryRunner();
    public static User getUserByUsername(String username) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM users WHERE username=?";
        User query = queryRunner.query(connection, sql, new BeanHandler<User>(User.class),username);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static String getUsername(String username) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT username FROM users WHERE username=?";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>(), username);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void add(String username, String password, String nickname) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "INSERT INTO users VALUES(null,?,?,?)";
        queryRunner.update(connection,sql,username,nickname,password);
        C3P0Util.release(null,null,connection);
    }
}
