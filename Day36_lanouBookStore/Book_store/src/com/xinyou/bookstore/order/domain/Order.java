package com.xinyou.bookstore.order.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String oid = "false";
    private String ordertime = "false";
    private double price = 0.0;
    private String status = "0";
    private String uid = "false";
    private String address ="false";
    private Map<String,OrderItem> orderItem = new HashMap<>();

    public Order() {
    }

    public Order(String oid, String ordertime, double price, String status, String uid, String address, Map<String, OrderItem> oderItem) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.price = price;
        this.status = status;
        this.uid = uid;
        this.address = address;
        this.orderItem = oderItem;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String,OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOderItem(Map<String, OrderItem> oderItem) {
        this.orderItem = oderItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                ", oderItem=" + orderItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (Double.compare(order.getPrice(), getPrice()) != 0) return false;
        if (getOid() != null ? !getOid().equals(order.getOid()) : order.getOid() != null) return false;
        if (getOrdertime() != null ? !getOrdertime().equals(order.getOrdertime()) : order.getOrdertime() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) return false;
        if (getUid() != null ? !getUid().equals(order.getUid()) : order.getUid() != null) return false;
        if (getAddress() != null ? !getAddress().equals(order.getAddress()) : order.getAddress() != null) return false;
        return getOrderItem() != null ? getOrderItem().equals(order.getOrderItem()) : order.getOrderItem() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getOid() != null ? getOid().hashCode() : 0;
        result = 31 * result + (getOrdertime() != null ? getOrdertime().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getOrderItem() != null ? getOrderItem().hashCode() : 0);
        return result;
    }
}
