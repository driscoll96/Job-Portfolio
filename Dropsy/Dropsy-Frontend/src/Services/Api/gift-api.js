import axios from 'axios'

const GIFT_REST_API_URL = 'http://localhost:8080/gift'

export async function addGift(giftObj) {
    const gift = await axios.post(GIFT_REST_API_URL + `/add`, null,
        {
            params: {
                gifterUserId: giftObj.gifterUserId,
                recipientUserId: giftObj.recipientUserId,
                amountGiven: giftObj.amountGiven,
                anonymous: giftObj.anonymous,
                message: giftObj.message,
            }
        }
    );
    console.log(gift);
    return gift.data;
}

export async function getGiftById(id) {
    const gift = await axios.get(GIFT_REST_API_URL + `/get/${id}`);
    return gift.data;
}

export async function getAllGiftsByUserId(id) {
    const gifts = await axios.get(GIFT_REST_API_URL + `/get/all/${id}`);
    return gifts.data;
}

export async function getAllGivenGiftsByUserId(id) {
    const gifts = await axios.get(GIFT_REST_API_URL + `/get/given/${id}`);
    return gifts.data;
}

export async function getAllRecievedGiftsByUserId(id) {
    const gifts = await axios.get(GIFT_REST_API_URL + `/get/recieved/${id}`);
    return gifts.data;
}