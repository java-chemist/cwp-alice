/**
 * 
 */
package com.cwp.alice.constants;

/**
 * @author lugupta
 *
 */
public class GenericConstants {

	/* APPLICATION CONSTANTS */
	public static final String LOGGER_ERROR_NAME = "errorfile";
	public static final String STRING_EMPTY = "";
	public static final String ROLE_UNDERSCORE = "ROLE_";
	public static final String ROLE_ADMIN = "ADMIN";
	public static final String SDF_MM_DD_YYYY_HH_MM = "MM/dd/yyyy HH:mm";
	public static final String SDF_E_MM_DD_YYYY = "EEEE, MM/dd/yyyy";
	public static final String SDF_MM_DD_YYYY = "MM/dd/yyyy";
	public static final String SDF_HH_MM_A = "hh:mm a";
	public static final int MAX_SESSIONS = 1;
	public static final String STRING_VAL_MESSAGE = "message";
	public static final String STRING_VALUE_RESULT = "result";
	// Session Timeout - 5 * 60 = 5 minutes
	public static final int SESSION_TIMEOUT = 5 * 60;

	/* REQUEST MAPPING URL */
	public static final String URL_SLASH = "/";
	public static final String URL_LOGIN = "/login";
	public static final String URL_LOGOUT = "/logout";
	public static final String URL_LOGOUTSUCCESS = "/logoutSuccessful";
	public static final String URL_ACCESSDENIED = "/403";
	public static final String URL_INVALIDSESSION = "/invalidSession";
	public static final String URL_SESSIONEXPIRED = "/sessionExpired";
	public static final String URL_CW_DASHBOARD = "/cwDashboard";
	public static final String URL_CW_CASE_CREATE = "/cwCaseCreation";
	public static final String URL_CONV_ALICE = "/saveAliceConversation";
	public static final String URL_CW_PROCESS_CASE_CREATE = "/cwCaseCreationProcess";
	public static final String URL_CW_APPOINTMENT = "/cwAppointment";
	public static final String URL_CW_ACCOUNT_DETAILS = "/cwAccountDetails";
	public static final String URL_CW_PROCESS_ACCOUNT_DETAILS = "/cwAccountDetailsProcess";
	public static final String PARAM_BUTTON_CASE_CREATE = "caseCreation";
	public static final String PARAM_BUTTON_ACCOUNT_UPDATE = "updateAccount";

	/* VIEW PAGE NAME */
	public static final String PAGE_LOGIN = "loginPage";
	public static final String PAGE_ACCESSDENIED = "403Page";
	public static final String PAGE_INVALIDSESSION = "invalidSessionPage";
	public static final String PAGE_SESSIONEXPIRED = "sessionExpiredPage";
	public static final String PAGE_ERROR = "errorPage";
	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String PAGE_DASHBOARD = "dashboardPage";
	public static final String PAGE_CASE_CREATE = "caseCreationPage";
	public static final String PAGE_APPOINTMENTS = "appointmentsPage";
	public static final String PAGE_ACCOUNT = "accountDetailsPage";

	public static final String DIALOGFLOW_CONVERSATION_WEBHOOK = "/serveConversation";

	private GenericConstants() {
	}

}
