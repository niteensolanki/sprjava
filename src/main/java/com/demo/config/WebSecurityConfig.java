package com.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from user where username=?")
				.authoritiesByUsernameQuery("select p.username, r.rname from role r join user p on r.id ="
						+ "p.role_id where p.username=? ")
				.passwordEncoder(new Md5PasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/login", "/paynetz**").permitAll()
				.antMatchers("/", "/home").authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/home").failureForwardUrl("/login").usernameParameter("username")
				.passwordParameter("password").permitAll().and().exceptionHandling().accessDeniedPage("/Access_Denied")
				.and().sessionManagement().invalidSessionUrl("/login");

		http.logout().permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}

}
