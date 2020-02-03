package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.persistance.account.Account;
import com.bankapp.model.persistance.account.AccountNotFoundException;
import com.bankapp.model.service.account.AccountService;
import com.bankapp.web.forms.TransferForm;

@Controller
public class TransactionController {
	private AccountService accountService;

	@Autowired
	public TransactionController(AccountService accountService) {
		this.accountService = accountService;
	}

	/* this will display a page that allow to submit new account */
	@RequestMapping(value = "fundtransfer", method = RequestMethod.GET)
	public String transferGet(ModelMap map) {
		map.addAttribute("transferForm", new TransferForm());
		return "fundtransfer";
	}

	@RequestMapping(value = "fundtransfer", method = RequestMethod.POST)
	public String transferPost(
			@Valid @ModelAttribute(value = "transferForm") 
			TransferForm transferForm, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()){
			return "fundtransfer";
		}else{
		accountService.transfer(transferForm.getFromAccountId(),
				transferForm.getToAccountId(), 
				transferForm.getAmount());
		return "redirect:/allaccounts";
		}
	}
	
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ModelAndView handleBookNotFoundException
	(HttpServletRequest request, Exception ex){
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL());
	   
	    modelAndView.setViewName("accontnotfound");
	    return modelAndView;
	}	
	
	
}














