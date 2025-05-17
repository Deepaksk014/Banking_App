package com.deepak.BankingApp.repository;

import com.deepak.BankingApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {


    @Override
    Account getReferenceById(Long id);
}
