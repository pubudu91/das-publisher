package com.efinix.datapublisher;

/**
 * Created by dilip on 22/12/16.
 */
public class PortfolioFile {
    private int PortfolioID;
    private String Symbol;
    private int Shares;
    private double Price;

    public PortfolioFile(int portfolioID, String symbol, int shares, double price) {
        PortfolioID = portfolioID;
        Symbol = symbol;
        Shares = shares;
        Price = price;
    }

    public int getPortfolioID() {
        return PortfolioID;
    }

    public void setPortfolioID(int portfolioID) {
        PortfolioID = portfolioID;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getShares() {
        return Shares;
    }

    public void setShares(int shares) {
        Shares = shares;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
