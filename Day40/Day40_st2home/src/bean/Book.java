package bean;

public class Book {
    private int bid;
    private String bookname;
    private String author;
    private double price;
    private String category;

    public Book() {
    }

    public Book(int bid, String bookname, String author, double price, String category) {
        this.bid = bid;
        this.bookname = bookname;
        this.author = author;
        this.price = price;
        this.category = category;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getBid() != book.getBid()) return false;
        if (Double.compare(book.getPrice(), getPrice()) != 0) return false;
        if (getBookname() != null ? !getBookname().equals(book.getBookname()) : book.getBookname() != null)
            return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        return getCategory() != null ? getCategory().equals(book.getCategory()) : book.getCategory() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getBid();
        result = 31 * result + (getBookname() != null ? getBookname().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
        return result;
    }
}
