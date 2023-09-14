import axios from 'axios'

const BASE_URL = 'http://localhost:3000/'

export async function getEnumObjects(url) {
	const addressForm = await axios.get(BASE_URL + `${url}`);
	await console.table('userServicePage: ', addressForm);
	const enums = addressForm.data.alps.descriptor[0].descriptor.filter((fieldObject) => {
		if (fieldObject['doc']) {
			return fieldObject;
		};
	});
	return enums;
};

export async function getEnumKeysAndValues(url) {
	const enums = await getEnumObjects(url);
	return enums.map((enumValues) => {
		return { 'key': enumValues['name'], 'value': enumValues['doc']['value'] }
	})
}