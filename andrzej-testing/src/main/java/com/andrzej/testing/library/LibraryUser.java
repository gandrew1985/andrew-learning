package com.andrzej.testing.library;

import java.util.Objects;

public class LibraryUser {

    private String firstName;
    private String lastName;
    private String peselId;

    public LibraryUser(String firstName, String lastName, String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPeselId() {
        return peselId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        LibraryUser lb = (LibraryUser) o;

        if(!Objects.equals(peselId,lb.peselId)) return false;
        if(!Objects.equals(firstName,lb.firstName)) return false;
        return (Objects.equals(lastName,lb.lastName));
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31* result + lastName.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LibraryUser: " + firstName + " " + lastName + ", " + peselId;
    }
}
