package demo;

import org.lightadmin.api.config.LightAdmin;
import org.lightadmin.core.config.LightAdminWebApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Order(HIGHEST_PRECEDENCE)
public class SpringSecuritySessionRedisUserDetailsServiceApplication extends
		SpringBootServletInitializer {

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext)
					throws ServletException {
				LightAdmin.configure(servletContext)
						.basePackage("demo.administration")
						.baseUrl("/lightadmin").security(false)
						.backToSiteUrl("/");

				new LightAdminWebApplicationInitializer()
						.onStartup(servletContext);
			}
		};
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(
				SpringSecuritySessionRedisUserDetailsServiceApplication.class,
				args);
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application
				.sources(SpringSecuritySessionRedisUserDetailsServiceApplication.class);
	}

}
