import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080';

const login = (email, senha) => {
    return axios.post(`${REST_API_BASE_URL}/login`, {
        email,
        senha
    })
}

export default { login };