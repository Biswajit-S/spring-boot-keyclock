/**
 * All the securirty related confogurations are done here.
 */
package com.example.microbot.SecureApp.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

/**
 * @author biswajit
 *
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Value("${secure.app.keyclockhostname}")
//    private String keyclockUrl;
	
	String jwkSetUri = "http://keycloak:8080/auth/realms/VFZ/protocol/openid-connect/certs";
	
	/**
	 * Security configurations for OAuth2 is done here.
	 * APIs with the below path required to present an valid access token, before the request is processed.
	 * /echo-server/application/ping/*
	 * /echo-server/application/echo/*
	 * 
	 * Also checks for scope of the access token to be "vz_test"
	 *
	 */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests -> authorizeRequests
                .antMatchers(HttpMethod.GET, "/ping/**").hasAuthority("SCOPE_vz_test")
                .antMatchers(HttpMethod.GET, "/echo/**").hasAuthority("SCOPE_vz_test")
                .anyRequest().authenticated()).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
    
    /**
	 * Service method to decode the JWT.
	 *
	 */
    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
    }
}
