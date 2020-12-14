package com.example.fabrick;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.client.ClientProtocolException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.fabrick.response.bean.GenericResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class FabrickApplicationTests {
	ObjectMapper objectMapper = new ObjectMapper();
	static GenericResponse genericResponse = null;
	
	@BeforeAll
	static public void init() {
		genericResponse = null;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void testGetBalance() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException {
		genericResponse = objectMapper.readValue(FabrickApplication.getBalance(),GenericResponse.class);
		Assert.isTrue(genericResponse.getStatus().equals("OK"), "getBalance status ok");
	}
	
	@Test
	void testGetTransactions() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException {
		genericResponse = objectMapper.readValue(FabrickApplication.getTransactions(),GenericResponse.class);
		Assert.isTrue(genericResponse.getStatus().equals("OK"), "getTransactions status ok");
	}
	
	@Test
	void testGetCashAccount() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException {
		genericResponse = objectMapper.readValue(FabrickApplication.getCashAccount(),GenericResponse.class);
		Assert.isTrue(genericResponse.getStatus().equals("OK"), "getCashAccount status ok");
	}
	
	@Test
	void testSendMoney() throws JsonMappingException, JsonProcessingException, ClientProtocolException, IOException, ParseException {
		genericResponse = objectMapper.readValue(FabrickApplication.sendMoney(),GenericResponse.class);
		Assert.isTrue(genericResponse != null, "sendMoney raggiunta");
	}
}
