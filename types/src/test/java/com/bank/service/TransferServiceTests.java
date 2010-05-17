package com.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bank.app.AppConfig;
import com.bank.app.TellerUI;
import com.bank.domain.TransferConfirmation;
import com.bank.repository.InMemoryAccountRepository;

/**
 * Integration tests for {@link TransferService}.
 * 
 * @author Chris Beams
 * @author Dave Syer
 */
public class TransferServiceTests {

	@Test
	public void testTransfer() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,
				TellerUI.class, InMemoryAccountRepository.class, TransferServiceImpl.class, FlatFeePolicy.class);
		TransferService transferService = context.getBean(TransferService.class);
		TransferConfirmation confirmation = transferService.transfer(20, "A123", "C456");
		assertEquals(20.0, confirmation.getTransferAmount(), 0.01);
	}

}
