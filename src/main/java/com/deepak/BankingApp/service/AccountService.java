package com.deepak.BankingApp.service;

import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.Account;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountDetails (Long id);
}
