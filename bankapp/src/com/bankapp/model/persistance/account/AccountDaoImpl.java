package com.bankapp.model.persistance.account;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

	private SessionFactory sessionFactory;

	@Autowired
	public AccountDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").list();
	}

	@Override
	public void addAccount(Account account) {
		getSession().save(account);
	}

	@Override
	public void updateAccount(Account account) {
		getSession().merge(account);
	}

	@Override
	public void deleteAccount(Integer accountId) {
		Account account=getAccountById(accountId);
		getSession().delete(account);
	}

	@Override
	public Account getAccountById(Integer accountId) {
		Account account = (Account) getSession().get(Account.class, accountId);
		if (account == null)
			throw new AccountNotFoundException("account with id=" + accountId
					+ " is not found");
		return account;
	}

}








