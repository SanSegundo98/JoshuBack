package com.PSSA.joshu.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateForSearch {

	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}
}
