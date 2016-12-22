package com.efinix.datapublisher;

/**
 * Created by dilip on 22/12/16.
 */
public class Portfolio {

    private int PortfolioID;
    private String Symbol;
    private int Shares;

    public Portfolio(int portfolioID, String symbol, int shares) {
        PortfolioID = portfolioID;
        Symbol = symbol;
        Shares = shares;
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

}
