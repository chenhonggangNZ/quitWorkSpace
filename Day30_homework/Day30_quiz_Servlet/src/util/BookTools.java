package util;

import bean.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookTools {

    private static PreparedStatement pstate;
    private static String sql;
    private static ResultSet resultSet;
    private static String bookname;
    private static String writer;
    private static String price;

    public static boolean save(Book book){
        Connection connection = JdbcUtil.getConnection();
        try{
            sql = "INSERT INTO book VALUES(null,?,?,?)";
        pstate = connection.prepareStatement(sql);
        pstate.setString(1,book.getBookname());
        pstate.setString(2,book.getWriter());
        pstate.setString(3,String.valueOf(book.getPrice()));
            int i = pstate.executeUpdate();
            pstate.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Book> query() {
        Connection connection = JdbcUtil.getConnection();
        List<Book> book = new ArrayList<>();
        try {
            sql = "SELECT * FROM book";
            pstate = connection.prepareStatement(sql);
            resultSet = pstate.executeQuery();
            while (resultSet.next()){
                bookname = resultSet.getString(2);
                writer = resultSet.getString(3);
                price = resultSet.getString(4);
                book.add(new Book(bookname,writer,Integer.parseInt(price)));
            }
//            resultSet.close();
//            pstate.close();
            connection.close();
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("在这里");
        return book;
    }
}
