package com.tallentview.contest.model;

import java.util.UUID;

public class PaymentBean {
	
	private String transaction_id;
	private String order_id;
	private String payment_id;
	private long user_id;
	private long contest_id;
	private String time;
	private String status;
	private double amount;
	
	public PaymentBean() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentBean(String transaction_id, String order_id, String payment_id, long user_id, long contest_id,
			String time, String status, double amount) {
		super();
		this.transaction_id = transaction_id;
		this.order_id = order_id;
		this.payment_id = payment_id;
		this.user_id = user_id;
		this.contest_id = contest_id;
		this.time = time;
		this.status = status;
		this.amount = amount;
	}



	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public long getContest_id() {
		return contest_id;
	}

	public void setContest_id(long contest_id) {
		this.contest_id = contest_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	
}
