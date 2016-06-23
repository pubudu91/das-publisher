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
 * Created by dilip on 6/23/16.
 */
public class TestClient {
    public static void main(String[] args) {
        HttpClient httpClient = new SystemDefaultHttpClient();
        HttpPost method = new HttpPost("http://localhost:9763/endpoints/stockprice");
        double[] input = {
                151.059998,
                151.279999,
                152.369995,
                153.419998,
                154,
                153.330002,
                152.729996,
                152.889999,
                153.5,
                152.509995,
                153.740005,
                152.839996,
                152.440002,
                151.690002,
                148.309998,
                146.770004,
                147.25,
                144.929993,
                147.339996,
                148,
                149.460007,
                147.720001,
                148.839996,
                148.949997,
                149.970001,
                147.339996,
                147.289993,
                146.470001,
                144.25,
                144.130005,
                145.270004,
                145.940002,
                147.070007,
                150.470001,
                149.080002,
                148.809998,
                148.5,
                149.300003,
                146.110001,
                144,
                152.529999,
                151.720001,
                151.160004,
                151.229996,
                149.630005,
                149.25,
                149.350006,
                148.25,
                150.020004
        };
        for (int i = 0; i < input.length; i++) {
            try {


                Gson gson = new Gson();

                TestEvent event = new TestEvent();

                HashMap<String, String> metaData = new HashMap<>();
                metaData.put("timestamp", "" + System.currentTimeMillis());

                HashMap<String, Double> correlationalData = new HashMap<>();

                TestEventWrapper wrapper = new TestEventWrapper();

                event.setMetaData(metaData);
                event.setCorrelationData(correlationalData);
                event.setPayloadData(new Stock(input[i]));
                wrapper.setEvent(event);

                String eventJson = gson.toJson(wrapper);
                StringEntity entity = new StringEntity(eventJson);

                method.setEntity(entity);
                httpClient.execute(method).getEntity().getContent().close();
                Thread.sleep(1000);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

