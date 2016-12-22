package com.efinix.datapublisher;

import java.util.HashMap;

/**
 * Created by dilip on 22/12/16.
 */
public class PortfolioEvent {
    private HashMap<String, String> metaData;
    private HashMap<String, Double> correlationData;
    private Portfolio payloadData;

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

    public Portfolio getPayloadData() {
        return payloadData;
    }

    public void setPayloadData(Portfolio payloadData) {
        this.payloadData = payloadData;
    }
}
