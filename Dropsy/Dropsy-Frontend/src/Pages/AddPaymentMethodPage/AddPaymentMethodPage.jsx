import React, { useState } from 'react'
import { userContext } from '../../App';

export default function AddPaymentMethodPage() {

    const [paymentMethod, setPaymentMethod] = useState({
        userId: userContext.value.userId,
        paymentCardToken: '',
        paymentEmail: '',
        Address: {},
        phone: 0,

    });
    const [paymentMethodType, setPaymentMethodType] = useState('card');

    return (
        <div>
            Add Payment Method:
            {paymentMethodType === 'card' ?
                <>
                    <button onClick={() => setPaymentMethodType('bank')}>Add Bank Information</button>
                    <h1>Your Card Information</h1>
                    <label>Email:<input type="text" /></label>
                    <label>Phone:<input type="tel" /></label>
                    <br />
                </>
                :
                <>
                    <button onClick={() => setPaymentMethodType('card')}>Add Card Information</button>
                    <h1>Your Bank Information</h1>
                    <label>Email:<input type="text" /></label>
                    <label>Phone:<input type="tel" /></label>
                    <br />
                </>

            }
        </div>
    );
}