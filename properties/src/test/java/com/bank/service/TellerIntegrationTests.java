package com.bank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.GenericPropertiesContextLoader;

import com.bank.domain.TransferConfirmation;

@ContextConfiguration(loader=GenericPropertiesContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TellerIntegrationTests {
	
	@Autowired
	private TransferService transferService;
	
	@Test
	public void testTransfer() throws Exception {
		TransferConfirmation confirmation = transferService.transfer(20, "A123", "C456");
		assertEquals(20.0, confirmation.getTransferAmount(), 0.01);
	}

}
