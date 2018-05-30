/**
 * 
 */
package com.cwp.alice.form;

/**
 * @author lugupta
 *
 */
public class CaseDescriptionForm {

	private String pt;
	private String hoh;
	private String adultCnt;
	private String childrenCnt;
	private String monthlyIncome;
	private String assistanceElig;

	public String getPt() {
		return pt;
	}

	public void setPt(String pt) {
		this.pt = pt;
	}

	public String getHoh() {
		return hoh;
	}

	public void setHoh(String hoh) {
		this.hoh = hoh;
	}

	public String getAdultCnt() {
		return adultCnt;
	}

	public void setAdultCnt(String adultCnt) {
		this.adultCnt = adultCnt;
	}

	public String getChildrenCnt() {
		return childrenCnt;
	}

	public void setChildrenCnt(String childrenCnt) {
		this.childrenCnt = childrenCnt;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getAssistanceElig() {
		return assistanceElig;
	}

	public void setAssistanceElig(String assistanceElig) {
		this.assistanceElig = assistanceElig;
	}

	@Override
	public String toString() {
		return "Program Type = " + pt + " || Head of Household = " + hoh + " || No of Adults = " + adultCnt
				+ " || No of Children = " + childrenCnt + " || Family Monthly Income = " + monthlyIncome
				+ " || Eligilble Assistance Amount = " + assistanceElig + "";
	}

}
