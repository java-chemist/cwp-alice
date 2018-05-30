package com.cwp.alice.rs.request.dto;

public class Parameters2 {
	private String user_id;
	private String cw_pwd;
	private String case_id;
	private String new_status;
	private String pa_name;
	private String adult_count;
	private String children_count;
	private String monthly_income; 
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCw_pwd() {
		return cw_pwd;
	}
	public void setCw_pwd(String cw_pwd) {
		this.cw_pwd = cw_pwd;
	}
	public String getCase_id() {
		return case_id;
	}
	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}
	public String getPa_name() {
		return pa_name;
	}
	public void setPa_name(String pa_name) {
		this.pa_name = pa_name;
	}
	public String getAdult_count() {
		return adult_count;
	}
	public void setAdult_count(String adult_count) {
		this.adult_count = adult_count;
	}
	public String getChildren_count() {
		return children_count;
	}
	public void setChildren_count(String children_count) {
		this.children_count = children_count;
	}
	public String getMonthly_income() {
		return monthly_income;
	}
	public void setMonthly_income(String monthly_income) {
		this.monthly_income = monthly_income;
	}
	public String getNew_status() {
		return new_status;
	}
	public void setNew_status(String new_status) {
		this.new_status = new_status;
	}
}
