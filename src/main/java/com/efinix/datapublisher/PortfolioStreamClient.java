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
public class PortfolioStreamClient extends Thread {

    HttpClient httpClient = new SystemDefaultHttpClient();
    HttpPost portfolioMethod = new HttpPost("http://localhost:9763/endpoints/portfolioStream");
    HttpPost stockMethod = new HttpPost("http://localhost:9763/endpoints/stockStream");
    ArrayList<PortfolioFile> portfolios;

    PortfolioStreamClient(ArrayList<PortfolioFile> portfolios){
        this.portfolios = portfolios;
    }

    @Override
    public void run() {
        for (int i = 0; i < portfolios.size() ; i++) {
            PortfolioFile portfolio = portfolios.get(i);

            Gson gson = new Gson();
            PortfolioEvent event = new PortfolioEvent();
            HashMap<String, String> metaData = new HashMap();
            metaData.put("timestamp", "" + System.currentTimeMillis());
            HashMap<String, Double> correlationData = new HashMap();
            PortfolioEventWrapper wrapper = new PortfolioEventWrapper();
            event.setMetaData(metaData);
            event.setCorrelationData(correlationData);
            event.setPayloadData(new Portfolio(portfolio.getPortfolioID(),portfolio.getSymbol(),portfolio.getShares()));
            wrapper.setEvent(event);

            String eventJson = gson.toJson(wrapper);
            StringEntity entity;
            try {
                entity = new StringEntity(eventJson);
                portfolioMethod.setEntity(entity);
                httpClient.execute(portfolioMethod).getEntity().getContent().close();
                sendStockEvent(new Stock(portfolio.getSymbol(),portfolio.getPrice()));
                sleep(100);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void sendStockEvent(Stock stock) {
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
            stockMethod.setEntity(entity);
            httpClient.execute(stockMethod).getEntity().getContent().close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
