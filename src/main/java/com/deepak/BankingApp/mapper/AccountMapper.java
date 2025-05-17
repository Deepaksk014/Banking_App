package com.deepak.BankingApp.mapper;

import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.Account;


public class AccountMapper {

    public static Account mapToAccount (AccountDto accountDto){

        Account account= new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

        return account;
    }


    public static AccountDto maptoAccountDto (Account account){

        AccountDto accountDto= new AccountDto(

                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
