import axios from 'axios';

const GET_BY_USERNAME_URL = 'http://localhost:8080/user/username/get/'

const resources = {};

const makeRequestCreator = () => {
    let cancel;

    return async query => {
        if (cancel) {
            cancel.cancel();
        }
        cancel = axios.CancelToken.source();
        try {
            if (resources[GET_BY_USERNAME_URL + `${query}`]) {
                return resources[GET_BY_USERNAME_URL + `${query}`];
            }
            const res = await axios(GET_BY_USERNAME_URL + `${query}`, { cancelToken: cancel.token });
            console.log('I RAN');
            const result = res.data;
            resources[GET_BY_USERNAME_URL + `${query}`] = result;

            return result;
        } catch (error) {
            if (axios.isCancel(error)) {
                console.log('Request canceled', error.message);
            } else {
                console.log('Something went wrong: ', error.message);
            }
        }
    };
};

export const search = makeRequestCreator()