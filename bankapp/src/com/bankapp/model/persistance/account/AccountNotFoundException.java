package com.bankapp.model.persistance.account;

public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String message) {
		super(message);
	}
}
