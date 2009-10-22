package com.bank.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration tests for {@link TransferService}.
 *
 * @author Chris Beams
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TransferServiceTests {
	
	/**
	 * confirms that the wiring in app-config.xml works properly
	 */
	@Test
	public void testAutowiring() { }
}
