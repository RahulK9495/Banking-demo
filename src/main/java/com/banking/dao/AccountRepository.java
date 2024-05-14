package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.banking.entity.Account;


public interface AccountRepository extends JpaRepository <Account,Long>{

}
