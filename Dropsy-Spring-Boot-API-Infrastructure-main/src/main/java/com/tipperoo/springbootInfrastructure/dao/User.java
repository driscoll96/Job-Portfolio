package com.tipperoo.springbootInfrastructure.dao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="CoinBalance", nullable = false, unique = true)
    private Integer coinBalance;

    @Column(name="FirstName", nullable = false, unique = true)
    private String firstName;

    @Column(name="LastName", nullable = false, unique = true)
    private String lastName;

    @Column(name="Email", nullable = false, unique = true)
    private String email;

    @Column(name="Username", nullable = false, unique = true)
    private String username;

    @Column(name="Password", nullable = false, unique = true)
    private String password;

    @Column(name="PaymentAccountId", unique = true)
    private String paymentAccountId;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getPaymentAccountId() {
        return paymentAccountId;
    }

    public void setPaymentAccountId(String paymentAccountId) {
        this.paymentAccountId = paymentAccountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", coinBalance=" + coinBalance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", paymentAccountId='" + paymentAccountId + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }

    public Integer getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(Integer coinBalance) {
        this.coinBalance = coinBalance;
    }
}
