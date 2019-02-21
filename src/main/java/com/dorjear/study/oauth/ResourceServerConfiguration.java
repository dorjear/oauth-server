package com.dorjear.study.oauth;

import java.security.Principal;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@RestController
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**").permitAll()
        .and().authorizeRequests().antMatchers("/usert").access("hasRole('USER')")
        ;
//		http.requestMatchers().antMatchers("/user").and().authorizeRequests().antMatchers("/user")
//				.access("hasRole('USER')");
	}

}
