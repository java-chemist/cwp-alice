/**
 * 
 */
package com.cwp.alice.authentication;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cwp.alice.constants.GenericConstants;
import com.cwp.alice.dao.CaseWorkerPortalDAO;
import com.cwp.alice.model.CwUsers;

/**
 * @author lugupta
 *
 */
@Service
public class CustomAuthenticationService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomAuthenticationService.class);
	private static final Logger errorLogger = Logger.getLogger(GenericConstants.LOGGER_ERROR_NAME);

	@Autowired
	private CaseWorkerPortalDAO caseWorkerPortalDAO;

	@Override
	public UserDetails loadUserByUsername(String caseWorkerId) {

		try {
			logger.debug("START loadUserByUsername() in CustomAuthenticationService.class");

			CwUsers cwUsers = caseWorkerPortalDAO.findCaseWorkerById(Integer.valueOf(caseWorkerId));

			if (null == caseWorkerPortalDAO) {
				errorLogger.error("Classname: CustomAuthenticationService. Case Worker with id " + caseWorkerId
						+ " not present in the database");
				logger.error("Case Worker with id " + caseWorkerId + " not found in the db");

				throw new UsernameNotFoundException(
						"Case Worker with id " + caseWorkerId + " was not found in the database");
			}

			logger.debug("Case Worker Name: " + cwUsers.getName());

			List<GrantedAuthority> grantList = new ArrayList<>();
			GrantedAuthority authority = new SimpleGrantedAuthority(
					GenericConstants.ROLE_UNDERSCORE + GenericConstants.ROLE_ADMIN);
			grantList.add(authority);

			UserDetails userDetails = new User(cwUsers.getCwId().toString(), cwUsers.getPassword(), grantList);

			logger.debug("END loadUserByUsername() in CustomAuthenticationService.class");

			return userDetails;
		} catch (Exception e) {
			errorLogger.error("Classname: CustomAuthenticationService. Case Worker with id " + caseWorkerId
					+ " was not found in the database" + e);
			logger.error("Case Worker with id " + caseWorkerId + " not available" + e);

			throw new UsernameNotFoundException("Case Worker with id " + caseWorkerId + " missing");
		}
	}

}