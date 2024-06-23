import React, { useState } from "react";
import { userContext } from "../../App";

export default function AddComment({ handleAddComment }) {
    const [comment, setComment] = useState("");

    //Sends new comment up to ShowCommentContainer, erases comment input for future comments
    const sendComment = () => {
        if (comment === "") return;
        handleAddComment(comment);
        setComment("");
    };

    return (
        <div>
            <div>
                <textarea
                    onChange={(evt) => setComment(evt.target.value)}
                    value={comment}
                    type="text"
                    placeholder="comment here"
                />
            </div>
            <button onClick={sendComment}>Comment</button>
        </div>
    );
}
