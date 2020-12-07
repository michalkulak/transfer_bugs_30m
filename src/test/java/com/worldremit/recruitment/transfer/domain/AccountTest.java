package com.worldremit.recruitment.transfer.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static com.worldremit.recruitment.transfer.TestUtils.parseDate;
import static java.time.Instant.now;

class AccountTest {
    @Test
    void test_deposit_afterSequenceOfDepositsAndWithdrawReturnsProperValue() throws Exception {
        // given
        final AccountOwner testOwner = new AccountOwner("Mark", "Taylor", parseDate("1962-05-10"));
        final Account account = new Account(123456789, Date.from(now()), testOwner);
        final int initialBalance = 1000;
        account.deposit(initialBalance);

        // when
        account.deposit(2147483647);

        // then
        Assertions.assertThat(account.getBalance()).isGreaterThan(initialBalance);
    }
}
