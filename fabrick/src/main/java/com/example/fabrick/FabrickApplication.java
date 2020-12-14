package com.example.fabrick;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.fabrick.bean.Account;
import com.example.fabrick.bean.Creditor;
import com.example.fabrick.bean.LegalPersonBeneficiary;
import com.example.fabrick.bean.MoneyTransferRequest;
import com.example.fabrick.bean.NaturalPersonBeneficiary;
import com.example.fabrick.bean.TaxRelief;
import com.example.fabrick.client.GetClient;
import com.example.fabrick.client.PostClient;
import com.example.fabrick.utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FabrickApplication {

	private static SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
	
	public static void main(String[] args) {
		SpringApplication.run(FabrickApplication.class, args);
	}

	public static String sendMoney() throws IOException, ParseException {
		String url = Constants.BASE_URL.concat(String.format(Constants.MONEY_TRANSFER, Constants.ACCOUNT_ID));
		String jsonRequest = new ObjectMapper().writeValueAsString(getSampleRequest());
		Map<String, String> headers = new HashMap<String,String>();
		headers.putAll(Constants.defaultHeaders);
		headers.put("X-Time-Zone", "Europe/Rome");
		return PostClient.sendPOST(url, headers, jsonRequest);
	}
	
	public static String getTransactions() throws ClientProtocolException, IOException {
		String url = Constants.BASE_URL.concat(String.format(Constants.TRANSACTIONS, Constants.ACCOUNT_ID));
		return GetClient.getCall(url, Constants.defaultHeaders);
	}

	public static String getBalance() throws ClientProtocolException, IOException {
		String url = Constants.BASE_URL.concat(String.format(Constants.BALANCE, Constants.ACCOUNT_ID));
		return GetClient.getCall(url, Constants.defaultHeaders);
	}

	public static String getCashAccount() throws ClientProtocolException, IOException {
		String url = Constants.BASE_URL.concat(String.format(Constants.GET_CASH_ACCOUNT, Constants.ACCOUNT_ID));
		return GetClient.getCall(url, Constants.defaultHeaders);
	}

	private static MoneyTransferRequest getSampleRequest() throws ParseException {
		MoneyTransferRequest request = new MoneyTransferRequest();
		
		Creditor creditor = new Creditor();
		creditor.setName("john Doe");
		Account account = new Account();
		account.setAccountCode("IT23A0336844430152923804660");
		account.setBicCode("SELBIT2BXXX");
		creditor.setAccount(account);
		request.setCreditor(creditor);
		
		request.setExecutionDate(sdf.parse("2019-12-11"));
		request.setUri("REMITTANCE_INFORMATION");
		request.setDescription("Payment invoice 75/2017");
		request.setAmount(800);
		request.setCurrency("EUR");
		request.setUrgent(false);
		request.setInstant(false);
		request.setFeeType("SHA");
		
		TaxRelief taxRelief = new TaxRelief();
		taxRelief.setTaxReliefId("L449");
		taxRelief.setCondoUpgrade(false);
		taxRelief.setCreditorFiscalCode("56258745832");
		NaturalPersonBeneficiary naturalPersonBeneficiary = new NaturalPersonBeneficiary();
		naturalPersonBeneficiary.setFiscalCode1("MRLFNC81L04A859L");
		taxRelief.setNaturalPersonBeneficiary(naturalPersonBeneficiary);
		LegalPersonBeneficiary legalPersonBeneficiary = new LegalPersonBeneficiary();
		taxRelief.setLegalPersonBeneficiary(legalPersonBeneficiary);
		request.setTaxRelief(taxRelief);		
		
		return request;
	}
}
