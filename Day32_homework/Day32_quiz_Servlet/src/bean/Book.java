package bean;

public class Book {
    private String bookname;
    private String writer;
    private double price;
    public Book(){

    }
    public Book(String bookname,String writer,double price){
        this.bookname = bookname;
        this.writer = writer;
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookname='" + bookname + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }
}
