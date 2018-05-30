/**
 * 
 */
package com.cwp.alice.service;

import java.util.List;

import com.cwp.alice.model.CwAppointments;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
public interface DialogFlowConversationService {

	List<CwAppointments> getCwAppointments(String cwId) throws Exception;

	CwCases getCaseByCaseId(String caseId) throws Exception;

	String createNewCase(CwUsers cwUsers, String hohName, String noOfAdults, String noOfChildren, String monthlyIncome)
			throws Exception;

	String updateAccountDetails(CwUsers cwUsers, String updateFieldType, String updatedFieldValue) throws Exception;
	
	String updateCaseStatus(CwCases cwCase, String updatedStatus) throws Exception;
}
