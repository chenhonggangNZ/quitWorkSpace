package service;

import bean.Admin;
import org.hibernate.Query;
import util.HibernateUtil;
import util.exception.LoginException;
import util.exception.PasswordWrongException;
import util.exception.UserNotExistException;

import java.util.List;

public class AdminService {
    public static boolean istrue(Admin admin) throws LoginException {
        Admin handle = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from Admin as admin where admin.username=:username and admin.password=:password");
            query.setString("username", admin.getUsername());
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
            query.setString("password", admin.getPassword());
            List<Admin> list = query.list();
            for (Admin admin1 : list) {
                System.out.println(admin1);
                return admin1;
            }
            return new Admin();
        });
        if (handle == null || handle.getUsername() == null){
            throw new UserNotExistException();
        } else {
          if (!handle.getUsername().equals(admin.getUsername())){
              throw new UserNotExistException();
          } else {
              if (handle.getPassword()==null||!handle.getPassword().equals(admin.getPassword())){
                  throw new PasswordWrongException();
              }
          }
        }
        return true;
    }
}
