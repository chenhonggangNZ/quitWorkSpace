package service;

import action.exception.LoginException;
import action.exception.PasswordWrongException;
import action.exception.RegisterException;
import action.exception.UserNotExistException;
import bean.User;
import dao.UserDao;
import util.RegisterTools;

import java.sql.SQLException;

import static util.LoginTool.keySet;

public class UserService {
    public static void register(String username, String password, String nickname) throws SQLException, RegisterException {
        RegisterTools.security(username,password);
        UserDao.add(username,password,nickname);
    }
    public static User login(String username, String password) throws SQLException,LoginException {
        User user = UserDao.getUserByUsername(username);
        if (user == null ||user.getUsername()==null||!user.getUsername().equals(username)){
            throw new UserNotExistException();
        }
        if (!user.getPassword().equals(password)){
            throw new PasswordWrongException();
        }
        user.setPassword(keySet(password));
        return user;
    }

}
