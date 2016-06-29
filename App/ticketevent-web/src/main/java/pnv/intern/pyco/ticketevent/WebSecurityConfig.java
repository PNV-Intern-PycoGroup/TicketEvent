package pnv.intern.pyco.ticketevent;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select user_name, password, isActive from accounts where user_name=?")
		.authoritiesByUsernameQuery(
			"select a.user_name, u.role from user_roles u, accounts a where u.id = a.role_id and a.user_name=?");
	}	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/","/home").permitAll()
		.antMatchers("/admin-page", "/user-management").access("hasRole('ROLE_ADMIN')")		
		.and()
		.formLogin()
                .defaultSuccessUrl("/")
                .loginPage("/")
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
