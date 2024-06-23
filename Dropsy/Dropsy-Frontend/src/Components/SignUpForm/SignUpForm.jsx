import React, { useEffect } from "react";
import { useState } from "react";
import UserInfo from './UserInfo/UserInfo'
import AddressInfo from './AddressInfo/AddressInfo'
import * as SignUpService from "../../Services/EnumService"
import * as UserService from "../../Services/Api/user-api"

export default function SignUpForm({ setUser }) {
    const [credentials, setCredentials] = useState({
        firstName: '',
        lastName: '',
        username: '',
        email: '',
        confirmEmail: '',
        password: '',
        confirmPassword: '',
        coinBalance: 100,
    });

    const [addressInfo, setAddressInfo] = useState({
        country: '',
        streetAddress: '',
        streetAddress2: '',
        city: '',
        state: '',
        zipcode: '',
        phone: '',
    });

    const [validStates, setValidStates] = useState();
    const [validCountries, setValidCountries] = useState();

    useEffect(() => {

        const getEnumValues = async () => {

            //Populate the Enum Fields with valid inputs
            const enumKeysAndValues = await SignUpService.getEnumKeysAndValues('/profile/addresses')
            let validStateList = enumKeysAndValues[0].value.split(', ')
            let validCountryList = enumKeysAndValues[1].value.split(', ')
            const setSelectTagForEnumFields = (enumObject) => {
                return enumObject.map((value, idx) => {
                    if (value.indexOf('_') !== -1) {
                        value = value.replace('_', ' ')
                    }
                    return <option value={value} id={value} key={idx}>{value}</option>
                })
            }
            setValidStates(setSelectTagForEnumFields(validStateList));
            setValidCountries(setSelectTagForEnumFields(validCountryList));
        }
        getEnumValues();

    }, [])

    const [err, setErr] = useState(null);

    const handleTextInput = (evt) => {
        if (evt.target.name in credentials) {
            setCredentials({ ...credentials, [evt.target.name]: evt.target.value });
        };
        if (evt.target.name in addressInfo) {
            setAddressInfo({ ...addressInfo, [evt.target.name]: evt.target.value });
        };
    };

    const handleSelectChange = (evt) => {
        setAddressInfo({ ...addressInfo, [evt.target.name]: evt.target.value });
    }

    const handleSubmit = (evt) => {
        evt.preventDefault();
        if (credentials.password !== credentials.confirmPassword) {
            setErr('Passwords do not match. Try again');
        } if (credentials.email !== credentials.confirmEmail) {
            setErr('Emails do not match. Try again');
        } else {
            const { ...submitCredentials } = credentials;
            const { ...submitAddress } = addressInfo;
            delete submitCredentials.confirmEmail;
            delete submitCredentials.confirmPassword;
            UserService.createUser(submitCredentials)
        }
    };

    return (
        <div>
            SignUpForm
            <form autoComplete="off">
                <UserInfo credentials={credentials} handleTextInput={handleTextInput} />
                <h1> Where are you in this world? </h1>
                <AddressInfo handleSelectChange={handleSelectChange} validCountries={validCountries} validStates={validStates} addressInfo={addressInfo} handleTextInput={handleTextInput} />
                <button onClick={handleSubmit}>Submit</button>
                {err ?
                    <h2>{err}</h2>
                    :
                    <></>
                }
            </form>
        </div>
    );
}
