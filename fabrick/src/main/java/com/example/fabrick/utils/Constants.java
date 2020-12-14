package com.example.fabrick.utils;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final String BASE_URL = "https://sandbox.platfr.io";
	public static final String GET_CASH_ACCOUNT = "/api/gbs/banking/v4.0/accounts/%s";
	public static final String ACCOUNT_ID = "14537780";
	public static final String BALANCE = "/api/gbs/banking/v4.0/accounts/%s/balance";
	public static final String TRANSACTIONS = "/api/gbs/banking/v4.0/accounts/%s/transactions?fromAccountingDate=2018-04-01&toAccountingDate=2020-12-01";
	public static final String MONEY_TRANSFER = "/api/gbs/banking/v4.0/accounts/%s/payments/money-transfers";
	public static final String DATE_FORMAT = "yyyy-MM-dd";


	public static Map<String, String> defaultHeaders = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put("Auth-Schema", "S2S");
			put("Api-Key", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		}
	};
	
}
