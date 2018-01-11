package com.xinyou.bookstore.user.service;

import com.xinyou.bookstore.user.dao.UserDao;
import com.xinyou.bookstore.user.domain.Admin;
import com.xinyou.bookstore.user.domain.User;
import com.xinyou.bookstore.user.service.exception.*;

import java.sql.SQLException;

public class UserService {
    private static int key = 50;
    private static int old_key = 50;

    public static User service(String username, String password)throws LoginException {
        try {
            User user = UserDao.findByUsername(username);
            if (user == null||user.getUsername()==null){
                throw new UserNotExistException();
            }
            if(user.getPassword().equals(password)){
                if (user.getCode().equals("0")){
                    throw new AccoutNotActiveException();
                }
                return user;
            } else {
                throw new PasswordWrongException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new User();
        }
    }

    public static void setKey(int key) {
        UserService.old_key = UserService.key;
        UserService.key = key;
    }

    public static User toBeSafe(User user){
        String encryption = encryption(user.getPassword());
        user.setPassword(encryption);
        return user;
    }

    public static String encryption(String value){
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
        }
        return new String(bytes);
    }

    public  static String decrypt(String value){
        byte[] bytes = value.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
        }
        return new String(bytes);
    }

    public static boolean isAdmin(Admin admin) throws SQLException, AdminException {
        if (admin == null){
            return false;
        } else if (admin.getAdminname() == null){
            return false;
        } else{
            isExist(admin.getAdminname());
        }
        return true;
    }

    private static void isExist(String adminname) throws SQLException ,AdminException{
        Admin admin = UserDao.findAdminByadminname(adminname);
        if (admin == null||!(admin.getAdminname().equals(adminname))){
            throw new AdminNotExistException();
        }
    }

    public static Admin adminLogin(String adminname, String password) throws SQLException,LoginException {
        Admin adminByadminname = UserDao.findAdminByadminname(adminname);
        if (adminByadminname == null||! (adminByadminname.getAdminname().equals(adminname))){
            throw new AdminNotExistException();
        }
        if (adminByadminname.getPassword().equals(password)){
            return adminByadminname;
        }
        throw new PasswordWrongException();
    }
}
