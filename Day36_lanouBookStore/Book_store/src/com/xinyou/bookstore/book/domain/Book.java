package com.xinyou.bookstore.book.domain;

public class Book {
    private String bid;
    private String bname;
    private String price;
    private String author;
    private String image;
    private String cid;
    private int delete = 0;

    public Book(String bid, String bname, String price, String author, String image, String cid,int delete) {
        this.bid = bid;
        this.bname = bname;
        this.price = price;
        this.author = author;
        this.image = image;
        this.cid = cid;
        this.delete = delete;
    }

    public Book() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", cid='" + cid + '\'' +
                ", delete=" + delete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getDelete() != book.getDelete()) return false;
        if (getBid() != null ? !getBid().equals(book.getBid()) : book.getBid() != null) return false;
        if (getBname() != null ? !getBname().equals(book.getBname()) : book.getBname() != null) return false;
        if (getPrice() != null ? !getPrice().equals(book.getPrice()) : book.getPrice() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        if (getImage() != null ? !getImage().equals(book.getImage()) : book.getImage() != null) return false;
        return getCid() != null ? getCid().equals(book.getCid()) : book.getCid() == null;
    }

    @Override
    public int hashCode() {
        int result = getBid() != null ? getBid().hashCode() : 0;
        result = 31 * result + (getBname() != null ? getBname().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getCid() != null ? getCid().hashCode() : 0);
        result = 31 * result + getDelete();
        return result;
    }
}
