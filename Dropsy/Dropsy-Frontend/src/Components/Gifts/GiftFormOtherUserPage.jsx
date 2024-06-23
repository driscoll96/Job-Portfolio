import { useState } from 'react';
import { userContext } from '../../App';
import { otherUserContext } from '../../Pages/OtherProfilePage/OtherProfilePage';
import TagContainer from '../../Components/Tag/TagContainer';
import * as giftApi from '../../Services/Api/gift-api';
import * as tagApi from '../../Services/Api/tag-api';

export default function GiftFormOtherUserPage() {

    const user = userContext.value;
    const otherUser = otherUserContext.value;
    const [gift, setGift] = useState(
        {
            gifterUserId: user.userId,
            recipientUserId: otherUser.userId,
            amountGiven: null,
            anonymous: false,
            message: ''
        }
    );
    const [tags, setTags] = useState([]);

    const attachTagsToNewGift = (newGift) => {
        if (tags.length) {
            tags.forEach(async (tag) => {
                tag[`giftId`] = newGift.giftId;
                await tagApi.addTag(tag)
            })
        }
    }

    const tagHandler = (tags) => {
        setTags(tags);
    }

    const sendGift = async (evt) => {
        evt.preventDefault();
        const newGift = await giftApi.addGift(gift);
        attachTagsToNewGift(newGift);
    }

    const setGiftData = (evt) => {
        setGift({ ...gift, [evt.target.name]: evt.target.value });
    }

    return (
        <div style={{ padding: '10px', border: '5px solid black', width: "60%", margin: 'auto' }}>
            <form>
                <label htmlFor="amount">Dropsy {otherUserContext.value.username}:
                    <input onChange={setGiftData} name="amountGiven" type="number" defaultValue="0"></input></label>
                <br />
                <label htmlFor="message">Message: </label>
                <input type="text" name="message" onChange={setGiftData} />
                <button onClick={(evt) => sendGift(evt)}>Give Gift</button>
                <TagContainer tagHandler={tagHandler} gift={gift} />
            </form>
        </div>
    )
}