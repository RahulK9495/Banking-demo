package com.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.AccountRepository;
import com.banking.entity.Account;
import com.banking.exception.AccountNotFoundException;
import com.banking.exception.insufficientBalanceException;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		
		return  accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() {

		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> getAccountDetailsByid(Long id) {

		return accountRepository.findById(id);
	}

	@Override
	public Account deposit(Long id, Double amount) {
	
		Account account;
		try {
		account = accountRepository.findById(id).get();
		}
		catch(Exception e)
		{
			throw new AccountNotFoundException();
		}
		account.setBalance(account.getBalance()+amount);
		return accountRepository.save(account);
	}

	@Override
	public Account withdraw(Long id, Double amount) {
		
		Account account = accountRepository.findById(id).get();
		if(account.getBalance()<0)
		{
			throw new insufficientBalanceException();
		}
		account.setBalance(account.getBalance()-amount);
		return accountRepository.save(account);

	}

}
