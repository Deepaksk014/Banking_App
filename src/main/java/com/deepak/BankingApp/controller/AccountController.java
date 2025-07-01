package com.deepak.BankingApp.controller;


import com.deepak.BankingApp.dto.AccountDto;
import com.deepak.BankingApp.entity.AccountResponse;
import com.deepak.BankingApp.service.AccountService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountResponse> depositeByAccountId(@PathVariable Long id, @RequestParam Long depositAmount){
        return new ResponseEntity<>(accountService.depositByAccountId(id, depositAmount),HttpStatus.OK);
    }

    @GetMapping("/allAccountsDetails")
    public ResponseEntity<List<AccountDto>> getAllAccountDetails (){
        return new ResponseEntity<>(accountService.GetAllAccountDetails(),HttpStatus.OK);
    }

    @PutMapping("/withdrawal/{id}")
    public ResponseEntity<AccountResponse> withdrawByAccountId(@PathVariable Long id, @RequestParam Long withdrawAmount){
        return new ResponseEntity<>(accountService.withdrawByAccountId(id, withdrawAmount), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(accountService.deleteAccount(id),HttpStatus.OK);
    }
}
