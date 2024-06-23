import { axiosRequest } from './send-request';


const ADDRESS_REST_API_URL = 'address';

export async function addAddress(addressInfo) {
    const addressData = await axiosRequest(ADDRESS_REST_API_URL + '/add', addressInfo, "POST")
    return addressData;
};