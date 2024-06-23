package com.tipperoo.springbootInfrastructure.dao;

import com.tipperoo.springbootInfrastructure.enums.Countries;
import com.tipperoo.springbootInfrastructure.enums.States;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AddressId", nullable = false, unique = true)
    private Integer addressId;

    @Column(name="StreetAddress", unique = true)
    private String streetAddress;

    @Column(name="StreetAddress2", unique = true)
    private String streetAddress2;

    @Column(name="City", unique = true)
    private String city;

    @Column(name="State", unique = true)
    @Enumerated(EnumType.STRING)
    private States state;

    @Column(name="Country", unique = true)
    @Enumerated(EnumType.STRING)
    private Countries country;

    @Column(name="Zipcode", unique = true)
    private String zipcode;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Address{" +
                "addressId=" + addressId +
                ", streetAddress='" + streetAddress + '\'' +
                ", streetAddress2='" + streetAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", state=" + state +
                ", country=" + country +
                ", zipcode='" + zipcode + '\'' +
                ", userId=" + userId +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}

