/**
 * 
 */
package com.cwp.alice.form;

/**
 * @author lugupta
 *
 */
public class CaseCreationForm {

	Integer caseId;
	Integer cwId;
	String createDate;
	CaseDescriptionForm descForm;
	String status;
	String assignedCwName;

	public Integer getCaseId() {
		return caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	public Integer getCwId() {
		return cwId;
	}

	public void setCwId(Integer cwId) {
		this.cwId = cwId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public CaseDescriptionForm getDescForm() {
		return descForm;
	}

	public void setDescForm(CaseDescriptionForm descForm) {
		this.descForm = descForm;
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

}
