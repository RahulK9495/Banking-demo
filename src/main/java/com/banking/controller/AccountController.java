package com.banking.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entity.Account;
import com.banking.service.AccountService;

@RestController
public class AccountController {

	
	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/account")
	public Account createAccount(@RequestBody Account account)
	{
		return accountService.createAccount(account);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAcoounts()
	{
		return accountService.getAllAccount();
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAcoountByid(@PathVariable Long id)
	{
		Optional<Account> fetchedAccount = accountService.getAccountDetailsByid(id);
		Account ft=fetchedAccount.get();
		return new ResponseEntity<Account>(ft, HttpStatus.OK);
	}
	
	@PostMapping("/account/{id}/deposit")
	public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request)
	{
		Double amount=request.get("amount");
		return accountService.deposit(id,amount);
	}

	@PostMapping("/account/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request)
	{
		Double amount=request.get("amount");
		return accountService.withdraw(id,amount);
	}
}
