package com.worldremit.recruitment.transfer.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class AccountOwner {
    private final String name;
    private final String surname;
    private final Date dateOfBirth;

    public AccountOwner(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return "AccountOwner[name='" + name + "', surname='" + surname + "', dateOrBirth=" + dateFormat.format(dateOfBirth) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountOwner that = (AccountOwner) o;
        return dateOfBirth.equals(that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth);
    }
}
