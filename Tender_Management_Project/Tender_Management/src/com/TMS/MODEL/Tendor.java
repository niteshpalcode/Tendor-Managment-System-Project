package com.TMS.MODEL;

public class Tendor {
	private int t_id;
	private String t_name;
	private String t_type;
	private String t_cost;
	private String t_desc;
	private String t_deadline;
	private String t_lock;
	public Tendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_type() {
		return t_type;
	}
	public void setT_type(String t_type) {
		this.t_type = t_type;
	}
	public String getT_cost() {
		return t_cost;
	}
	public void setT_cost(String t_cost) {
		this.t_cost = t_cost;
	}
	public String getT_desc() {
		return t_desc;
	}
	public void setT_desc(String t_desc) {
		this.t_desc = t_desc;
	}
	public String getT_deadline() {
		return t_deadline;
	}
	public void setT_deadline(String t_deadline) {
		this.t_deadline = t_deadline;
	}
	public String getT_lock() {
		return t_lock;
	}
	public void setT_lock(String t_lock) {
		this.t_lock = t_lock;
	}
	public Tendor(int t_id, String t_name, String t_type, String t_cost, String t_desc, String t_deadline,
			String t_lock) {
		super();
		this.t_id = t_id;
		this.t_name = t_name;
		this.t_type = t_type;
		this.t_cost = t_cost;
		this.t_desc = t_desc;
		this.t_deadline = t_deadline;
		this.t_lock = t_lock;
	}
	@Override
	public String toString() {
		return "Tendor [t_id=" + t_id + ", t_name=" + t_name + ", t_type=" + t_type + ", t_cost=" + t_cost + ", t_desc="
				+ t_desc + ", t_deadline=" + t_deadline + ", t_lock=" + t_lock + "]";
	}
	
	
}
