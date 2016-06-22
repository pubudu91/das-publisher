package com.efinix.datapublisher;

/**
 * Created by pubudu on 6/22/16.
 */
public class StockQuote {
    private String Status;
    private String Name;
    private String Symbol;
    private double LastPrice;
    private double Change;
    private double ChangePercent;
    private String Timestamp;
    private double MSDate;
    private long MarketCap;
    private long Volume;
    private double ChangeYTD;
    private double ChangePercentYTD;
    private double High;
    private double Low;
    private double Open;

    public double getOpen() {
        return Open;
    }

    public void setOpen(double open) {
        this.Open = open;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        this.Symbol = symbol;
    }

    public double getLastPrice() {
        return LastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.LastPrice = lastPrice;
    }

    public double getChange() {
        return Change;
    }

    public void setChange(double change) {
        this.Change = change;
    }

    public double getChangePercent() {
        return ChangePercent;
    }

    public void setChangePercent(double changePercent) {
        this.ChangePercent = changePercent;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.Timestamp = timestamp;
    }

    public double getMsDate() {
        return MSDate;
    }

    public void setMsDate(double msDate) {
        this.MSDate = msDate;
    }

    public long getMarketCap() {
        return MarketCap;
    }

    public void setMarketCap(long marketCap) {
        this.MarketCap = marketCap;
    }

    public long getVolume() {
        return Volume;
    }

    public void setVolume(long volume) {
        this.Volume = volume;
    }

    public double getChangeYTD() {
        return ChangeYTD;
    }

    public void setChangeYTD(double changeYTD) {
        this.ChangeYTD = changeYTD;
    }

    public double getChangePercentYTD() {
        return ChangePercentYTD;
    }

    public void setChangePercentYTD(double ChangePercentYTD) {
        this.ChangePercentYTD = ChangePercentYTD;
    }

    public double getHigh() {
        return High;
    }

    public void setHigh(double High) {
        this.High = High;
    }

    public double getLow() {
        return Low;
    }

    public void setLow(double Low) {
        this.Low = Low;
    }
}
