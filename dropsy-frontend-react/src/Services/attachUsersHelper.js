import * as UserService from './Api/user-api'

export default async function attachUsersHelper(object) {
    const user = await UserService.getUserById(object.userId);
    object['user'] = user;
    return object;
}