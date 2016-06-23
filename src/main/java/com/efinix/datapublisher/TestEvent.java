package com.efinix.datapublisher;

import java.util.HashMap;

/**
 * Created by dilip on 23/06/16.
 */
public class TestEvent {
    private HashMap<String, String> metaData;
    private HashMap<String, Double> correlationData;
    private Stock payloadData;

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

    public Stock getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(Stock payloadData) {
        this.payloadData = payloadData;
    }
}
