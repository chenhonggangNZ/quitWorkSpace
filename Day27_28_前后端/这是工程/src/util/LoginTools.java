package util;

import exception.LoginException;
import exception.UserOrPasswordWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginTools {


    public static int LoginInput() throws LoginException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名！");
        String user = input.nextLine();
        System.out.println("请输入密码！");
        String password = input.nextLine();
         int uid = istrue(user,password);
        return uid;
    }

    private static int istrue(String user, String password) throws SQLException ,LoginException{
        Connection connection = JdbcUtil.getConnection();
        String sql = "SELECT uid FROM users WHERE username=? AND password=?";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,user);
        pstate.setString(2,password);
        ResultSet resultSet = pstate.executeQuery();
        int uid = 10;
        if(resultSet.next()){
            String a = resultSet.getString(1);
           try {
               uid = Integer.parseInt(a);
           } catch (NumberFormatException e){
               System.out.println(e.getMessage());
               pstate.close();
               connection.close();
               throw new UserOrPasswordWrongException();
           }
        }
        pstate.close();
        connection.close();
        return uid;
    }
}
