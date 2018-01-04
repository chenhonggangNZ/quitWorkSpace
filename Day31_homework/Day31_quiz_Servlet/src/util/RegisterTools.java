package util;

import bean.Person;
import bean.exception.*;

import java.sql.SQLException;
import java.util.regex.Pattern;

import dao.RegisterSetInDao;

public class RegisterTools {
    private static boolean flag = true;
    private static int num=0;


    public static boolean Register(Person person) throws SQLException, RegisterException {

        registerUserIsReasonable(person.getUsername());
        isSafe(person.getPassword());
        return true;
    }

    public static int toInt(String age_s) {
        int age = 18;
        try {
            age = Integer.parseInt(age_s);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return age;
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
                RegisterSetInDao.isExists(in);
            } else {

                if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,3}",in)){
                    RegisterSetInDao.isExists(in);
                } else if (Pattern.matches("\\w*[@]\\w*[.][a-z,A-Z]{2,4}[.][a-z,A-Z]{2,3}",in)){
                    RegisterSetInDao.isExists(in);
                } else {
                    throw new MailboxNonexistentException();
                }
            }
    }

}
