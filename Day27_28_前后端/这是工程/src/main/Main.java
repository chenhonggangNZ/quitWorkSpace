package main;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = JdbcUtil.getConnection();
        String sql = "SELECT uid FROM person";
        try {
            PreparedStatement pstate = connection.prepareStatement(sql);
            ResultSet resultSet = pstate.executeQuery();
            while(resultSet.next()){
                String info = resultSet.getString(1);
                System.out.println(info);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
