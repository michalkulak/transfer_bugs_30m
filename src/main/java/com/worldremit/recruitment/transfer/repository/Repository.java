package com.worldremit.recruitment.transfer.repository;

import com.worldremit.recruitment.transfer.domain.Account;
import com.worldremit.recruitment.transfer.domain.AccountOwner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private final Map<AccountOwner, List<Account>> accountsByOwner = new HashMap<>();

    public List<Account> getAccountsBy(final AccountOwner owner) {
        return accountsByOwner.get(owner);
    }

    public void registerAccount(final AccountOwner owner, final Account account) {
        accountsByOwner.computeIfAbsent(owner, o -> new ArrayList<>()).add(account);
    }
}
