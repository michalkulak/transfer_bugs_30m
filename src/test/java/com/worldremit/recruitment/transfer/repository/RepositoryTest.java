package com.worldremit.recruitment.transfer.repository;

import com.worldremit.recruitment.transfer.domain.Account;
import com.worldremit.recruitment.transfer.domain.AccountOwner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.worldremit.recruitment.transfer.TestUtils.parseDate;
import static java.time.Instant.now;

class RepositoryTest {
    @Test
    void test_getAccountsBy_whenOwnerExistsThenReturnsListOfProperAccounts() throws Exception {
        // given
        final Repository repository = new Repository();
        final AccountOwner firstOwner = new AccountOwner("John", "Smith", parseDate("1980-08-05"));
        final List<Account> firstOwnerAccounts = Arrays.asList(
                new Account(882536748, Date.from(now()), firstOwner),
                new Account(647288351, Date.from(now()), firstOwner),
                new Account(155362749, Date.from(now()), firstOwner)
        );
        final AccountOwner secondOwner = new AccountOwner("Hannah", "Jones", parseDate("1980-08-05"));
        final List<Account> secondOwnerAccounts = Arrays.asList(
                new Account(255362704, Date.from(now()), secondOwner),
                new Account(789922834, Date.from(now()), secondOwner),
                new Account(663282349, Date.from(now()), secondOwner)
        );

        firstOwnerAccounts.forEach(account -> repository.registerAccount(firstOwner, account));
        secondOwnerAccounts.forEach(account -> repository.registerAccount(secondOwner, account));

        // when
        final List<Account> accounts = repository.getAccountsBy(secondOwner);

        // then
        Assertions.assertThat(accounts).hasSameElementsAs(secondOwnerAccounts);
    }
}
