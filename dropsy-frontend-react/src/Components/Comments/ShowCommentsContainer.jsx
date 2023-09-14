import React, { useState, useEffect } from "react";
import Comment from "./Comment";
import AddComment from "./AddComment";
import { userContext } from "../../App";
import * as commentsApi from "../../Services/Api/comments-api";
import * as userApi from "../../Services/Api/user-api";

export default function ShowCommentsContainer({ gift, comments, setComments }) {
    const [updateComments, setUpdateComments] = useState();
    const [hideComments, setHideComments] = useState();
    let commentsWithNewComments = [];
    let commentObject = {
        giftId: gift.giftId,
        userId: userContext.value.userId,
        message: "",
    };

    let commentsJsx = [];

    useEffect(() => {
        fetchComments();
    }, [updateComments]);

    const fetchComments = async () => {
        const fetchedComments = await commentsApi.getAllCommentsFromGiftId(
            gift.giftId
        );
        commentsJsx = await fetchedComments.map(async (comment, idx) => {
            const userComment = await userApi.getUserById(comment.userId);
            return (
                <Comment
                    id={comment.commentId}
                    key={`gift-${gift.giftId}-comment-key-${idx}`}
                    isNew={false}
                    gift={gift}
                    comment={comment}
                    user={userComment}
                    handleDeleteComment={handleDeleteComment}
                    handleUpdateComment={handleUpdateComment}
                />
            );
        });
        commentsJsx = await Promise.all(commentsJsx);
        setComments(commentsJsx);
    };
    const handleAddComment = async (comment) => {
        commentsWithNewComments = [...comments];
        commentObject.message = comment;
        console.log(commentObject);
        const newCommentId = await commentsApi.addComment(commentObject);
        setUpdateComments(!updateComments);
    };

    const handleDeleteComment = async (id) => {
        commentsJsx = await Promise.all(commentsJsx);
        if (commentsWithNewComments.length === 0) {
            commentsWithNewComments = [...commentsJsx];
        }
        let deletedComment = await commentsApi.deleteCommentById(id);
        commentsWithNewComments = commentsWithNewComments.filter((comment) => {
            return parseInt(comment.props.comment.commentId) != parseInt(id)
                ? comment
                : "";
        });
        setComments([...commentsWithNewComments]);
    };

    const handleUpdateComment = async (comment, id) => {
        comment.dateUpdated = null;
        const updateComment = await commentsApi.updateCommentById(comment, id);
        setUpdateComments(!updateComments);
    };

    return (
        <div>
            <div style={{ border: "1px solid black", margin: "50px" }}>
                {hideComments ? (
                    <>
                        <button onClick={() => setHideComments(!hideComments)}>
                            Show Comments
                        </button>
                    </>
                ) : (
                    <>
                        {comments !== undefined && comments.length !== 0 ? (
                            comments
                        ) : (
                            <h3>be the first to comment...</h3>
                        )}
                        <button onClick={() => setHideComments(!hideComments)}>
                            Hide Comments
                        </button>
                    </>
                )}
                <hr />
                <AddComment handleAddComment={handleAddComment} />
            </div>
        </div>
    );
}
