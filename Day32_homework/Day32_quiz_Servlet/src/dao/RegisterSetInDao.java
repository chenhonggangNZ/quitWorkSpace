package dao;

import bean.Person;
import bean.exception.RegisterException;
import bean.exception.UserAlreadyExistsException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterSetInDao {

    private static QueryRunner queryRunner = new QueryRunner();
    private static String sql;

    public static boolean setIn(Person person) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        sql = "INSERT INTO users VALUES(null,?,null,?)";
        queryRunner.update(connection, sql,person.getUsername(),person.getPassword());
        sql = "SELECT uid FROM users WHERE username=? AND password=?";
        Integer query = queryRunner.query(connection, sql, new ScalarHandler<Integer>(), person.getUsername(), person.getPassword());
        int a = query;

        sql = "INSERT INTO person VALUES(?,?,?,?,?)";
        queryRunner.update(connection,sql,String.valueOf(a),person.getName(),person.getAge(),person.getGender(),person.getJob());
        connection.close();
        return true;
    }

    public static void isExists(String in) throws RegisterException, SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql = "SELECT username FROM users WHERE username=?";
        String query = queryRunner.query(connection,sql, new ScalarHandler<String>(),in);
        connection.close();
        if(query.equals(in)){
            throw new UserAlreadyExistsException();
        }
    }
}
