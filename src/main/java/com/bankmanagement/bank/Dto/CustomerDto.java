package com.bankmanagement.bank.Dto;


public class CustomerDto {

    private String firstName;
    private String lastName;
    private String eMailAddress;
    private String TCkn;

    public CustomerDto() {
    }

    public CustomerDto(String firstName, String lastName, String eMailAddress, String TCkn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.TCkn = TCkn;
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
