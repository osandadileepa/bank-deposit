package com.osanda.bankDeposit.enums;

public enum FixedDepositAccountType {

	SUPER_HIT("Super Hit"), GREAT_DEAL("Great Deal"), ANYTIME("Anytime");

	private String value;

	private FixedDepositAccountType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}
