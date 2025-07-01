package com.deepak.BankingApp.service;

import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.Account;
import com.deepak.BankingApp.entity.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountDto createAccount (AccountDto accountDto);

    AccountDto getAccountDetails (Long id);

    AccountResponse depositByAccountId (Long id, Long depositAmount);

    List<AccountDto> GetAllAccountDetails ();

    AccountResponse withdrawByAccountId (Long id, Long withdrawAmount);

    String deleteAccount ( Long id);
}
