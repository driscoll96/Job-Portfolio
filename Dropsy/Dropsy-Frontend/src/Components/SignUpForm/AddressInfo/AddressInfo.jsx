import React from 'react';
import AuthPageTextInput from '../../AuthPageTextInput/AuthPageTextInput'

export default function AddressInfo({ validCountries, validStates, addressInfo, handleTextInput, handleSelectChange }) {

    return (
        <div>
            <AuthPageTextInput inputLabel={'street_Address'} inputValue={addressInfo.streetAddress} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'street_Address_2'} inputValue={addressInfo.streetAddress2} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'city'} inputValue={addressInfo.city} handleTextInput={handleTextInput} />
            <label htmlFor="country" aria-label="country input">
                Country:
                <select value={addressInfo.country} onChange={handleSelectChange} name='country'>
                    {validCountries}
                </select>
            </label>
            <br />
            <label htmlFor="state">
                State:
                <select value={addressInfo.state} onChange={handleSelectChange} name='state' aria-label="state input">
                    {validStates}
                </select>
            </label>
            <br />
            <AuthPageTextInput inputLabel={'zipcode'} inputValue={addressInfo.zipcode} handleTextInput={handleTextInput} />
            <AuthPageTextInput inputLabel={'phone'} inputValue={addressInfo.phone} handleTextInput={handleTextInput} />
        </div>
    );
}