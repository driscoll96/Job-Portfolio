import React from 'react'
import { useState } from 'react'
import AuthPageTextInput from '../AuthPageTextInput/AuthPageTextInput'

export default function LoginForm() {

    const [credentials, setCredentials] = useState({
        email: "",
        password: "",
    })

    const handleTextInput = (evt) => {
        const { ...newCredentials } = credentials;
        newCredentials[evt.target.name] = evt.target.value;
        setCredentials(newCredentials);
    };

    const loginUser = (evt) => {
        evt.preventDefault();
        //Here we will call userservice.login
    }

    return (
        <div>
            <form>
                <AuthPageTextInput inputLabel={'email'} inputValue={credentials.email} handleTextInput={handleTextInput} />
                <AuthPageTextInput inputLabel={'password'} inputValue={credentials.password} handleTextInput={handleTextInput} />
                <button onClick={loginUser}>Login</button>
            </form>
        </div>
    );
}