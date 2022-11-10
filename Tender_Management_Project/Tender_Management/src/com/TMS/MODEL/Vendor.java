package com.TMS.MODEL;

public class Vendor {
	private int v_id;
	private String v_name;
	private String v_mobile;
	private String v_email;
	private String v_company;
	private String v_address;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_mobile() {
		return v_mobile;
	}
	public void setV_mobile(String v_mobile) {
		this.v_mobile = v_mobile;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	public String getV_company() {
		return v_company;
	}
	public void setV_company(String v_company) {
		this.v_company = v_company;
	}
	public String getV_address() {
		return v_address;
	}
	public void setV_address(String v_address) {
		this.v_address = v_address;
	}
	public Vendor(int v_id, String v_name, String v_mobile, String v_email, String v_company, String v_address) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_mobile = v_mobile;
		this.v_email = v_email;
		this.v_company = v_company;
		this.v_address = v_address;
	}
	@Override
	public String toString() {
		return "Vendor [v_id=" + v_id + ", v_name=" + v_name + ", v_mobile=" + v_mobile + ", v_email=" + v_email
				+ ", v_company=" + v_company + ", v_address=" + v_address + "]";
	}

	
		
}


