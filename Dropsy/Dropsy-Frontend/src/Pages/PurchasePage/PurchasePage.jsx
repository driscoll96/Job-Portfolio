import React, { useState } from 'react';
import { userContext } from '../../App';

export default function PurchasePage() {

    const user = userContext.value;
    const [transaction, setTransaction] = useState({
        user: user.userId,
        currencyType: 'USD',
        stripeToken: '',
        description: '',
        transactionType: '',
    });

    const submitTransaction = async () => {
    }

    return (
        <div>
            <div>Purchase Dropsy</div>
            <label>Amount:<input value={(evt) => setTransaction({'amount':evt.target.value})} type="number" /></label>
            <label>Currency:</label>
            <select>
                <option value="USD">USD</option>
                <option value="EUR">EUR</option>
            </select>
            <button>Add Dropsy</button>
        </div>
    );
}

