package com.deepak.BankingApp.service.impl;

import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.Account;
import com.deepak.BankingApp.entity.AccountResponse;
import com.deepak.BankingApp.mapper.AccountMapper;
import com.deepak.BankingApp.repository.AccountRepository;
import com.deepak.BankingApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public AccountResponse depositByAccountId(Long id, Long depositAmount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id" + id));

        var currentBal= account.getBalance();
        var latestBal = currentBal + depositAmount;

        account.setBalance(latestBal);
        accountRepository.save(account);
        return new AccountResponse("Amount Deposit success.",AccountMapper.maptoAccountDto(account));
    }

    @Override
    public List<AccountDto> GetAllAccountDetails() {
        List<Account> accList = accountRepository.findAll();

        return accList.stream().
                map(AccountMapper::maptoAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountResponse withdrawByAccountId(Long id, Long withdrawAmount) {
        Account account= accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found with id" + id));

        var currentBal = account.getBalance();

        if(currentBal >= withdrawAmount ){
           account.setBalance(currentBal -withdrawAmount);
            accountRepository.save(account);

            return new AccountResponse("withdraw success" , AccountMapper.maptoAccountDto(account));

        } else {
            throw new RuntimeException("insufficient funds");
        }

    }
}
