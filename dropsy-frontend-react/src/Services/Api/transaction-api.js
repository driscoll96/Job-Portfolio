import axios from 'axios';
import { axiosRequest } from './send-request';

// const TRANSACTION_REST_API_URL = 'http://localhost:8080/transaction'
const TRANSACTION_REST_API_URL = 'transaction'


// @Request params:
// Int userId
// Int amount
// String stripeToken
// String description
// String transactionType

export async function addTransaction(transaction) {
        const transactionData = await axiosRequest(TRANSACTION_REST_API_URL + `/add`, transaction, "POST")
        return transactionData.data;
}

export async function getTransactionById(id) {
        const transactionData = await axios.get(TRANSACTION_REST_API_URL + `/get/${id}`);
        return transactionData.data;
};

