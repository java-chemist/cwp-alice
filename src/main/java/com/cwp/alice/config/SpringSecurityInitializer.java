/**
 * 
 */
package com.cwp.alice.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author lugupta
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

	@Override
	public boolean enableHttpSessionEventPublisher() {
		return true;
	}

}