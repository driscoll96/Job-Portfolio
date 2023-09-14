package com.tipperoo.springbootInfrastructure.dao;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CommentId", nullable = false, unique = true)
    private Integer commentId;

    @Column(name="GiftId", nullable = false, unique = true)
    private Integer giftId;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="Message", nullable = false, unique = true)
    private String message;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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
        return "Comment{" +
                "commentId=" + commentId +
                ", giftId=" + giftId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
