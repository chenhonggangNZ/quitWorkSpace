package dao;

import bean.Person;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonDao {

    private static QueryRunner queryRunner = new QueryRunner();
    private static String sql;

    public static List<Person> query(Person person) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        sql = "SELECT name,gender,age,job,username,password FROM users AS a INNER JOIN person AS b ON a.uid=b.uid";
        List<Person> query = queryRunner.query(connection, sql, new BeanListHandler<Person>(Person.class));
        connection.close();
        return query;
    }
}
