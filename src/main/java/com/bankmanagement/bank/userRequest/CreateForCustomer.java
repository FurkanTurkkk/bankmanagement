package com.bankmanagement.bank.userRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class CreateForCustomer {
    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;
    @JsonProperty("email")
    private final String eMailAddress;
    @JsonProperty("tckn")
    private final String TCkn;

    public CreateForCustomer() {
        this.userName = null;
        this.password = null;
        this.firstName = null;
        this.lastName = null;
        this.eMailAddress = null;
        this.TCkn = null;
    }

    public CreateForCustomer(String userName, String password, String firstName, String lastName, String eMailAddress, String TCkn) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.TCkn = TCkn;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public String getTCkn() {
        return TCkn;
    }
}
