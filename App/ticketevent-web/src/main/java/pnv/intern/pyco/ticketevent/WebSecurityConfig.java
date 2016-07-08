package pnv.intern.pyco.ticketevent;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select user_name, password, is_active from account where is_active = 1 and user_name=?")
		.authoritiesByUsernameQuery(
			"select a.user_name, u.role from user_role u, account a where u.id = a.role_id and a.user_name=?");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.antMatchers("/admin-page", "/user-management").access("hasRole('ROLE_ADMIN')")		
		.and()
		.formLogin()
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .failureUrl("/?error")
                .permitAll()
		  .usernameParameter("user_name").passwordParameter("password")
		.and()
		 .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/")
		 .and()
		 .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf();
	}
	
}
