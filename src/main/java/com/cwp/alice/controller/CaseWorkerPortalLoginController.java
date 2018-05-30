/**
 * 
 */
package com.cwp.alice.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cwp.alice.constants.GenericConstants;

/**
 * This class renders the Employee Login screen
 * 
 * @author lugupta
 *
 */
@Controller
public class CaseWorkerPortalLoginController {

	/**
	 * Display the login page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { GenericConstants.URL_SLASH, GenericConstants.URL_LOGIN }, method = RequestMethod.GET)
	public String showLoginPage() {
		return GenericConstants.PAGE_LOGIN;
	}

	/**
	 * Logout and redirect to login page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_LOGOUTSUCCESS, method = RequestMethod.GET)
	public String showLogoutSuccessfulPage(Model model) {
		model.addAttribute("logout", "Logout");

		return GenericConstants.PAGE_LOGIN;
	}

	/**
	 * Display custom message while user access page without permission
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_ACCESSDENIED, method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if (null != principal) {
			model.addAttribute(GenericConstants.STRING_VAL_MESSAGE,
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}

		return GenericConstants.PAGE_ACCESSDENIED;
	}

	/**
	 * Redirect to this page when the user remains inactive
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_INVALIDSESSION, method = RequestMethod.GET)
	public String invalidSession(Model model, Principal principal) {
		if (null != principal) {
			model.addAttribute(GenericConstants.STRING_VAL_MESSAGE, "Hi " + principal.getName()
					+ "<br> Session Timeout. You were inactive for more than 5 minutes. Please login again!");
		} else {
			model.addAttribute("msg",
					"Session Timeout. You were inactive for more than 5 minutes. Please login again!");
		}

		return GenericConstants.PAGE_INVALIDSESSION;
	}

	/**
	 * Redirect to this page when the user login from multiple devices/browsers
	 * 
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = GenericConstants.URL_SESSIONEXPIRED, method = RequestMethod.GET)
	public String sessionExpired(Model model, Principal principal) {
		if (null != principal) {
			model.addAttribute(GenericConstants.STRING_VAL_MESSAGE, "Hi " + principal.getName()
					+ "<br> This session has been expired (possibly due to multiple concurrent logins being attempted as the same user)!");
		} else {
			model.addAttribute("msg",
					"This session has been expired (possibly due to multiple concurrent logins being attempted as the same user)!");
		}

		return GenericConstants.PAGE_SESSIONEXPIRED;
	}

}
