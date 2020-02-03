package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bankapp.model.persistance.account.Account;
import com.bankapp.model.service.account.AccountService;

import java.util.*;
@Controller
public class AccountController {

	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@ModelAttribute(value="accountTypes")
	public List<String> accountTypes(){
		System.out.println("---------------------before any req to method of this class---");
		return Arrays.asList("saving","current","rd");
	}
	
	@RequestMapping(value = "deleteaccount", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest request) {
		Integer accountId=Integer.parseInt
				(request.getParameter("accountId"));
		accountService.deleteAccount(accountId);
		return "redirect:/allaccounts";
	}
	
	
	/* this will do post operation to add a account to db*/
	@RequestMapping(value = "addaccount", method = RequestMethod.POST)
	public String accountPost(
			@ModelAttribute(value = "account") Account account) {
		accountService.addAccount(account);
		return "redirect:/allaccounts";
	}

	/* this will display a page that allow to submit new account */
	@RequestMapping(value = "addaccount", method = RequestMethod.GET)
	public String accountGet(ModelMap map) {
		map.addAttribute("account", new Account());
		return "addaccount";
	}

	/* this will display all accounts */
	@RequestMapping(value = "allaccounts", method = RequestMethod.GET)
	public String allAccounts(ModelMap map) {
		map.addAttribute("accounts", accountService.getAllAccounts());
		return "allaccounts";
	}

}
