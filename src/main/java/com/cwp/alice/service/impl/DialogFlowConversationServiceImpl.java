/**
 * 
 */
package com.cwp.alice.service.impl;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwp.alice.dao.CaseWorkerPortalDAO;
import com.cwp.alice.form.CaseCreationForm;
import com.cwp.alice.form.CaseDescriptionForm;
import com.cwp.alice.model.CaseStatus;
import com.cwp.alice.model.CwAppointments;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;
import com.cwp.alice.service.CaseWorkerPortalService;
import com.cwp.alice.service.DialogFlowConversationService;
import com.cwp.alice.util.DateUtil;

/**
 * @author lugupta
 *
 */
@Service
public class DialogFlowConversationServiceImpl implements DialogFlowConversationService {

	@Autowired
	CaseWorkerPortalService cwpServices;

	@Autowired
	CaseWorkerPortalDAO cwpDAO;

	@Override
	public List<CwAppointments> getCwAppointments(String cwId) throws Exception {
		List<CwAppointments> cwAppointmentsList = cwpDAO.getCwAppointments(Integer.valueOf(cwId));
		String todayDate = DateUtil.getDateInMMDDYYYYString(new Date());
		System.out.println("Appointment todayDate" + todayDate);
		List<CwAppointments> filteredAppointments = new ArrayList<>();
		for (CwAppointments obj : cwAppointmentsList) {
			LocalTime lt = LocalTime.parse(obj.getTime());
			System.out.println("Appointment LocalTime" + lt);
			System.out.println("Appointment cwAppointmentsList" + cwAppointmentsList);
			if (!obj.getDate().equalsIgnoreCase(todayDate) || !lt.isAfter(LocalTime.now(ZoneId.of("Asia/Kolkata")))) {
				filteredAppointments.add(obj);
			}
		}
		System.out.println("Appointment filteredAppointments" + filteredAppointments);
		cwAppointmentsList.removeAll(filteredAppointments);
		System.out.println("Appointment FINAL cwAppointmentsList" + cwAppointmentsList);
		return cwAppointmentsList;
	}

	@Override
	public CwCases getCaseByCaseId(String caseId) throws Exception {
		return cwpDAO.getCaseByCaseId(Integer.valueOf(caseId));
	}

	@Override
	public String createNewCase(CwUsers cwUsers, String hohName, String noOfAdults, String noOfChildren,
			String monthlyIncome) throws Exception {
		CaseCreationForm ccForm = new CaseCreationForm();

		ccForm.setCwId(cwUsers.getCwId());
		ccForm.setAssignedCwName(cwUsers.getName());
		ccForm.setCreateDate(DateUtil.getDateInMMDDYYYYString(new Date()));
		ccForm.setStatus("Pending Review");

		CaseDescriptionForm cdForm = new CaseDescriptionForm();
		cdForm.setHoh(hohName);
		cdForm.setAdultCnt(noOfAdults);
		cdForm.setChildrenCnt(noOfChildren);
		cdForm.setMonthlyIncome(monthlyIncome);
		ccForm.setDescForm(cdForm);

		String benefitAmount = cwpServices.saveNewCase(ccForm);
		String benefitAmountLong = benefitAmount.replace('$', '0');

		if (Long.valueOf(benefitAmountLong) <= 0L) {
			benefitAmount = "Not Eligible for TANF Assistance";
		}

		String responseOut = "Your case is created successfully. The monthly total assistance eligibility for this case is: "
				+ benefitAmount;

		return responseOut;
	}

	@Override
	public String updateAccountDetails(CwUsers cwUsers, String updateFieldType, String updatedFieldValue)
			throws Exception {
		String responseOut = "I did not find any such field to perform the update";
		String[] fieldTypeArray = new String[] { "worker id", "name", "email", "role", "designation", "department" };

		for (String temp : fieldTypeArray) {
			if (updateFieldType.toLowerCase().contains(temp)) {
				if (temp.equals("worker id")) {
					responseOut = "Case worker id can not be updated";
				} else {
					switch (temp) {
					case "name":
						cwUsers.setName(updatedFieldValue);
						break;
					case "email":
						cwUsers.setEmail(updatedFieldValue);
						break;
					case "role":
						cwUsers.setRole(updatedFieldValue);
						break;
					case "designation":
						cwUsers.setDesignation(updatedFieldValue);
						break;
					case "department":
						cwUsers.setDepartment(updatedFieldValue);
						break;
					}

					responseOut = "Your " + temp + " is updated successfully";
					cwpServices.updateAccountDetails(cwUsers);
				}
			}
		}

		return responseOut;
	}

	@Override
	public String updateCaseStatus(CwCases cwCase, String updatedStatus) throws Exception {
		String responseOut = "I was unable to find the case to update the status. Please contact Administrator.";
		System.out.println("Case Status is: "+cwCase.getStatus());
		System.out.println("Check for :"+CaseStatus.PENDING_REVIEW.value());

		if (null != cwCase && null != cwCase.getStatus()) {
			if (cwCase.getStatus().equalsIgnoreCase(CaseStatus.PENDING_REVIEW.value())) {
				cwCase.setStatus(updatedStatus);
				responseOut = "The status of the case is changed to " + updatedStatus;
			} else if (cwCase.getStatus().equalsIgnoreCase(CaseStatus.APPROVED.value())
					|| cwCase.getStatus().equalsIgnoreCase(CaseStatus.DENIED.value())) {
				responseOut = "The status of the case is already " + cwCase.getStatus()
						+ " . Case with status as Pending for Review can only be changed.";
			}
		}

		cwpServices.updateCase(cwCase);

		return responseOut;
	}
}