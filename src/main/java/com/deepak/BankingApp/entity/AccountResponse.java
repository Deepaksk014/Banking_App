package com.deepak.BankingApp.entity;

import com.deepak.BankingApp.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String message;
    private AccountDto account;

}
