package com.bankapp.model.service.account;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.persistance.account.Account;
import com.bankapp.model.persistance.account.AccountDao;

@Service(value="as")
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	@Override
	public void deleteAccount(Integer accountId) {
		accountDao.deleteAccount(accountId);
	}

	@Override
	public Account getAccountById(Integer accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public void transfer(int fromAccountId, 
			int toAccountId, double amount) {
		Account fromAccount=accountDao.getAccountById(fromAccountId);
		Account toAccount=accountDao.getAccountById(toAccountId);
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		accountDao.updateAccount(fromAccount);
		accountDao.updateAccount(toAccount);
	}

	@Override
	public void deposit(int toAccountId, double amount) {
		Account toDeposit=accountDao.getAccountById(toAccountId);
		toDeposit.setBalance(toDeposit.getBalance()+amount);
		accountDao.updateAccount(toDeposit);
	}

	@Override
	public void withdraw(int toAccountId, double amount) {
		Account toWithdraw=accountDao.getAccountById(toAccountId);
		toWithdraw.setBalance(toWithdraw.getBalance()-amount);
		accountDao.updateAccount(toWithdraw);
		
	}

	

}
