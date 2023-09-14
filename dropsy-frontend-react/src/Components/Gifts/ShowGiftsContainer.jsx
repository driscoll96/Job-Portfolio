import React, { useState, useEffect } from 'react';
import GiftDetails from './GiftDetails'

export default function ShowGiftsContainer({ gifts, handleGetOtherUserProfile }) {

    const [showGifts, setShowGifts] = useState([]);

    useEffect(() => {
        let showGift = []
        if (gifts.length !== 0) {
            gifts.forEach((gift, idx) => {
                showGift.unshift(
                    <GiftDetails
                        handleGetOtherUserProfile={handleGetOtherUserProfile}
                        key={`gift-details-${idx}`}
                        gift={gift}
                    />
                )
            })
        }
        setShowGifts(showGift);
    }, [gifts])

    return (
        <>
            <div style={{ border: '1px solid black' }}>
                {showGifts.length !== 0 ? showGifts : 'No Gifts to speak of, time to give!'}
            </div>
        </>
    )
};