package com.tipperoo.springbootInfrastructure.dao;

import com.tipperoo.springbootInfrastructure.enums.ReactionObject;
import com.tipperoo.springbootInfrastructure.enums.ReactionType;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reaction")
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ReactionId", nullable = false, unique = true)
    private Integer reactionId;

    /**
     * The ID of either the "Gift" or "Comment"
     */
    @Column(name="ObjectId", nullable = false, unique = true)
    private Integer objectId;

    /**
     * Either "Gift" or "Comment"
     */
    @Column(name="ReactionObject", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ReactionObject reactionObject;

    @Column(name="UserId", nullable = false, unique = true)
    private Integer userId;

    @Column(name="ReactionType", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private ReactionType reactionType;

    @Column(name="DateCreated", unique = true)
    private Timestamp dateCreated;

    @Column(name="DateUpdated", unique = true)
    private Timestamp dateUpdated;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public ReactionObject getReactionObject() {
        return reactionObject;
    }

    public void setReactionObject(ReactionObject reactionObject) {
        this.reactionObject = reactionObject;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getReactionId() {
        return reactionId;
    }

    public void setReactionId(Integer reactionId) {
        this.reactionId = reactionId;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "reactionId=" + reactionId +
                ", objectId=" + objectId +
                ", reactionObject=" + reactionObject +
                ", userId=" + userId +
                ", reactionType=" + reactionType +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
