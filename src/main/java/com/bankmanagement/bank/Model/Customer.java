package com.bankmanagement.bank.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String eMailAddress;
    private final String TCkn;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Account> accounts;

    protected Customer() {
        this.userName=null;
        this.password=null;
        this.firstName=null;
        this.lastName=null;
        this.eMailAddress=null;
        this.TCkn=null;
    }

    public Customer(String userName, String password,
                    String firstName, String lastName,
                    String eMailAddress, String TCkn) {

        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.TCkn = TCkn;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(TCkn, customer.TCkn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(TCkn);
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

    public Set<Account> getAccounts() {
        return accounts;
    }
}

