import { useEffect, useState } from 'react';
import { search } from '../../Services/Api/search-api'
import { Link } from 'react-router-dom'
import { userContext } from '../../App';

export default function SearchUsers({ handleGetOtherUserProfile }) {

    const [matchedUsers, setMatchedUsers] = useState([]);
    const [searchQuery, setSearchQuery] = useState('');

    useEffect(() => {
        const asyncSearch = async () => {
            if (searchQuery !== '') {
                await userSearch(searchQuery);
            } else {
                setMatchedUsers([]);
            };
        };
        asyncSearch();
    }, [searchQuery])

    const renderUsers = (userArray) => {
        if (userArray !== 0) {
            let showMatchedUsers = userArray.map((user) => {
                if (user.username === userContext.value.username) {
                    return (
                        <button onClick={(evt) => handleGetOtherUserProfile(evt, user)} value={user}>
                            <Link to={`/profile/${user.username}`}>{user.username}</Link>
                        </button>
                    )
                }
                return (
                    <button onClick={(evt) => handleGetOtherUserProfile(evt, user)} value={user}>
                        <Link to={`/user/${user.username}`}>{user.username}</Link>
                    </button>
                )
            });
            setMatchedUsers(showMatchedUsers);
        }
    }

    const userSearch = async () => {
        const res = await search(searchQuery);
        if (res) renderUsers(res);
    };

    const onChangeHandler = async evt => {
        setSearchQuery(evt.target.value);
    };

    return (
        <>
            <input value={searchQuery} onChange={onChangeHandler} placeholder={'Search Dropsy'} type="text" />
            <ul>
                {matchedUsers && matchedUsers.length !== 0 ? matchedUsers : ''}
            </ul>
        </>
    )
}
