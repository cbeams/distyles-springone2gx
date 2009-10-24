package com.bank.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bank.repository.AccountRepository;
import com.bank.repository.InMemoryAccountRepository;
import com.bank.service.FeePolicy;
import com.bank.service.FlatFeePolicy;
import com.bank.service.TransferService;
import com.bank.service.TransferServiceImpl;

@Configuration
public class AppConfig {
	
	@Value("${flatfee.amount}") 
	private double flatFeeAmount;
	
	@Bean
	public TellerUI tellerUI() {
		return new TellerUI(transferService());
	}
	
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl(accountRepository(), feePolicy());
	}


	@Bean
	public FeePolicy feePolicy() {
		return new FlatFeePolicy(flatFeeAmount);
	}

	@Bean
	public AccountRepository accountRepository() {
		return new InMemoryAccountRepository();
	}
	
}
