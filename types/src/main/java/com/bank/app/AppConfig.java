package com.bank.app;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Dave Syer
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public BeanFactoryPostProcessor propertyPlaceholder() {
		PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
		configurer.setLocation(new ClassPathResource("/com/bank/app/bank.properties"));
		return configurer;
	}

}
