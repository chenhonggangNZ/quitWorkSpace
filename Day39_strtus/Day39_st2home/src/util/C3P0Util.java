package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by travelround on 17/4/18.
 */
public class C3P0Util {


    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() {

        try {
            //获得连接
            return dataSource.getConnection();
        } catch (SQLException e) {
            //失败则返回一个异常信息
            throw new RuntimeException("服务器忙...");
        }
    }

    //回收连接
    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        setState(resultSet);
        setState(stmt);
        setState(connection);
    }

    private static void setState(Object connection) {
        if (connection != null) {
            try {
                //判断类型是否匹配
                if (connection instanceof Connection){
                    ((Connection)connection).close();
                } else if (connection instanceof ResultSet){
                    ((ResultSet)connection).close();
                } else {
                    ((Statement)connection).close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }


}
