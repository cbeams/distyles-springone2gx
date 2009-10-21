package com.bank.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Qualifier("international")
@Component
public class VariableFeePolicy implements FeePolicy {
	
	private double feePercentage;
	private double minimumFee;

	@Required @Value("${minimum.fee}")
	public void setMinimumFee(double minimumFee) {
		this.minimumFee = minimumFee;
	}
	
	@Required @Value("${fee.percentage}")
	public void setFeePercentage(double feePercentage) {
		this.feePercentage = feePercentage;
	}

	@Override
	public double calculateFee(double transferAmount) {
		double variableFee = transferAmount * (feePercentage/100);
		return variableFee > minimumFee ? variableFee : minimumFee;
	}

}
