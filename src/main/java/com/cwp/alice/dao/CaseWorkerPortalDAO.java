/**
 * 
 */
package com.cwp.alice.dao;

import java.util.List;

import com.cwp.alice.exception.GlobalException;
import com.cwp.alice.model.CwAppointments;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
public interface CaseWorkerPortalDAO {

	CwUsers findCaseWorkerById(Integer cwId) throws GlobalException;

	List<CwCases> getAllCases() throws GlobalException;

	CwCases getCaseByCaseId(Integer caseId) throws GlobalException;

	void saveCase(CwCases cwCase) throws GlobalException;

	List<CwAppointments> getCwAppointments(Integer cwId) throws GlobalException;

	void updateUser(CwUsers cwUsers) throws GlobalException;
	
	void updateCase(CwCases cwCase) throws GlobalException;
}
