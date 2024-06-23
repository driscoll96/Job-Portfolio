import React, { useEffect, useState } from 'react'
import { userContext } from '../../App';
import AddressInfo from '../../Components/SignUpForm/AddressInfo/AddressInfo'
import * as SignUpService from "../../Services/EnumService"
import * as addressApi from "../../Services/Api/address-api"

export default function AddAddressPage() {

    const [addressInfo, setAddressInfo] = useState({
        country: 'US',
        streetAddress: '',
        streetAddress2: '',
        city: '',
        state: 'WA',
        zipcode: '',
        phone: '',
        userId: userContext.value.userId
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

    const handleTextInput = (evt) => {
        if (evt.target.name in addressInfo) {
            setAddressInfo({ ...addressInfo, [evt.target.name]: evt.target.value });
        };
    };

    const handleSelectChange = (evt) => {
        setAddressInfo({ ...addressInfo, [evt.target.name]: evt.target.value })
    }

    const handleAddAddress = async () => {
        const address = await addressApi.addAddress(addressInfo)
    }

    return (
        <div>
            <AddressInfo handleSelectChange={handleSelectChange} validCountries={validCountries} validStates={validStates} addressInfo={addressInfo} handleTextInput={handleTextInput} />
            <button onClick={handleAddAddress}>Update Address</button>
        </div>
    );
}