package com.bank.app;

import java.io.IOException;

import com.bank.repository.AccountRepository;
import com.bank.repository.InMemoryAccountRepository;
import com.bank.service.FlatFeePolicy;
import com.bank.service.FeePolicy;
import com.bank.service.TransferService;
import com.bank.service.TransferServiceImpl;

public class TellerBootstrap {

	public static void main(String... args) throws IOException {

		AccountRepository accountRepository = new InMemoryAccountRepository();
		FeePolicy feePolicy = new FlatFeePolicy(2.00);
		TransferService transferService = new TransferServiceImpl(accountRepository, feePolicy);
		transferService.setMinimumTransferAmount(10.00);
		TellerUI tellerUI = new TellerUI(transferService);
		
		tellerUI.start();
	}

}
