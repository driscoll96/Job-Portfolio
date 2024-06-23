package com.tipperoo.springbootInfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @Column(name="PaymentMethodId", nullable = false, unique = true)
    private String paymentMethodId;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="NameOnPayment", unique = true)
    private String nameOnPayment;

    @Column(name="InstitutionName", nullable = false, unique = true)
    private String institutionName;

    @Column(name="PaymentNumLast4Digits", nullable = false, unique = true)
    private String paymentNumLast4Digits;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNameOnPayment() {
        return nameOnPayment;
    }

    public void setNameOnPayment(String nameOnPayment) {
        this.nameOnPayment = nameOnPayment;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getPaymentNumLast4Digits() {
        return paymentNumLast4Digits;
    }

    public void setPaymentNumLast4Digits(String paymentNumLast4Digits) {
        this.paymentNumLast4Digits = paymentNumLast4Digits;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethodId=" + paymentMethodId +
                ", userId=" + userId +
                ", nameOnPayment='" + nameOnPayment + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", paymentNumLast4Digits='" + paymentNumLast4Digits + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
