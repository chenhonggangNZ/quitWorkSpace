package com.xinyou.bookstore.cart.domain;

import com.xinyou.bookstore.book.domain.Book;

public class CarOderItem {
    private Book book;
    private int number;

    public CarOderItem() {
    }

    public CarOderItem(Book book, int number) {
        this.book = book;
        this.number = number;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CarOderItem{" +
                "book=" + book +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarOderItem)) return false;

        CarOderItem carCarOderItem = (CarOderItem) o;

        if (number != carCarOderItem.number) return false;
        return book.equals(carCarOderItem.book);
    }

    @Override
    public int hashCode() {
        int result = book.hashCode();
        result = 31 * result + number;
        return result;
    }
}
