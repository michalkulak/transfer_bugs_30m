package com.worldremit.recruitment.transfer.domain;

import java.util.Date;
import java.util.Objects;

public class Account {
    private final int number;
    private final Date created;
    private final AccountOwner owner;
    private Integer balance = 0;

    public Account(int number, Date created, AccountOwner owner) {
        this.number = number;
        this.created = created;
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }

    public AccountOwner getOwner() {
        return owner;
    }

    public Integer getBalance() {
        return balance;
    }

    public void deposit(final int amount) {
        balance = balance + amount;
    }

    public void withdraw(final int amount) {
        balance = balance - amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number &&
               created.equals(account.created) &&
               owner.equals(account.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, created, owner);
    }
}
