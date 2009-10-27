package com.bank.app;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TellerBootstrap {

	public static void main(String... args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-config.xml", TellerBootstrap.class);
		TellerUI tellerUI = ctx.getBean(TellerUI.class);
		tellerUI.start();
	}

}
