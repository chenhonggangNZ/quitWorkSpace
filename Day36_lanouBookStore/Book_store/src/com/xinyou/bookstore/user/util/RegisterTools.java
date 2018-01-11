package com.xinyou.bookstore.user.util;

import com.xinyou.bookstore.user.dao.UserDao;
import com.xinyou.bookstore.user.domain.User;
import com.xinyou.bookstore.user.service.SendMessege;
import com.xinyou.bookstore.user.service.exception.*;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Pattern;

public class RegisterTools {
    public static User setInfo(User user) throws SQLException, MessagingException {
        Random random = new Random();
        int i = random.nextInt(9000) + 1000;
        user.setCode(String.valueOf(i));
        user.setState("0");
        int maxUid = UserDao.getMaxUid();
        maxUid++;
        String s = String.valueOf(maxUid);
        user.setUid(s);
        SendMessege sendMessege = new SendMessege();
        sendMessege.setReceiveAddr(user.getEmail());
        String url = "http://localhost:8080/user?method=active&uid="+s+"&code="+user.getCode();
        url="在这个花开的季节里，感谢有你陪伴！<br/><a href='"+url+"'>点击跳转</a>";
        sendMessege.setSendInfo(url);
        sendMessege.t1();
        return user;
    }

    public static void active(String uid,String code) throws SQLException {
        String codeD = UserDao.getCode(uid);
        if (codeD.equals(code)){
        UserDao.setState(uid);
        }
    }

    public static boolean security(String username, String password, String email) throws SQLException, RegisterException {
        registerUserIsReasonable(username);
        isSafe(password);
        isReasonable(email);
        return true;
    }

    public static void isSafe(String password) throws RegisterException {
        if (password.length() < 6){
            throw new PasswordNotSafeException();
        } else if(password.length() > 48){
            throw new PasswordTooLongException();
        }
        if (!Pattern.matches("^(?=.*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*).{6,15}$",password)){
            throw new PasswordNotSafeException();
        }
    }

    public static void registerUserIsReasonable(String in) throws RegisterException, SQLException {
        if (Pattern.matches("\\d*",in)){
            if (!Pattern.matches("[1][3,4,5,6,7,8,9]\\d{9}",in)){
                throw new TelphoneNumberNonexistentException();
            }
            RegisterTools.isExists(in);
        } else {
                isReasonable(in);
        }
    }
    private static void isReasonable(String email) throws RegisterException{
        if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,3}",email)){
        } else if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,4}[.][a-z,A-Z]{2,3}",email)){
        } else {
            throw new MailboxNonexistentException();
        }
    }
    private static void isExists(String username) throws SQLException ,RegisterException {
       String username1 = UserDao.getUsername(username);
        if (username1 == null || username1.equals("")){
           return;
        }
        throw new UserAlreadyExistsException();
    }
}
