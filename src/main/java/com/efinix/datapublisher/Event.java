package com.efinix.datapublisher;

import java.util.HashMap;

/**
 * Created by pubudu on 6/22/16.
 */
public class Event {
    private HashMap<String, String> metaData;
    private HashMap<String, Double> correlationData;
    private StockQuote payloadData;

    public HashMap<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(HashMap<String, String> metaData) {
        this.metaData = metaData;
    }

    public HashMap<String, Double> getCorrelationData() {
        return correlationData;
    }

    public void setCorrelationData(HashMap<String, Double> correlationData) {
        this.correlationData = correlationData;
    }

    public StockQuote getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(StockQuote payloadData) {
        this.payloadData = payloadData;
    }
}
