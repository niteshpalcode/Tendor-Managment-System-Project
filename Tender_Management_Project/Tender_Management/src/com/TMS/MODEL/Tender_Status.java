package com.TMS.MODEL;

public class Tender_Status {
	private int t_id;
	private int b_id;
	private int v_id;
	private String status;
	public Tender_Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tender_Status(int t_id, int b_id, int v_id, String status) {
		super();
		this.t_id = t_id;
		this.b_id = b_id;
		this.v_id = v_id;
		this.status = status;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Tender_Status [t_id=" + t_id + ", b_id=" + b_id + ", v_id=" + v_id + ", status=" + status + "]";
	}
	
}
