import React, { useState, useEffect } from 'react';
import * as UserService from '../../Services/Api/user-api';
import * as GiftService from '../../Services/Api/gift-api';
import TagContainer from '../Tag/TagContainer';

export default function GiftFormDashboard({ user, setUpdateAfterSendGift }) {

    const [gift, setGift] = useState(
        {
            gifterUserId: null,
            recipientUserId: null,
            amountGiven: null,
            anonymous: false,
            message: ''
        }
    );

    //This sets state for all the users from the db. Just a fake 'search' for the time being.
    const [allUsers, setAllUsers] = useState([]);
    const [giftSent, setGiftSent] = useState(false);
    const [tag, setTag] = useState({});

    useEffect(() => {
        setGift({ ...gift, gifterUserId: user.userId })
        const setUsersInDataList = async () => {
            const getOtherUsers = await UserService.getAllUsers();
            const userOptions = getOtherUsers.map((users, idx) => {
                if (user.userId !== users.userId) {
                    return (
                        <option
                            id={users.userId}
                            key={`gift-option-${users.userId}-${gift.giftId}-${idx}`}
                            value={users.userId}>
                            {users.username}
                        </option>
                    )
                } else {
                    return '';
                }
            })
            setAllUsers(userOptions);
        }
        setUsersInDataList();
    }, [giftSent]);

    const setGiftData = (evt) => {
        setGift({ ...gift, [evt.target.name]: evt.target.value });
    }

    const sendGift = async (evt) => {
        evt.preventDefault();
        const sendGift = await GiftService.addGift(gift);
        setUpdateAfterSendGift(true);
    };

    const tagHandler = () => {
        return
    }

    return (
        <div style={{ border: '1px solid black', padding: '15px' }}>
            <h3>Dropsy</h3>
            <form>
                <label htmlFor="amount">Dropsy Amount: <input onChange={setGiftData} name="amountGiven" type="number" defaultValue="0"></input></label>
                <br />
                <label htmlFor="gift">Who Do You Want to send a gift to?
                    <input list="otherUsers" name="recipientUserId" list="otherUsers" onChange={setGiftData} />
                    <datalist id="otherUsers">
                        {allUsers}
                    </datalist>
                </label>
                <label>Message:</label>
                <input type="text" name="message" onChange={setGiftData} />
                <TagContainer tagHandler={tagHandler} gift={gift} />
                <button onClick={sendGift}>Give Gift</button>
            </form>
        </div>
    )
};