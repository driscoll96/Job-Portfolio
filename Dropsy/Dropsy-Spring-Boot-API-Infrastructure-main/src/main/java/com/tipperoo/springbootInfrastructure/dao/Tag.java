package com.tipperoo.springbootInfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TagId", nullable = false, unique = true)
    private Integer tagId;

    @Column(name="GiftId", nullable = false, unique = true)
    private Integer giftId;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="TagName", nullable = false, unique = true)
    private String tagName;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", giftId=" + giftId +
                ", userId=" + userId +
                ", tagName='" + tagName + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
