const dotenv = require('dotenv');
dotenv.config();
module.exports = {
    STRIPE_TEST_KEY: process.env.STRIPE_TEST_KEY,
};