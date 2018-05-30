/**
 * 
 */
package com.cwp.alice.controller;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cwp.alice.constants.GenericConstants;
import com.cwp.alice.form.CaseCreationForm;
import com.cwp.alice.form.CaseDescriptionForm;
import com.cwp.alice.model.CwCases;
import com.cwp.alice.model.CwUsers;
import com.cwp.alice.service.CaseWorkerPortalService;
import com.cwp.alice.util.DateUtil;

/**
 * 
 * @author lugupta
 */
@Controller
public class CaseWorkerPortalController {

	private static final Logger logger = Logger.getLogger(CaseWorkerPortalController.class);
	public static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	CaseWorkerPortalService cwpServices;

	@RequestMapping(value = GenericConstants.URL_CW_DASHBOARD, method = { RequestMethod.GET })
	public String showMyDashboard(Model model, HttpSession session) {
		try {
			String casesJsonObj = cwpServices.getAllCases();

			String aliceSecretKey = null;

			if (null == session.getAttribute("aliceSecretKey")) {
				// Setting JSesssion ID to main user object
				SecureRandom secureRandom = new SecureRandom();
				byte[] token = new byte[19];
				secureRandom.nextBytes(token);
				aliceSecretKey = new BigInteger(1, token).toString(19);
				/*
				 * String sessionId = ((WebAuthenticationDetails)
				 * SecurityContextHolder.getContext().getAuthentication()
				 * .getDetails()).getSessionId();
				 */
				System.out.println("Session Id is :" + aliceSecretKey);
				// session.setAttribute("aliceSecretKey",
				// "8hbe924e4b21f2e0ie5cc3b9g3ega2a52if5");
				session.setAttribute("aliceSecretKey", aliceSecretKey);
			} else {
				aliceSecretKey = String.valueOf(session.getAttribute("aliceSecretKey"));
				System.out.println("Old Session Id is :" + aliceSecretKey);
			}

			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CwUsers cwUsers = cwpServices.findCaseWorkerById(Integer.valueOf(user.getUsername()));
			cwUsers.setSessionId(aliceSecretKey);
			cwpServices.updateAccountDetails(cwUsers);
			CwUsers cwUsersNew = cwpServices.findCaseWorkerById(Integer.valueOf(user.getUsername()));
			System.out.println("Cs users is : " + cwUsersNew.toString());
			model.addAttribute("casesJsonObj", casesJsonObj);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in loading My Dashboard page: " + e);
			logger.error("Error in loading My Dashboard page: " + e);
			model.addAttribute("message",
					"Error in loading My Dashboard page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_DASHBOARD;
	}

	@RequestMapping(value = "/openCase/{caseId}", method = RequestMethod.GET)
	public String openCase(@PathVariable String caseId, Model model, RedirectAttributes redir) {
		try {
			CwCases cwCases = cwpServices.getCaseByCaseId(caseId);
			String caseAccess = null;
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (Integer.valueOf(user.getUsername()) != cwCases.getCwId()) {
				caseAccess = "You do not have permission to open the case " + caseId
						+ ". Please reach out to case owner " + cwCases.getAssignedCwName();

				redir.addFlashAttribute("caseAccess", caseAccess);
				return "redirect:" + GenericConstants.URL_CW_DASHBOARD;
			}

			CaseCreationForm caseCreationForm = cwpServices.processCwCase(cwCases);

			model.addAttribute("disableFields", true);
			model.addAttribute("caseCreationForm", caseCreationForm);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in Case Details page: " + e);
			logger.error("Error in Case Details page: " + e);
			model.addAttribute("message", "Error in Case Details page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_CASE_CREATE;
	}

	@RequestMapping(value = GenericConstants.URL_CW_CASE_CREATE, method = RequestMethod.GET)
	public String showCaseCreation(@ModelAttribute("caseCreationForm") CaseCreationForm caseCreationForm, Model model) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			CaseDescriptionForm cdForm = new CaseDescriptionForm();

			cdForm.setPt("TANF (Temporary Assistance for Needy Families)");
			caseCreationForm.setCwId(Integer.valueOf(user.getUsername()));
			caseCreationForm
					.setAssignedCwName(cwpServices.findCaseWorkerById(Integer.valueOf(user.getUsername())).getName());
			caseCreationForm.setCreateDate(DateUtil.getDateInMMDDYYYYString(new Date()));
			caseCreationForm.setDescForm(cdForm);

			model.addAttribute("caseCreationForm", caseCreationForm);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in loading Add New Case page: " + e);
			logger.error("Error in loading Add New Case page: " + e);
			model.addAttribute("message",
					"Error in loading Add New Case page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_CASE_CREATE;
	}

	@RequestMapping(value = GenericConstants.URL_CW_PROCESS_CASE_CREATE, params = GenericConstants.PARAM_BUTTON_CASE_CREATE, method = RequestMethod.POST)
	public String processCaseCreation(@ModelAttribute("caseCreationForm") CaseCreationForm caseCreationForm,
			Model model, BindingResult result, RedirectAttributes redir) {

		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			caseCreationForm.setCwId(Integer.valueOf(user.getUsername()));

			String benefitAmount = cwpServices.saveNewCase(caseCreationForm);
			String benefitAmountLong = benefitAmount.replace('$', '0');
			if (Long.valueOf(benefitAmountLong) <= 0L) {
				benefitAmount = "Not Eligible for TANF Assistance";
			}

			redir.addFlashAttribute("success", "Case Creation successful");
			redir.addFlashAttribute("eligBenefits",
					"The monthly total assistance eligibility for this case is: " + benefitAmount);

			return "redirect:" + GenericConstants.URL_CW_CASE_CREATE;
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in Case Creation: " + e);
			logger.error("Error in Case Creation: " + e);
			model.addAttribute("message", "Error in Case Creation. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}
	}

	@RequestMapping(value = GenericConstants.URL_CW_APPOINTMENT, method = RequestMethod.GET)
	public String showMyAppointments(Model model) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String appointmentsJsonObj = cwpServices.getCwAppointments(user.getUsername());

			model.addAttribute("appointmentsJsonObj", appointmentsJsonObj);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in loading My Appointments page: " + e);
			logger.error("Error in loading My Appointments page: " + e);
			model.addAttribute("message",
					"Error in loading My Appointments page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_APPOINTMENTS;
	}

	@RequestMapping(value = GenericConstants.URL_CW_ACCOUNT_DETAILS, method = RequestMethod.GET)
	public String showMyAccount(Model model) {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			CwUsers cwUsers = cwpServices.findCaseWorkerById(Integer.valueOf(user.getUsername()));

			model.addAttribute("cwUsers", cwUsers);
			model.addAttribute("welcomeMsg", this.getLoggedInUserAndDate());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in loading My Account page: " + e);
			logger.error("Error in loading My Account page: " + e);
			model.addAttribute("message",
					"Error in loading My Account page. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}

		return GenericConstants.PAGE_ACCOUNT;
	}

	@RequestMapping(value = GenericConstants.URL_CW_PROCESS_ACCOUNT_DETAILS, params = GenericConstants.PARAM_BUTTON_ACCOUNT_UPDATE, method = RequestMethod.POST)
	public String processCaseCreation(@ModelAttribute("cwUsers") CwUsers cwUsers, Model model, BindingResult result,
			RedirectAttributes redir) {

		try {
			cwpServices.updateAccountDetails(cwUsers);
			redir.addFlashAttribute("success", "Account Details updated successfully");

			return "redirect:" + GenericConstants.URL_CW_ACCOUNT_DETAILS;
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Error in Account Details: " + e);
			logger.error("Error in Account Details: " + e);
			model.addAttribute("message", "Error in Account Details. Please contact helpdesk for assistance. " + e);

			return GenericConstants.PAGE_ERROR;
		}
	}

	private String getLoggedInUserAndDate() {
		try {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			return "Welcome <b>" + cwpServices.findCaseWorkerById(Integer.valueOf(user.getUsername())).getName()
					+ "</b>. " + "\t" + " Logged on: " + DateUtil.getDayAndDateInString(new Date());
		} catch (Exception e) {
			errorLogger.error("Classname: CwpDashboardController. Guest login: " + e);
			return "Welcome <b>Guest</b>";
		}
	}
}
