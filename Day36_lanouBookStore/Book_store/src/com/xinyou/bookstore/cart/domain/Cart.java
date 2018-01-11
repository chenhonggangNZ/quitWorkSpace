package com.xinyou.bookstore.cart.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    private Map<String,CarOderItem> car = new HashMap<>();

    public Cart(Map<String, CarOderItem> car) {
        this.car = car;
    }

    public Cart() {
    }

    public Map<String, CarOderItem> getCar() {
        return car;
    }

    public void setCar(Map<String, CarOderItem> car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "car=" + car +
                '}';
    }

    public void clear() {
        this.car = new HashMap<>();
    }
    public void delete(String bid){
        Iterator<String> iterator = this.car.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (bid.equals(next)){
                iterator.remove();
                car.remove(next);
            }
        }
    }
}
