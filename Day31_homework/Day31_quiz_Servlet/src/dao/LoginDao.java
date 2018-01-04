package dao;

import bean.exception.LoginException;
import bean.exception.UserOrPasswordWrongException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private static QueryRunner queryRunner = new QueryRunner();
    private static String sql;

    private LoginDao(){

    }

    public static int istrue(String user, String password) throws SQLException ,LoginException{
        Connection connection = JdbcUtil.getConnection();
        sql = "SELECT uid FROM users WHERE username=? AND password=?";
        Integer query = queryRunner.query(connection, sql, new ScalarHandler<Integer>(), user, password);
        connection.close();
        int a = -12;
        try{
            a = query;
        } catch (Exception e){}
        return a;
    }
}
