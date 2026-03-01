package com.example.banking.service;

import com.example.banking.model.*;
import com.example.banking.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }

    @Transactional
    public Account deposit(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance().add(amount));

        transactionRepository.save(Transaction.builder()
                .type("DEPOSIT")
                .amount(amount)
                .timestamp(LocalDateTime.now())
                .reference(accountNumber)
                .build());

        return account;
    }

    @Transactional
    public Account withdraw(String accountNumber, BigDecimal amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        transactionRepository.save(Transaction.builder()
                .type("WITHDRAW")
                .amount(amount)
                .timestamp(LocalDateTime.now())
                .reference(accountNumber)
                .build());

        return account;
    }
}
