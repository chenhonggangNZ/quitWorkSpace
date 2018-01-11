package com.xinyou.bookstore.order.domain;

public class OrderItem {
    private String iid;
    private String count;
    private String subtotal;
    private String oid;
    private String bid;

    public OrderItem() {
    }

    public OrderItem(String iid, String count, String subtotal, String oid, String bid) {
        this.iid = iid;
        this.count = count;
        this.subtotal = subtotal;
        this.oid = oid;
        this.bid = bid;
    }

    public String getIid() {
        return iid;
    }

    public void setIid(String iid) {
        this.iid = iid;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "iid='" + iid + '\'' +
                ", count='" + count + '\'' +
                ", subtotal='" + subtotal + '\'' +
                ", oid='" + oid + '\'' +
                ", bid='" + bid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getIid() != null ? !getIid().equals(orderItem.getIid()) : orderItem.getIid() != null) return false;
        if (getCount() != null ? !getCount().equals(orderItem.getCount()) : orderItem.getCount() != null) return false;
        if (getSubtotal() != null ? !getSubtotal().equals(orderItem.getSubtotal()) : orderItem.getSubtotal() != null)
            return false;
        if (getOid() != null ? !getOid().equals(orderItem.getOid()) : orderItem.getOid() != null) return false;
        return getBid() != null ? getBid().equals(orderItem.getBid()) : orderItem.getBid() == null;
    }

    @Override
    public int hashCode() {
        int result = getIid() != null ? getIid().hashCode() : 0;
        result = 31 * result + (getCount() != null ? getCount().hashCode() : 0);
        result = 31 * result + (getSubtotal() != null ? getSubtotal().hashCode() : 0);
        result = 31 * result + (getOid() != null ? getOid().hashCode() : 0);
        result = 31 * result + (getBid() != null ? getBid().hashCode() : 0);
        return result;
    }
}
