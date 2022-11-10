package com.TMS.MODEL;

public class Bidder {
	private int b_id;
	private int v_id;
	private int t_id;
	private int bid_amount;
	private String status;
	public Bidder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bidder(int b_id, int v_id, int t_id, int bid_amount, String status) {
		super();
		this.b_id = b_id;
		this.v_id = v_id;
		this.t_id = t_id;
		this.bid_amount = bid_amount;
		this.status = status;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getBid_amount() {
		return bid_amount;
	}
	public void setBid_amount(int bid_amount) {
		this.bid_amount = bid_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Bidder [b_id=" + b_id + ", v_id=" + v_id + ", t_id=" + t_id + ", bid_amount=" + bid_amount + ", status="
				+ status + "]";
	}
	
	
}
