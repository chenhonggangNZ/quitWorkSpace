package dao;

import bean.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao{
    private static String sql;
    private static QueryRunner queryRunner = new QueryRunner();

    public static boolean save(Book book) throws SQLException {
            Connection connection = JdbcUtil.getConnection();
            sql = "INSERT INTO book VALUES(null,?,?,?)";
            int update = queryRunner.update(connection, sql, book.getBookname(), book.getWriter(), book.getPrice());
            connection.close();
            return true;
        }

        public static List<Book> query() throws SQLException {
            Connection connection = JdbcUtil.getConnection();
            sql = "SELECT bookname,writer,price FROM book";
            List<Book> query = queryRunner.query(connection, sql, new BeanListHandler<Book>(Book.class));
            connection.close();
            return query;
        }
}
