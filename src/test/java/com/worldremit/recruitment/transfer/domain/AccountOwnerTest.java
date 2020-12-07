package com.worldremit.recruitment.transfer.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.worldremit.recruitment.transfer.TestUtils.parseDate;

class AccountOwnerTest {
    @Test
    void test_toString_returnsProperlyFormattedText() throws Exception {
        // given
        final AccountOwner owner = new AccountOwner("Adam", "Williams", parseDate("1990-01-01"));

        // when
        String result = owner.toString();

        // then
        Assertions.assertThat(result).isEqualTo("AccountOwner(name='Adam', surname='Williams', dateOfBirth=1990-01-01)");
    }
}
