package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String user;
    private static String url;
    private static String password;
    private static String database;

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src\\jdbc.properties"));
            String driverName = prop.getProperty("driverName");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

            database = prop.getProperty("database");
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage()+"\n\t\t"+"请将配置文件jdbc.properties放置到src目录下");
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
    public static String getUsername(int uid) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT username FROM users WHERE uid=?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,String.valueOf(uid));
        ResultSet resultSet = pstate.executeQuery();
        String a = getString(connection, pstate, resultSet);
        pstate.close();
        connection.close();
        return null;
    }

    public static String getPassword(int uid) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT password FROM users WHERE uid=?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,String.valueOf(uid));
        ResultSet resultSet = pstate.executeQuery();
        String a = getString(connection, pstate, resultSet);
        if (a != null) return a;
        pstate.close();
        connection.close();
        return null;
    }

    private static String getString(Connection connection, PreparedStatement pstate, ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            String a = resultSet.getString(1);
            pstate.close();
            connection.close();
            return a;
        }
        return null;
    }

    public static String getName(int uid) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT name FROM person WHERE uid=?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,String.valueOf(uid));
        ResultSet resultSet = pstate.executeQuery();
        String a = getString(connection, pstate, resultSet);
        if (a != null) return a;
        pstate.close();
        connection.close();
        return null;
    }

    public static String getJob(int uid) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT job FROM person WHERE uid=?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,String.valueOf(uid));
        ResultSet resultSet = pstate.executeQuery();
        String a = getString(connection, pstate, resultSet);
        if (a != null) return a;
        pstate.close();
        connection.close();
        return null;
    }
}
