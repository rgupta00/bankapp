package com.bankapp.model.service.account;

import java.util.List;

import com.bankapp.model.persistance.account.Account;

public interface AccountService {
	//req by mgr
	public List<Account>getAllAccounts();
	public void addAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Integer accountId);
	public Account getAccountById(Integer accountId);
	
	//req by clerk
	
	public void transfer(int fromAccountId, int toAccountId, double amount);
	public void deposit(int toAccountId, double amount);
	public void withdraw(int toAccountId, double amount);

}
