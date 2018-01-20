package util;

import org.hibernate.Session;

public interface ResultHandle<T> {
     T resultHandle(Session session);
}
