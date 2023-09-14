package com.tipperoo.springbootInfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="GiftId", nullable = false, unique = true)
    private Integer giftId;

    @Column(name="GifterUserId", nullable = false, unique = true)
    private Integer gifterUserId;

    @Column(name="RecipientUserId", nullable = false, unique = true)
    private Integer recipientUserId;

    @Column(name="AmountGiven", nullable = false, unique = true)
    private Integer amountGiven;

    @Column(name="Anonymous", nullable = false, unique = true)
    private Boolean anonymous;

    @Column(name="Message", unique = true)
    private String message;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getGifterUserId() {
        return gifterUserId;
    }

    public void setGifterUserId(Integer gifterUserId) {
        this.gifterUserId = gifterUserId;
    }

    public Integer getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(Integer recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public Integer getAmountGiven() {
        return amountGiven;
    }

    public void setAmountGiven(Integer amountGiven) {
        this.amountGiven = amountGiven;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        return "Gift{" +
                "giftId=" + giftId +
                ", gifterUserId=" + gifterUserId +
                ", recipientUserId=" + recipientUserId +
                ", amountGiven=" + amountGiven +
                ", anonymous=" + anonymous +
                ", message='" + message + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
