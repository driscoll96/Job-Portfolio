// import axios from 'axios';
const stripe = require('stripe')('sk_test_51Iwdi8EswD21EFVl4g8KnaIIo5xkF6oj4usvmKcPFkv5dbv5dHp18HT8lM3N3VkAdKRcqstYprIXXi6EtQPfbmoU002eIH02jZ');
const { default: axios } = require('axios');
const { STRIPE_TEST_KEY } = require('./envconfig.js')

const stripeAuthHeader = {
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': `${STRIPE_TEST_KEY}`
}



// axios.post('https://api.stripe.com/v1/charges', null, 
//     {
//         params: a:'a0';
//     }
// )

// axios.post('/create-checkout-session', async (req, res) => {
//     const session = await stripe.checkout.sessions.create({
//         payment_method_types: ['card'],
//         line_items: [
//         {
//             price_data: {
//             currency: 'usd',
//             product_data: {
//                 name: 'Stubborn Attachments',
//                 images: ['https://i.imgur.com/EHyR2nP.png'],
//             },
//             unit_amount: 2000,
//             },
//             quantity: 1,
//         },
//         ],
//         mode: 'payment',
//         success_url: `${YOUR_DOMAIN}/success.html`,
//         cancel_url: `${YOUR_DOMAIN}/cancel.html`,
//     });

// }