import axios from "axios"
let qs = require('qs')

//Eventually will need to swtich from localhost to actual url
//Eventually need to add the token or whatever authenticaton dealio we are using

export async function axiosRequest(urla, payload, type = "GET") {

    let qsPayload = '';


    if (payload && type === "POST") {
        qsPayload = qs.stringify(payload)
    }

    if (payload && type === "PUT") {
        qsPayload = qs.parse(payload)
    }

    const response = await axios({
        url: `http://localhost:3000/${urla}`,
        method: type,
        data: qsPayload
    })

    return response;
}