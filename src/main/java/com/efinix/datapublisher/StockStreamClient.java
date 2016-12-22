package com.efinix.datapublisher;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.SystemDefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dilip on 22/12/16.
 */
public class StockStreamClient extends Thread {

    HttpClient httpClient = new SystemDefaultHttpClient();
    HttpPost method = new HttpPost("http://localhost:9763/endpoints/stockStream");
    ArrayList<Stock> stocks;

    StockStreamClient(ArrayList<Stock> stocks){
        this.stocks = stocks;
    }

    @Override
    public void run() {
        for (int i = 0; i < stocks.size() ; i++) {
            Stock stock = stocks.get(i);;
            Gson gson = new Gson();
            StockEvent event = new StockEvent();
            HashMap<String, String> metaData = new HashMap();
            metaData.put("timestamp", "" + System.currentTimeMillis());
            HashMap<String, Double> correlationData = new HashMap();
            StockEventWrapper wrapper = new StockEventWrapper();
            event.setMetaData(metaData);
            event.setCorrelationData(correlationData);
            event.setPayloadData(stock);
            wrapper.setEvent(event);

            String eventJson = gson.toJson(wrapper);
            StringEntity entity;
            try {
                entity = new StringEntity(eventJson);
                method.setEntity(entity);
                httpClient.execute(method).getEntity().getContent().close();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
