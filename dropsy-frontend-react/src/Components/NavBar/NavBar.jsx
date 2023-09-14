import React from 'react';
import { Link } from 'react-router-dom'
import SearchUsers from '../SearchUsers/SearchUsers'
import { userContext } from '../../App';

export default function NavBar({ handleGetOtherUserProfile, setUser }) {

    const linkStyle = {
        margin: '1rem',
        textDecoration: 'none',
        color: 'blue',
        padding: '1rem',
        border: '1px solid black'
    }

    return (
        <div style={{ width: '100%', height: '15vh', background: 'hsla(131,35%,70%,1)', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            <SearchUsers handleGetOtherUserProfile={handleGetOtherUserProfile} />
            <Link style={linkStyle} to='/dashboard'>Dashboard</Link> |
            <Link style={linkStyle} to='/purchase'>Puchase Dropsy</Link> |
            <Link style={linkStyle} to={`/profile/${userContext.value.username}`}>My Profile</Link> |
            <Link style={linkStyle} to={`/account/${userContext.value.username}`}>My Account</Link>
            <Link style={linkStyle} to={`/paymentmethod`}>Payment Method</Link>
            <Link style={linkStyle} to={`/updateaddress`}>Update Address</Link>
            <h1>{userContext.value.username}</h1>
            <button style={linkStyle} onClick={() => setUser(false)}>Logout</button>
        </div>
    );
}