package demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置文件，主要是重写默认的认证方式和访问目录权限
 *
 * @author jiekechoo
 *
 */
@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	/**
	 * 使用jdbc认证方式，密码采用BCrypt加密，salt 10
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new BCryptPasswordEncoder(10));

	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			//http.antMatcher("/api/i/**").authorizeRequests().anyRequest().hasRole("USER").and().httpBasic().and().csrf()	.disable();
		}
	}

	@Configuration
	@Order(2)
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// http.httpBasic().disable();//启用redis需要启用此行
			http.authorizeRequests()
					.antMatchers("/api/create", "/", "/assets/**", "/plugins/**", "/static/**", "/bootstrap/**",
							"/api-docs/**", "/debug/**", "/api/**","/dist/**","/public/")
					.permitAll().antMatchers("/admin/**").hasRole("ADMIN").anyRequest().authenticated().and()
					.formLogin().loginPage("/login").permitAll().and().logout().permitAll().and().csrf().disable();
		}
	}
}
