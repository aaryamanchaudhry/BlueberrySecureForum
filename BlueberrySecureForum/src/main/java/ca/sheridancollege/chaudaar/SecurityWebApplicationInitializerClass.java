package ca.sheridancollege.chaudaar;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import ca.sheridancollege.chaudaar.config.SecurityConfig;

public class SecurityWebApplicationInitializerClass extends AbstractSecurityWebApplicationInitializer{
	public SecurityWebApplicationInitializerClass()
	{super(SecurityConfig.class);}
}
