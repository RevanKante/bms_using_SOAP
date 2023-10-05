package com.bms.service;


import com.bms.entity.Account;
import com.bms.entity.Transaction;
import com.bms.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public List<Transaction> getAllTransactions(long accountNumber) {
        Account account = repository.findById(accountNumber).get();
        System.out.println(account.getTransactions());
        return account.getTransactions();
    }

    public Account getAccountByAccountNumber(long accountNumber) {
        return repository.findById(accountNumber).get();
    }

    public void saveAccount(Account account) {
        repository.save(account);
    }
}
