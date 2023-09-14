import React, { useState, useEffect } from 'react';
import * as ReactionApi from '../../Services/Api/reaction-api';
import * as UserApi from '../../Services/Api/user-api';
import { userContext } from '../../App';


export default function ShowReactions({ addReaction, gift, type, comment }) {

	const [reactions, setReactions] = useState([]);

	useEffect(() => {
		let typeId = '';
		if (type === "Comment") {
			typeId = comment.commentId;
		};
		if (type === "Gift") {
			typeId = gift.giftId;
		};

		const getReactions = async () => {
			return await ReactionApi.getAllReactionsForObject(type, typeId);
		};

		const getUserForReaction = async (id) => {
			return await UserApi.getUserById(id);
		};

		const attachUser = async () => {
			const reactions = await getReactions();
			let reactionsWithUsers = reactions.map(async (reaction, idx) => {
				const reactionator = await getUserForReaction(reaction.userId);
				reaction['user'] = reactionator;
				return reaction;
			});
			reactionsWithUsers = await Promise.all(reactionsWithUsers)
			reactionsWithUsers = reactionsWithUsers.map((reaction, idx) => {
				return (
					<div key={reaction.reactionId} style={{ border: '1px solid black' }}>
						<div
							id={reaction.reactionId}
							style={{ padding: '20px' }}
							key={`reaction-user-${reaction.user.username}-key-${idx}`}>
							{reaction.user.username} feels {reaction.reactionType}
						</div>

						{reaction.user.username === userContext.value.username
							?
							<button id={reaction.reactionId} onClick={deleteReaction}>delete</button>
							:
							''
						}
					</div>
				)
			});
			setReactions(reactionsWithUsers);
		}
		attachUser();
	}, [addReaction])

	const deleteReaction = async (evt) => {
		const deletedReaction = await ReactionApi.deleteReactionById(evt.target.id);
		console.log(deletedReaction);
		let newReactions = [...reactions].filter((reactionJSX, idx) => {
			return reactionJSX.key !== evt.target.id;
		})
		setReactions(newReactions)
	}

	return (
		<div>
			<div style={{ display: 'flex', justifyContent: 'center' }}>
				{reactions}
			</div>
		</div>
	)
}