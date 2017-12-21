package com.util;

import com.test.exception.*;

import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegisterTools {
    private static boolean flag = true;
    private static int num=0;


    public static boolean Register() throws RegisterException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入手机号或邮箱账号完成注册");
        String user = input.nextLine();
        RegisterUserIsReasonable(user);
        System.out.println("请输入密码");
        String password = input.nextLine();
        isSafe(password);
        System.out.println("请再次输入您的密码");
        String relins = input.nextLine();
        if(relins.equals(password) == false){
            throw new PasswordMismatchingException();
        }
        System.out.println("请输入您的昵称");
        String nick = input.nextLine();
        int uid = createUsers(user,password,nick);
        boolean result = setInfo(input,uid);

        return result;
    }

    private static boolean setInfo(Scanner input, int uid) throws SQLException {
        System.out.println("请输入您的姓名");
        String name = input.nextLine();
        System.out.println("请输入您的年龄");
        String age_s = input.nextLine();
        int age = ToInt(age_s);
        System.out.println("请输入您的性别");
        String gender = input.nextLine();
        System.out.println("请输入您的职业");
        String job = input.nextLine();
        Connection connection = JdbcUtil.getConnection();
        String sql = "INSERT INTO person VALUES(?,?,?,?,?)";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,String.valueOf(uid));
        pstate.setString(2,name);
        pstate.setString(3,String.valueOf(age));
        pstate.setString(4,gender);
        pstate.setString(5,job);
        pstate.executeUpdate();
        pstate.close();
        connection.close();
        return true;
    }

    private static int createUsers(String user, String password, String nick) throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        String sql = "INSERT INTO users VALUES(null,?,?,?)";
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,user);
        pstate.setString(2,nick);
        pstate.setString(3,password);
        int i = pstate.executeUpdate();
       pstate.close();
       String uid = "SELECT uid FROM users WHERE username=?";
        PreparedStatement statement = connection.prepareStatement(uid);
        statement.setString(1,user);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()){
            String a = resultSet.getString(1);
            statement.close();
            connection.close();
            return Integer.parseInt(a);
        }
        pstate.close();
        connection.close();
        return 0;
    }

    private static int ToInt(String age_s) {
        int age = 18;
        try {
            age = Integer.parseInt(age_s);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return age;
    }

    private static void isSafe(String password) throws RegisterException {
        if (password.length() < 6){
            throw new PasswordNotSafeException();
        } else if(password.length() > 48){
            throw new PasswordTooLongException();
        }
        if (!Pattern.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*).{6,15}$",password)){
            throw new PasswordNotSafeException();
        }
    }

    private static void RegisterUserIsReasonable(String in) throws RegisterException, SQLException {
            if (Pattern.matches("\\d*",in)){
                if (!Pattern.matches("[1][3,4,5,6,7,8,9]\\d{9}",in)){
                    throw new TelphoneNumberNonexistentException();
                }
                isExists(in);
            } else {

                if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,3}",in)){
                    isExists(in);
                } else if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,4}[.][a-z,A-Z]{2,3}",in)){
                    isExists(in);
                } else {
                    throw new MailboxNonexistentException();
                }
            }
    }

    private static void isExists(String in) throws RegisterException, SQLException {
        Connection connection = JdbcUtil.getConnection();
            String sql = "SELECT username FROM users WHERE username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,in);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String a = resultSet.getString(1);
                if(in.equals(a)){
                    statement.close();
                    connection.close();
                    throw new UserAlreadyExistsException();
                }
            }
            statement.close();
            connection.close();

    }

}
