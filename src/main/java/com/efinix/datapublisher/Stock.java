package com.efinix.datapublisher;

/**
 * Created by dilip on 23/06/16.
 */
public class Stock {
    private double price;

    public Stock(double price){
        this.price = price;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
