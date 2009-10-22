package com.bank.app;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConfigurationClassApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TellerBootstrap {

	public static void main(String... args) throws IOException {
		ApplicationContext ctx = new ConfigurationClassApplicationContext(AppConfig.class);
	}

}
