import React, { useState } from 'react';
import AddReaction from './AddReaction'
import ShowReactions from './ShowReactions'

export default function ReactionContainer({ user, gift, type, comment }) {

    const [addReaction, setAddReaction] = useState(false);
    const [showReaction, setShowReaction] = useState(false);

    return (
        <>
            {type === 'Gift'
                ?
                <>
                    <AddReaction addReaction={addReaction} setAddReaction={setAddReaction} gift={gift} type={"Gift"} />
                    {showReaction ? <ShowReactions addReaction={addReaction} gift={gift} type={"Gift"} /> : ''}
                    {showReaction ?
                        <button onClick={() => setShowReaction(!showReaction)}> Hide Reactions </button>
                        :
                        <button onClick={() => setShowReaction(!showReaction)}> Show Reactions </button>}
                </>
                :
                <>
                    <AddReaction addReaction={addReaction} setAddReaction={setAddReaction} user={user} gift={gift} comment={comment} type={'Comment'} />
                    {showReaction ? <ShowReactions addReaction={addReaction} user={user} type={comment} gift={gift} comment={comment} type={'Comment'} /> : ''}
                    {showReaction ?
                        <button onClick={() => setShowReaction(!showReaction)}> Hide Reactions </button>
                        :
                        <button onClick={() => setShowReaction(!showReaction)}> Show Reactions </button>}
                </>
            }
        </>
    )
};