package com.example.fabrick.client;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetClient {

	public static String getCall(String url, Map<String, String> headers) throws ClientProtocolException, IOException {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet(url);

			// add request headers
			for (Entry<String, String> header : headers.entrySet()) {
				request.addHeader(header.getKey(), header.getValue());
			}

			CloseableHttpResponse response = httpClient.execute(request);

			try {

				// Get HttpResponse Status
				System.out.println(response.getProtocolVersion()); // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode()); // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					result = EntityUtils.toString(entity);
					System.out.println(result);
				}

			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}
		return result;
	}
	
}
