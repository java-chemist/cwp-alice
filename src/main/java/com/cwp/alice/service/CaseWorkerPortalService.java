/**
 * 
 */
package com.cwp.alice.service;

import com.cwp.alice.exception.GlobalException;
import com.cwp.alice.form.CaseCreationForm;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
public interface CaseWorkerPortalService {

	String getAllCases() throws GlobalException, Exception;

	String findCaseWorkerNameById(String cwId) throws GlobalException;

	CwCases getCaseByCaseId(String caseId) throws GlobalException;

	CaseCreationForm processCwCase(CwCases cwCases) throws GlobalException, Exception;

	String saveNewCase(CaseCreationForm ccForm) throws GlobalException;

	String getCwAppointments(String cwId) throws GlobalException;

	CwUsers findCaseWorkerById(Integer cwId) throws GlobalException;

	void updateAccountDetails(CwUsers cwUsers) throws GlobalException;
	
	void updateCase(CwCases cwCase) throws GlobalException;
}
