import React, {useState, useEffect} from 'react'
import { userContext } from '../../App';

export default function AddTag({gift, handleAddTag}) {

    const user = userContext.value;
    const [tag, setTag] = useState({
        userId:user.userId,
        giftId:'',
        tagName:'',
    });

    useEffect(() => {
        console.log(gift)
    },[gift]);

    const addTag = (evt) => {
        evt.preventDefault();
        if(evt.target.value !== '') {
            handleAddTag(tag);  
        }
    }

    return (
        <div>
            <input name='tagName' placeholder={'add tag...'} onChange={(evt) => setTag({...tag, [evt.target.name]: evt.target.value})} value={tag.tagName} type="text" />
            <button value={tag.tagName} onClick={(evt) => addTag(evt)}>Add Tag</button>
        </div>
    );
}
