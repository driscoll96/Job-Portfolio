import { useState } from 'react';
import ReactionContainer from '../Reaction/ReactionContainer'
import ShowCommentsContainer from '../Comments/ShowCommentsContainer';
import ShowTag from '../Tag/ShowTag'
import { Link } from 'react-router-dom'

export default function GiftDetails({ gift }) {

    const [comments, setComments] = useState([]);

    return (
        <div style={{ padding: '10px', border: '5px solid black', width: "60%", margin: 'auto' }}>
            <div style={{ display: 'flex', justifyContent: "space-around", width: '' }}>
                <h4>
                    <Link to={`/user/${gift.recipient.username}`}>{gift.recipient.username}</Link>
                    {' '}recieved {gift.amountGiven} Dropsy from {' '}
                    <Link to={`/user/${gift.gifter.username}`}>{gift.gifter.username}</Link>
                </h4>
            </div>
            <div>
                <p>{gift.message}</p>
                <ShowTag gift={gift} />
                <ReactionContainer gift={gift} type={"Gift"} />
                <ShowCommentsContainer gift={gift} comments={comments} setComments={setComments} />
            </div>
        </div>
    )
}