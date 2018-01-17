package util;

import action.exception.*;
import dao.UserDao;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class RegisterTools {

    public  static boolean security(String username, String password) throws SQLException, RegisterException {
        registerUserIsReasonable(username);
        isSafe(password);
        return true;
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
