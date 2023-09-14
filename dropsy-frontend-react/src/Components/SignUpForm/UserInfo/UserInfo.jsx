import React from 'react'
import AuthPageTextInput from '../../AuthPageTextInput/AuthPageTextInput'

export default function UserInfo({ credentials, handleTextInput }) {

    return (
        <div>
            <AuthPageTextInput inputLabel={'first_Name'} inputValue={credentials.firstName} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'last_Name'} inputValue={credentials.lastName} last handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'username'} inputValue={credentials.userName} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'email'} inputValue={credentials.email} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'confirm_Email'} inputValue={credentials.confirmEmail} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'password'} inputValue={credentials.password} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'confirm_Password'} inputValue={credentials.confirmPassword} handleTextInput={handleTextInput} />
        </div>
    );
}