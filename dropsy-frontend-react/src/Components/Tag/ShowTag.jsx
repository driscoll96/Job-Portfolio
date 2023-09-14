import React, { useState, useEffect } from 'react'
import * as tagApi from '../../Services/Api/tag-api'

export default function ShowTag({ gift }) {

    const [tags, setTags] = useState([]);

    useEffect(() => {
        const getAllTagsByGiftId = async () => {
            const tags = await tagApi.getAllTagsByGiftId(gift.giftId);
            setTags(tags);
        }
        getAllTagsByGiftId();
    }, [])

    return (
        <div>
            {tags.length !== 0 ?
                <>
                    {tags.map((tag) => {
                        return (
                            <div style={{ background: 'black', color: "white" }}>
                                <h4>{tag.tagName}</h4>
                            </div>
                        )
                    })}
                </>
                :
                <>
                </>
            }
        </div>
    );
}