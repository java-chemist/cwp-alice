/**
 * 
 */
package com.cwp.alice.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwp.alice.dao.CaseWorkerPortalDAO;
import com.cwp.alice.exception.GlobalException;
import com.cwp.alice.form.CaseCreationForm;
import com.cwp.alice.form.CaseDescriptionForm;
import com.cwp.alice.model.CwAppointments;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;
import com.cwp.alice.service.CaseWorkerPortalService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * @author lugupta
 *
 */
@Service
public class CaseWorkerPortalServiceImpl implements CaseWorkerPortalService {

	@Autowired
	CaseWorkerPortalDAO cwpDAO;

	@Override
	public String findCaseWorkerNameById(String cwId) throws GlobalException {
		return cwpDAO.findCaseWorkerById(Integer.valueOf(cwId)).getName();
	}

	@Override
	public String getAllCases() throws GlobalException, JsonParseException, JsonMappingException, IOException {
		List<CwCases> cwList = new ArrayList<>();

		for (CwCases obj : cwpDAO.getAllCases()) {
			String jsonDesc = obj.getDesc();
			ObjectMapper mapper = new ObjectMapper();
			CaseDescriptionForm cdf = mapper.readValue(jsonDesc, CaseDescriptionForm.class);
			obj.setDesc(cdf.toString());
			cwList.add(obj);
		}

		return new Gson().toJson(cwList);
	}

	@Override
	public CwCases getCaseByCaseId(String caseId) throws GlobalException {
		return cwpDAO.getCaseByCaseId(Integer.valueOf(caseId));
	}

	@Override
	public CaseCreationForm processCwCase(CwCases cwCases) throws GlobalException, Exception {
		CaseCreationForm ccForm = new CaseCreationForm();

		ccForm.setCaseId(cwCases.getId());
		ccForm.setCwId(cwCases.getCwId());
		ccForm.setCreateDate(cwCases.getDate());
		ObjectMapper mapper = new ObjectMapper();
		CaseDescriptionForm cdf = mapper.readValue(cwCases.getDesc(), CaseDescriptionForm.class);
		cdf.setPt("TANF (Temporary Assistance for Needy Families)");
		ccForm.setDescForm(cdf);
		ccForm.setStatus(cwCases.getStatus());
		ccForm.setAssignedCwName(cwCases.getAssignedCwName());

		return ccForm;
	}

	@Override
	public String saveNewCase(CaseCreationForm ccForm) throws GlobalException {
		CwCases cwCases = new CwCases();
		cwCases.setCwId(ccForm.getCwId());
		cwCases.setDate(ccForm.getCreateDate());
		cwCases.setStatus(ccForm.getStatus());
		cwCases.setAssignedCwName(ccForm.getAssignedCwName());

		CaseDescriptionForm cdForm = ccForm.getDescForm();
		cdForm.setPt("TANF");
		if (calculateEligibleAssistance(cdForm) <= 0L) {
			cwCases.setStatus("Denied");
		}
		cdForm.setAssistanceElig("$" + this.calculateEligibleAssistance(cdForm).toString());
		cdForm.setMonthlyIncome("$" + cdForm.getMonthlyIncome());
		cwCases.setDesc(new Gson().toJson(cdForm));

		cwpDAO.saveCase(cwCases);
		return cdForm.getAssistanceElig();
	}

	private Long calculateEligibleAssistance(CaseDescriptionForm cdForm) {
		Long totalBenefits = (Long.valueOf(cdForm.getAdultCnt()) * 50) + (Long.valueOf(cdForm.getChildrenCnt()) * 75);
		Long eligibleBenefits = 0L;
		Long monthlyIncome = Long.valueOf(cdForm.getMonthlyIncome().replaceAll("$", ""));

		if (totalBenefits > monthlyIncome) {
			eligibleBenefits = totalBenefits - monthlyIncome;
		}

		return eligibleBenefits;
	}

	@Override
	public String getCwAppointments(String cwId) throws GlobalException {
		List<CwAppointments> cwAppointmentsList = cwpDAO.getCwAppointments(Integer.valueOf(cwId));

		return new Gson().toJson(cwAppointmentsList);
	}

	@Override
	public CwUsers findCaseWorkerById(Integer cwId) throws GlobalException {
		return cwpDAO.findCaseWorkerById(cwId);
	}

	@Override
	public void updateAccountDetails(CwUsers cwUsers) throws GlobalException {
		cwpDAO.updateUser(cwUsers);
	}
	
	@Override
	public void updateCase(CwCases cwCase) throws GlobalException {
		cwpDAO.updateCase(cwCase);
	}
}
