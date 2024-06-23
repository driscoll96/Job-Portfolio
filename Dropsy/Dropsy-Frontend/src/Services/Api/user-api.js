import axios from "axios";

const USERS_REST_API_URL = "http://localhost:8080/user/";

export async function getAllUsers() {
	const users = await axios.get(USERS_REST_API_URL + `get/all`);
	console.table("userServicePage: ", users.data);
	return users.data;
}

export async function createUser(userData) {
	const user = await axios.post(USERS_REST_API_URL + `add`, null,
		{
			// params: {
			//         coinBalance: 0,
			//         firstName: userData.firstname,
			//         lastName: userData.lastname,
			//         username: userData.username,
			//         email: userData.email,
			//         password: userData.password,
			// }
			params: { ...userData }
		}
	);
	return console.log(user.data)
}

export async function getUserById(id) {
	const user = await axios.get(USERS_REST_API_URL + `get/${id}`);
	return user.data;
}

// export async function axiosRequest(url, payload, type="GET") {
//         const response = await axios({
//             url: `http://localhost:8080/${USER_URL}/${url}`,
//             method: type,
//             data: {
//                 params:{payload}
//             }
//         })
//         console.log('hnggg')
//         console.log(response)
//         console.log(response.data)
//         return response.data;
//     }