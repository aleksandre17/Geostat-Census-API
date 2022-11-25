package com.apps.censusapp;

import com.apps.censusapp.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CensusAppApplication { ///extends SpringBootServletInitializer

//	@Override
//	protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder) {
//		return applicationBuilder.sources(CensusAppApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(CensusAppApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder encoder () {
		return new BCryptPasswordEncoder();
	}

	@Bean(name = "AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}

}
