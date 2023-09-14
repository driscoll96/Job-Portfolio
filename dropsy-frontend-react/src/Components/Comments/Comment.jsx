import React, { useState } from 'react'
import { userContext } from '../../App'
import ReactionContainer from '../Reaction/ReactionContainer'

export default function Comment({gift , user, comment, handleDeleteComment, handleUpdateComment}) {

	const [updateComment, setUpdateComment] = useState(false);
	const [newComment, setNewComment] = useState(comment.message);

	const passDeleteEvent = (evt) => {
		console.log(evt)
		handleDeleteComment(evt.target.id)
	}

	const updateCommentHandler = () => {
		comment.message = newComment;
		handleUpdateComment(comment, comment.commentId);
		setUpdateComment(false)
	}

	return (
		<div style={{border:'1px solid black'}}>
			<h3>{user.username}</h3>
			{updateComment ?
				<> 
				<input value={newComment} onChange={(evt) => setNewComment(evt.target.value)}></input>
				<button onClick={updateCommentHandler}>Update</button>
				<button onClick={() => setUpdateComment(false)}>Cancel</button>
				</>
			:
				<>
				<p>{comment.message}</p>
				{userContext.value.userId === comment.userId ?
					<button onClick={() => setUpdateComment(true)}>Edit</button> 
				:
					<></> 
				}
			</>
			}
			<ReactionContainer user={user} gift={gift} comment={comment} type={'Comment'} />
			{userContext.value.userId === comment.userId ? <button id={comment.commentId} onClick={passDeleteEvent}>DELETE</button> : '' }
		</div>
	);
}
