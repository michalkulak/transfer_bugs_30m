package com.worldremit.recruitment.transfer.domain;

import java.util.Date;
import java.util.Objects;

public class Transfer {
    private final Date created;
    private final Account sourceAccount;
    private final Account targetAccount;
    private final Integer amount;

    public Transfer(Date created, Account sourceAccount, Account targetAccount, Integer amount) {
        this.created = created;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return created.equals(transfer.created) &&
               sourceAccount.equals(transfer.sourceAccount) &&
               targetAccount.equals(transfer.targetAccount) &&
               amount.equals(transfer.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created, sourceAccount, targetAccount, amount);
    }
}
