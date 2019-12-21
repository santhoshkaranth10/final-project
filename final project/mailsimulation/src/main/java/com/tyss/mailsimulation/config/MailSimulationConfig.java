package com.tyss.mailsimulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class MailSimulationConfig {

	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		 LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		  bean.setPersistenceUnitName("mailsimulation");
		  return bean;
	}
}
