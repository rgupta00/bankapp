package com.bankapp.web.forms;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//i have only one resp to carray data from ui to controller
//all validation applied on me

public class TransferForm {
	@NotNull(message="fromAccountId can not be null")
	private Integer fromAccountId;
	@NotNull(message="toAccountId can not be null")
	private Integer toAccountId;
	
	@NotNull(message="amount should not be left blank")
	@Min(value=10, message="min amount should be more then 10")
	@Max(value=10000, message="max amount should be less then 10000")
	private Double amount;
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	
}
