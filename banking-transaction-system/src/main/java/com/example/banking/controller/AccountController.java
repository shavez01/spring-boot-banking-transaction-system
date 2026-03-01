package com.example.banking.controller;

import com.example.banking.model.Account;
import com.example.banking.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PostMapping("/{accountNumber}/deposit")
    public Account deposit(@PathVariable String accountNumber,
                           @RequestParam BigDecimal amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PostMapping("/{accountNumber}/withdraw")
    public Account withdraw(@PathVariable String accountNumber,
                            @RequestParam BigDecimal amount) {
        return accountService.withdraw(accountNumber, amount);
    }
}
