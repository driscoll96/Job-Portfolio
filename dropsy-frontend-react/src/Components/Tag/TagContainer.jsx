import React, { useState } from 'react'
import { userContext } from '../../App';
import * as tagApi from '../../Services/Api/tag-api'
import AddTag from './AddTag'

export default function TagContainer({ tagHandler, gift }) {


    let tagJsx = [];
    const user = userContext.value;
    const [tags, setTags] = useState([]);
    const [newTag, setNewTag] = useState('')
    const [newTagData, setNewTagData] = useState({
        userId: user.userId,
        giftId: '',
        tagName: '',
        updateTag: false,
    });
    let mappedTags = [];
    const tagUpdate = useState(false);

    const getAllTagsByGiftId = async (id) => {
        const getTags = await tagApi.getAllTagsByGiftId(id);
        setTags(getTags);
    }

    // If there are existing tags, get all of them and set newTags giftid to current gift
    if (gift.giftId !== undefined) {
        const giftId = getAllTagsByGiftId(gift.giftId);
        setNewTag.giftId = giftId;
    }

    const deleteLocalTag = (evt) => {
        evt.preventDefault();
        let tagsArray = [...tags]
        tagsArray = tagsArray.filter((t) => {
            console.log(t);
            return evt.target.value !== t.tagName;
        })
        tagHandler(tagsArray)
        setTags(tagsArray)
    }

    const handleAddTag = (tag) => {
        if (!tags.some((t) => {
            return t.tagName === tag.tagName || tag.tagName === ""
        })) {
            tagHandler([...tags, tag]);
            setTags([...tags, tag]);
        }
        if (tag.tagName === '' && tags.length === 0) {
            tagHandler([...tags, tag]);
            setTags([...tags, tag]);
        }
    };

    const updateLocalTag = (evt) => {

        const setUpdateTag = (tag) => {
            const tagsWithUpdatedTag = [...tags]
        }

        evt.preventDefault();
        mappedTags = mappedTags.map((tag) => {
            console.log(tag)
            if (`${evt.target.value}-for-${gift.giftId}-from-${user.userId}` === tag.key) {
                return (
                    <div>
                        <input type="text"></input>
                        <button>Update</button>
                        <button onClick={() => mapTags()}>Cancel</button>
                    </div>
                )
            }
        })
        return mappedTags
    }

    const mapTags = (tags) => {
        mappedTags = tags.map((tag) => {
            if (tag.updateTag) {
                setNewTagData({ ...tag, updateTag: false });
                return (
                    <div key={`${tag.tagName}-for-${gift.giftId}-from-${user.userId}`}>
                        <input onChange={(evt) => setNewTag(evt.target.value)} type="text"></input>
                        <button>Update</button>
                        <button onClick={() => tag.tagName = newTag}>Cancel</button>
                    </div>
                )
            }
            return (
                <div key={`${tag.tagName}-for-${gift.giftId}-from-${user.userId}`}>
                    <h4>{tag.tagName}</h4>
                    <button value={tag.tagName} onClick={deleteLocalTag} >Delete</button>
                    <button value={tag.tagName} onClick={(evt) => {
                        evt.preventDefault();
                        setNewTagData({ ...tag, updateTag: true });
                        mapTags(tags);
                    }} >Update</button>
                </div>
            )
        })
        return mappedTags;
    }

    return (
        <div>
            {mapTags(tags)}
            <AddTag handleAddTag={handleAddTag} />
        </div>
    );
};