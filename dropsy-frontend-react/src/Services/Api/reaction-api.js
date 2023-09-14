import axios from 'axios'
import { axiosRequest } from './send-request'
import attachUsersHelper from '../attachUsersHelper'

const REACTION_REST_API_URL = 'reaction'

export async function addReaction(reactionObject) {
    const reaction = await axiosRequest(REACTION_REST_API_URL + `/add`, reactionObject, 'POST');
    return reaction;
}

export async function getReactionById(id) {
    let reaction = await axios.get(REACTION_REST_API_URL + `/get/${id}`);
    reaction = await attachUsersHelper(reaction);
    return reaction.data;
}

export async function getAllReactionsForObject(type, id) {
    const reactions = await axiosRequest(REACTION_REST_API_URL + `/get/all/${type}/${id}/`);
    return reactions.data;
}

export async function deleteReactionById(id) {
    let reaction = await axiosRequest(REACTION_REST_API_URL + `/delete/${id}`, id, 'DELETE');
    return reaction.data;
}