package com.tipperoo.springbootInfrastructure.dao;

import com.tipperoo.springbootInfrastructure.enums.CurrencyType;
import com.tipperoo.springbootInfrastructure.enums.TransactionType;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @Column(name="TransactionId", nullable = false, unique = true)
    private String transactionId;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="CurrencyType", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name="AmountPaid", nullable = false, unique = true)
    private Integer amountPaid;

    @Column(name="StripeToken", nullable = false, unique = true)
    private String stripeToken;

    @Column(name="Description", unique = true)
    private String description;

    @Column(name="TransactionType", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

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

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", currencyType=" + currencyType +
                ", amountPaid=" + amountPaid +
                ", stripeToken='" + stripeToken + '\'' +
                ", description='" + description + '\'' +
                ", transactionType=" + transactionType +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }
}
