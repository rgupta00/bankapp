package com.bankapp.model.persistance.account;
import java.util.*;
public interface AccountDao {
	public List<Account>getAllAccounts();
	public void addAccount(Account account);
	public void updateAccount(Account account);
	public void deleteAccount(Integer accountId);
	public Account getAccountById(Integer accountId);
} 
