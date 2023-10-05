package com.bms.service;


import com.bms.entity.Account;
import com.bms.entity.Transaction;
import com.bms.repository.TransactionRepository;
import com.bms.transaction_management.GetAllTransactionsRequest;
import com.bms.transaction_management.GetAllTransactionsResponse;
import com.bms.transaction_management.PerformTransactionRequest;
import com.bms.transaction_management.PerformTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountService accountService;

    public PerformTransactionResponse performTransaction(PerformTransactionRequest request) {
        PerformTransactionResponse response = new PerformTransactionResponse();
        Account account = accountService.getAccountByAccountNumber(request.getAccountNumber());
        double balance = account.getBalance();

        Transaction transaction = new Transaction();

        if (request.getTransactionType().equals("credit")) {
            balance += request.getAmount();
            account.setBalance(balance);
            transaction.setAccount(account);
            transaction.setTransactionType(request.getTransactionType());
            transaction.setTransactionDate(new Date());
            transaction.setAmount(request.getAmount());
            accountService.saveAccount(account);
            transactionRepository.save(transaction);

            response.setMessage("Account credited with " +request.getAmount()+"Rs , Updated balance is " + balance + "Rs");
            return response;
        } else if (request.getTransactionType().equals("withdraw")) {
            if (balance < request.getAmount()) {
                response.setMessage("Failed to withdraw money, Insufficient balance \nBalance : " + balance + "Rs");
                return response;
            } else {
                balance -= request.getAmount();
                account.setBalance(balance);
                transaction.setAccount(account);
                transaction.setAmount(request.getAmount());
                transaction.setTransactionType(request.getTransactionType());
                transaction.setTransactionDate(new Date());
                transactionRepository.save(transaction);
                accountService.saveAccount(account);
                response.setMessage("Account debited with " + request.getAmount() + "Rs, Updated balance is " + balance + "Rs");
                return response;
            }
        } else {
            response.setMessage("Failed to process transaction,Please enter correct details for transaction");
            return response;
        }
    }

    public GetAllTransactionsResponse getAllTransactions(long accountNumber) {
        GetAllTransactionsResponse response = new GetAllTransactionsResponse();
        List<com.bms.transaction_management.Transaction> transactionsList = response.getTransactions();

        Account account = accountService.getAccountByAccountNumber(accountNumber);
        List<Transaction> transactions = account.getTransactions();

        transactions.forEach(transaction -> {
            com.bms.transaction_management.Transaction transaction1 = new com.bms.transaction_management.Transaction();
            transaction1.setTransactionId(transaction.getTransactionId());
            transaction1.setTransactionType(transaction.getTransactionType());
            transaction1.setAmount(transaction.getAmount());
            transaction1.setTransactionDate(transaction.getTransactionDate());

            transactionsList.add(transaction1);
        });
        return response;
    }
}
