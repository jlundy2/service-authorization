package com.epam.reportportal.auth.config;

import com.epam.reportportal.auth.integration.AuthIntegrationType;
import com.epam.reportportal.auth.integration.handler.GetAuthIntegrationStrategy;
import com.epam.reportportal.auth.integration.handler.impl.GetActiveDirectoryStrategy;
import com.epam.reportportal.auth.integration.handler.impl.GetLdapStrategy;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@Configuration
public class AuthIntegrationConfig {

	private ApplicationContext applicationContext;

	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Bean("authIntegrationStrategyMapping")
	public Map<AuthIntegrationType, GetAuthIntegrationStrategy> authIntegrationStrategyMapping() {
		return new ImmutableMap.Builder<AuthIntegrationType, GetAuthIntegrationStrategy>().put(AuthIntegrationType.LDAP,
				applicationContext.getBean(GetLdapStrategy.class)
		)
				.put(AuthIntegrationType.ACTIVE_DIRECTORY, applicationContext.getBean(GetActiveDirectoryStrategy.class))
				.build();
	}
}
