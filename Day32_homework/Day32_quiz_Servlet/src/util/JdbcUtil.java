package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String user;
    private static String url;
    private static String password;
    private static String database;

    static {
        try {
            ClassLoader cl = JdbcUtil.class.getClassLoader();
            InputStream inputStream = cl.getResourceAsStream("jdbc.properties");
            Properties info = new Properties();
            info.load(inputStream);
            url = info.getProperty("url");
            user = info.getProperty("user");
            password = info.getProperty("password");

            database = info.getProperty("database");

            Class.forName(info.getProperty("driverName"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        try {

            Connection conn = DriverManager.getConnection(url+database,user,password );
            return conn;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void execute(ExecuteInter e){
        try {

            Connection conn = DriverManager.getConnection(url+database,user,password );
            e.execute(conn).close();
            conn.close();
        }catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void showRs(ResultSet rs) throws SQLException {
        while (rs.next()){
            System.out.print(rs.getString(1)+"\t");
//            System.out.print(rs.getString(2)+"\t");
//            System.out.print(rs.getString(3)+"\t");
//            System.out.print(rs.getString(4)+"\t");
            System.out.println();
        }
    }
}
