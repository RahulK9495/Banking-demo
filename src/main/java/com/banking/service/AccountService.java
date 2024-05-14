package com.banking.service;

import java.util.List;
import java.util.Optional;

import com.banking.entity.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public List<Account> getAllAccount();

	public Optional<Account> getAccountDetailsByid(Long id);

	public Account deposit(Long id, Double amount);

	public Account withdraw(Long id, Double amount);

}
