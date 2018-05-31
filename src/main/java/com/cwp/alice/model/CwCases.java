/**
 * 
 */
package com.cwp.alice.model;

/**
 * @author lugupta
 *
 */
public class CwCases {

	private Integer id;
	private Integer cwId;
	private String date;
	private String desc;
	private String status;
	private String assignedCwName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCwId() {
		return cwId;
	}

	public void setCwId(Integer cwId) {
		this.cwId = cwId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAssignedCwName() {
		return assignedCwName;
	}

	public void setAssignedCwName(String assignedCwName) {
		this.assignedCwName = assignedCwName;
	}

	@Override
	public String toString() {
		return "CwCases [id=" + id + ", cwId=" + cwId + ", date=" + date + ", desc=" + desc + ", status=" + status
				+ ", assignedCwName=" + assignedCwName + "]";
	}

}
