package com.example.fabrick.client;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostClient {

    public static String sendPOST(String url, Map<String,String> headers, String jsonEntity) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);
       
		for (Entry<String, String> header : headers.entrySet()) {
			post.addHeader(header.getKey(), header.getValue());
		}

        // send a JSON data
        post.setEntity(new StringEntity(jsonEntity));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

		System.out.println(result);
        return result;

    }
    
}
