package com.deepak.BankingApp.controller;


import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.service.AccountService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

// create add account api

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }


    // get account details by id api

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountDetailsById(@PathVariable  Long id){
        return new ResponseEntity<>(accountService.getAccountDetails(id),HttpStatus.OK);
    }
}
