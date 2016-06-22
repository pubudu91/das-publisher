package com.efinix.datapublisher;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.SystemDefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;

/**
 * Created by pubudu on 6/22/16.
 */
public class Client {
    public static void main(String[] args) {
        HttpClient httpClient = new SystemDefaultHttpClient();
        HttpPost method = new HttpPost("http://localhost:9763/endpoints/stockprice");
        HttpGet get = new HttpGet("http://dev.markitondemand.com/MODApis/Api/v2/Quote/json?symbol=GOOGL");

        try {
            InputStream stream = httpClient.execute(get).getEntity().getContent();
            StringWriter writer = new StringWriter();
            IOUtils.copy(stream, writer, "UTF-8");
            String theString = writer.toString();
            System.out.println(theString);

            Gson gson = new Gson();

            StockQuote quote = gson.fromJson(theString, StockQuote.class);
            Event event = new Event();

            System.out.println(quote.getLastPrice());
            HashMap<String, String> metaData = new HashMap<>();
            metaData.put("timestamp", "" + System.currentTimeMillis());

            HashMap<String, Double> correlationalData = new HashMap<>();

            EventWrapper wrapper = new EventWrapper();

            event.setMetaData(metaData);
            event.setCorrelationData(correlationalData);
            event.setPayloadData(quote);
            wrapper.setEvent(event);

            String eventJson = gson.toJson(wrapper);
            StringEntity entity = new StringEntity(eventJson);

            method.setEntity(entity);
            httpClient.execute(method).getEntity().getContent().close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
