package com.bank.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named
public class FlatFeePolicy implements FeePolicy {

	private final double flatFee;

	@Inject
	public FlatFeePolicy(@Value("${flatfee.amount}") double flatFee) {
		this.flatFee = flatFee;
	}
	
	public double calculateFee(double transferAmount) {
		return flatFee;
	}

}
