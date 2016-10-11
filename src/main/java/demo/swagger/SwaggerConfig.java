package demo.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 本类是配置Swagger UI测试API功能
 *
 * @author jiekechoo
 *
 */

@Configuration
@EnableSwagger
public class SwaggerConfig {
	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	// Don't forget the @Bean annotation
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo()).includePatterns("/api/.*")
				.apiVersion("1.0.0");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(
				"财富街APP开发接口API文档",
				"/api/××× 直接使用，不需要登录；<br>"
						+ "/api/i/××× 需要使用HTTP Basic登录，或提供x-auth-token<br>"
						+ "包含参数Parameters Data Type=Pageable时，有三个通用参数可以使用,比如：size=20&page=0&sort=popular,desc，"
						+ "默认：size=20表明每页20行，page=0第几页，sort=popular,desc(asc默认正序，desc倒序)",
				null, null, null, null);
		return apiInfo;
	}
}
