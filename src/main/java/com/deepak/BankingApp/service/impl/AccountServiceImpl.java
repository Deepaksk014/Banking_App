package com.deepak.BankingApp.service.impl;

import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.Account;
import com.deepak.BankingApp.mapper.AccountMapper;
import com.deepak.BankingApp.repository.AccountRepository;
import com.deepak.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService  {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }




    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount =accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountDetails(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id" + id));
        return AccountMapper.maptoAccountDto(account);
    }
}
