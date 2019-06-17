package com.testapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ServletComponentScan("cl.test")
public class TestApiApplication {

	private static final Logger logger = LoggerFactory.getLogger(TestApiApplication.class);

	public static void main(String[] args) {
		logger.info("Aplicacion Escuchando Peticiones MS-API-TEST.....");
		SpringApplication.run(TestApiApplication.class, args);

	}
	/**
	 * DateTime Set
	@PostConstruct
	public void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));   // It will set UTC timezone
	}**/

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}
}
