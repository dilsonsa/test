package org.fiveware;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.fiveware.model",
								"org.fiveware.service",
								"org.fiveware.repository",
								"org.fiveware.controller",
								"org.fiveware.config"})

public class Application extends SpringBootServletInitializer {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Environment environment;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		logger.info(" Test Started {} ", environment.getActiveProfiles()[0]);

		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
