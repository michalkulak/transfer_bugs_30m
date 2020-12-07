package com.worldremit.recruitment.transfer.service;

import com.worldremit.recruitment.transfer.Error;
import com.worldremit.recruitment.transfer.domain.Account;
import com.worldremit.recruitment.transfer.domain.AccountOwner;
import com.worldremit.recruitment.transfer.domain.Transfer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.worldremit.recruitment.transfer.TestUtils.parseDate;
import static java.time.Instant.now;

class TransferServiceTest {
    @Test
    void test_makeTransfer_shouldThrowErrorWhenTransferIsNull() {
        // given
        final TransferService service = new TransferService();

        // then
        Assertions.assertThatThrownBy(() -> service.makeTransfer(null)).isInstanceOf(Error.class).hasMessage("Transfer cannot be null!");
    }

    @Test
    void test_makeTransfer_accountShouldHaveProperBalanceAfterManyTransfers() throws Exception {
        // given
        final int initialBalance = 10;
        final int threadsCount = 1000;

        final AccountOwner firstOwner = new AccountOwner("Michael", "Davies", parseDate("1995-11-01"));
        final Account firstOwnerAccount = new Account(213456172, Date.from(now()), firstOwner);
        final AccountOwner secondOwner = new AccountOwner("George", "Evans", parseDate("1972-12-06"));
        final Account secondOwnerAccount = new Account(998245101, Date.from(now()), secondOwner);

        final TransferService transferService = new TransferService();

        final ExecutorService executor = Executors.newFixedThreadPool(threadsCount);

        firstOwnerAccount.deposit(initialBalance);

        // when
        for (int i = 0; i <= threadsCount; i++) {
            executor.execute(() -> {
                transferService.makeTransfer(new Transfer(Date.from(now()), firstOwnerAccount, secondOwnerAccount, initialBalance));
                transferService.makeTransfer(new Transfer(Date.from(now()), secondOwnerAccount, firstOwnerAccount, initialBalance));
            });
        }

        // then
        Assertions.assertThat(firstOwnerAccount.getBalance()).isEqualTo(initialBalance);
        Assertions.assertThat(secondOwnerAccount.getBalance()).isEqualTo(0);
    }
}
