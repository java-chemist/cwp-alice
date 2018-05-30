/**
 * 
 */
package com.cwp.alice.model;

/**
 * @author lugupta
 *
 */
public class CwUsers {

	private Integer id;
	private String name;
	private Integer cwId;
	private String password;
	private String email;
	private String role;
	private String designation;
	private String department;
	private String sessionId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCwId() {
		return cwId;
	}

	public void setCwId(Integer cwId) {
		this.cwId = cwId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "CwUsers [id=" + id + ", name=" + name + ", cwId=" + cwId + ", password=" + password + ", email=" + email
				+ ", role=" + role + ", designation=" + designation + ", department=" + department + ", sessionId="
				+ sessionId + "]";
	}

}
