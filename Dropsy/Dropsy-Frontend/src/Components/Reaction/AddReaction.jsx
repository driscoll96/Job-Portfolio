import React from 'react'
import * as ReactionApi from '../../Services/Api/reaction-api'
import { userContext } from '../../App'
import { reactionsContext } from '../../Pages/DashboardPage/DashboardPage'

export default function AddReaction({ addReaction, setAddReaction, gift, type, comment }) {

    const setReactionHelper = async (evt) => {
        let typeId = ''
        if (type === "Comment") {
            typeId = comment.commentId;
        }
        if (type === "Gift") {
            typeId = gift.giftId;
        }
        let giftReaction = {
            objectId: typeId,
            userId: userContext.value.userId,
            reactionObject: evt.target.name,
            reactionType: evt.target.value,
        }
        const hasAlreadyReacted = await ReactionApi.getAllReactionsForObject(type, typeId)
        const checkIfAlreadyReactedWithSameType = hasAlreadyReacted.filter((reaction, idx) => {
            return reaction.objectId === giftReaction.objectId && reaction.reactionType === giftReaction.reactionType && reaction.userId === userContext.value.userId
        })
        if (checkIfAlreadyReactedWithSameType.length <= 0) {
            const reaction = await ReactionApi.addReaction(giftReaction);
            setAddReaction(!addReaction)
        }
    }

    const reactionInputs = reactionsContext.value[1].value.map((reaction, idx) => {
        return <option key={`reaction-key-${type}-${idx}`} value={reaction}>{reaction}</option>
    })

    return (
        <div>
            Reactions
            <reactionsContext.Consumer>
                {(value) =>
                    <select onInput={setReactionHelper} name={type} id="reaction">
                        {reactionInputs}
                    </select>
                }
            </reactionsContext.Consumer>
        </div>
    );
}