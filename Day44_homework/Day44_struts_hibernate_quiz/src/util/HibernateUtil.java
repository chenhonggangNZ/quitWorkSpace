package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    static SessionFactory sf;

    static {
        sf = new Configuration().configure().buildSessionFactory();
    }

    public static <T> T handle(ResultHandle<T> rh){
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        T t = rh.resultHandle(session);
        transaction.commit();
        session.close();
        return t;
    }
}
