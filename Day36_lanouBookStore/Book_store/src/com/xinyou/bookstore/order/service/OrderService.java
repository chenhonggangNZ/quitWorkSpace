package com.xinyou.bookstore.order.service;

import com.xinyou.bookstore.cart.domain.CarOderItem;
import com.xinyou.bookstore.cart.domain.Cart;
import com.xinyou.bookstore.order.dao.OrderDao;
import com.xinyou.bookstore.order.domain.Order;
import com.xinyou.bookstore.order.domain.OrderItem;
import com.xinyou.bookstore.order.service.exception.OrderException;
import com.xinyou.bookstore.order.service.exception.OrderStateException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderService {
    public static Order addOrder(String uid, Cart cart) throws SQLException {
        Order order =  new Order();
        double sum = 0.00;
        order.setUid(uid);
        int i = 1;
        try{
         i = Integer.parseInt(OrderDao.getMaxOid());
        i++;
        } catch (java.lang.NumberFormatException e){
            i = 111111;

        }
        order.setOid(String.valueOf(i));
       double count = 0.0;
       int counts = 0;
        for (CarOderItem carCarOderItem : cart.getCar().values()) {
            double price = Double.parseDouble(carCarOderItem.getBook().getPrice());
            int number = carCarOderItem.getNumber();
            sum = number * price;
            count = count+sum;
            try{
                if (counts == 0){
                i = Integer.parseInt(OrderDao.getMaxIid());
                i++;
                counts++;
                }else{
                    i++;
                    counts++;
                }
            }catch (java.lang.NumberFormatException e){
                i = 111111;
                counts++;
            }
            OrderItem orderItem = new OrderItem( String.valueOf(i), String.valueOf(number),String.valueOf(sum),order.getOid(),carCarOderItem.getBook().getBid());
            order.getOrderItem().put(carCarOderItem.getBook().getBid(),orderItem);
        }
        order.setPrice(count);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        order.setOrdertime(dateFormat.format(new Date()));
        return order;
    }


    public static void saveOrder(Order order) throws SQLException {
        OrderDao.saveOrder(order);
    }

    public static List<Order> getOrders(String uid) throws SQLException {
        List<Order> orderByUid = OrderDao.findOrderByUid(uid);
        for (Order order : orderByUid) {
            Map<String, OrderItem> orderItemByOid = OrderDao.findOrderItemByOid(order.getOid());
            order.setOderItem(orderItemByOid);
        }
        return orderByUid;
    }

    public static List<String> getOrderBid(List<Order> myOrders) {
        List<String> bids = new ArrayList<>();
        for (Order myOrder : myOrders) {
            for (OrderItem orderItem : myOrder.getOrderItem().values()) {
                String bid = orderItem.getBid();
                bids.add(bid);
            }
        }
        return bids;
    }

    public static String queryState(String oid) throws SQLException ,OrderException{
       int state = OrderDao.getStateByOid(oid);
       if (state != 2){
           throw new OrderStateException();
       }
       OrderDao.updateState(oid,3);
        return "确认收货成功，谢谢您的惠顾！";
    }

    public static Order getOrderByOid(String oid) throws SQLException {
       Order order  = OrderDao.findOrderByOid(oid);
        Map<String, OrderItem> orderItemByOid = OrderDao.findOrderItemByOid(oid);
        order.setOderItem(orderItemByOid);
        return order;
    }

    public static List<String> getOrderBid(Order order) {
        List<String> bids = new ArrayList<>();
        for (OrderItem orderItem : order.getOrderItem().values()) {
            String bid = orderItem.getBid();
            bids.add(bid);
        }
        return bids;
    }
}
