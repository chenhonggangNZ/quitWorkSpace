package com.xinyou.bookstore.order.dao;

import com.xinyou.C3P0Util;
import com.xinyou.bookstore.order.domain.Order;
import com.xinyou.bookstore.order.domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private static QueryRunner queryRunner = new QueryRunner();

    public static String getMaxOid() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT max(oid) FROM orders";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>());
        C3P0Util.release(null,null,connection);
        System.out.println(query);
        return query;
    }

    public static String getMaxIid() throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql ="SELECT max(iid) FROM orderitem ";
        String query = queryRunner.query(connection, sql, new ScalarHandler<String>());
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void saveOrder(Order order) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "INSERT INTO orders VALUES(?,?,?,?,?,?)";
        int update = queryRunner.update(connection, sql, order.getOid(), order.getOrdertime(), order.getPrice(), order.getStatus(), order.getUid(), order.getAddress());
        sql = "INSERT INTO orderitem VALUES(?,?,?,?,?)";
        String a = null;
        int count = 0;
        for (OrderItem orderItem : order.getOrderItem().values()) {
            int update1 = queryRunner.update(connection, sql,
                    orderItem.getIid(), orderItem.getCount(), orderItem.getSubtotal(), orderItem.getOid(), orderItem
                    .getBid());
        }
        C3P0Util.release(null,null,connection);
    }

    public static List<Order> findOrderByUid(String uid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM orders WHERE uid=?";
        List<Order> query = queryRunner.query(connection, sql,new BeanListHandler<Order>(Order.class),uid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static Map<String, OrderItem> findOrderItemByOid(String oid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql ="SELECT * FROM orderitem WHERE oid=?";
        Map<String, OrderItem> query = queryRunner.query(connection, sql, new BeanMapHandler<String, OrderItem>(OrderItem.class), oid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static int getStateByOid(String oid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT state FROM orders WHERE oid=?";
        Integer query = queryRunner.query(connection, sql, new ScalarHandler<Integer>(), oid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void updateState(String oid, int i) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql ="UPDATE orders SET state=? WHERE oid=?";
        int update = queryRunner.update(connection, sql, i, oid);
        C3P0Util.release(null,null,connection);
    }
    public static Order findOrderByOid(String oid) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "SELECT * FROM orders WHERE oid=?";
        Order query = queryRunner.query(connection, sql, new BeanHandler<Order>(Order.class), oid);
        C3P0Util.release(null,null,connection);
        return query;
    }

    public static void edit(String cid, String cname) throws SQLException {
        Connection connection = C3P0Util.getConnection();
        String sql = "UPDATE category SET cname=? WHERE cid=?";
        queryRunner.update(connection,sql,cname,cid);
        C3P0Util.release(null,null,connection);
    }
}
