package com.efinix.datapublisher;

/**
 * Created by dilip on 23/06/16.
 */
public class Stock {
    private String Symbol;
    private double Price;

    public Stock(String symbol, double price) {
        Symbol = symbol;
        Price = price;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
