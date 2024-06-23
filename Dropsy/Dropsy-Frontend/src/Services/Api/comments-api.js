import axios from 'axios';
import { axiosRequest } from './send-request';
import parseIntHelper from '../parseIntHelper';

const COMMENT_REST_API_URL = 'http://localhost:8080/comment'
const COMMENT_REST_API_URL_MOD = 'comment';

export async function addComment(messageObj) {
    const comment = await axios.post(COMMENT_REST_API_URL + `/add`, null,
        {
            params: {
                userId: messageObj.userId,
                giftId: messageObj.giftId,
                message: messageObj.message,
            }
        }
    )
    return parseIntHelper(comment.data);
}

export async function getCommentById(commentId) {
    const comment = await axios.get(COMMENT_REST_API_URL + `/get/${commentId}`);
    return comment.data;
}

export async function getAllCommentsFromGiftId(giftId) {
    const comments = await axios.get(COMMENT_REST_API_URL + `/get/all/${giftId}`);
    return comments.data;
}

export async function deleteCommentById(id) {
    let reaction = await axiosRequest(COMMENT_REST_API_URL_MOD + `/delete/${id}`, id, 'DELETE');
    return reaction.data;
}

export async function updateCommentById(comment, id) {
    let commentData = await axiosRequest(COMMENT_REST_API_URL_MOD + `/update/${id}`, comment, 'PUT')
    return commentData.data;
}