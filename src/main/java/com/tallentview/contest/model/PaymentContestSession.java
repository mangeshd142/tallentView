package com.tallentview.contest.model;

public class PaymentContestSession {

	private ContestInfo contestInfo;
	private String transaction_id;
	private String order_id;
	
	public PaymentContestSession(ContestInfo contestInfo, String transaction_id, String order_id) {
		super();
		this.contestInfo = contestInfo;
		this.transaction_id = transaction_id;
		this.order_id = order_id;
	}

	public ContestInfo getContestInfo() {
		return contestInfo;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public String getOrder_id() {
		return order_id;
	}
		
}
