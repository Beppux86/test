package com.example.fabrick.bean;

import java.util.Date;

public class MoneyTransferRequest {
	private Creditor creditor;
	private Date executionDate;
	private String uri;
	private String description;
	private double amount;
	private String currency;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private TaxRelief taxRelief;

	public Creditor getCreditor() {
		return creditor;
	}

	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public boolean isInstant() {
		return isInstant;
	}

	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public TaxRelief getTaxRelief() {
		return taxRelief;
	}

	public void setTaxRelief(TaxRelief taxRelief) {
		this.taxRelief = taxRelief;
	}

}
