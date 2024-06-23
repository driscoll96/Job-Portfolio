import { axiosRequest } from './send-request'

const URL = 'tag'

export async function addTag(tagObject) {
    const tags = await axiosRequest(URL + '/add', tagObject, "POST");
    return tags.data;
}

export async function updateTagById(tagObject, id) {
    const updatedTag = await axiosRequest(URL + `/update/${id}`, tagObject, "PUT");
    return updatedTag.data;
}

export async function getAllTags() {
    const tag = await axiosRequest(URL + `/get/all`);
    return tag.data;
}

export async function getTagById(id) {
    const tag = await axiosRequest(URL + `/get/${id}`);
    return tag.data;
}

export async function getAllTagsByGiftId(id) {
    const tags = await axiosRequest(URL + `/get/all/${id}`);
    return tags.data;
}

export async function deleteTagById(id) {
    const deletedTagData = await axiosRequest(URL + `/delete/${id}`, null, "DELETE");
    return deletedTagData.data
}
