import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080';

export const listTopics = () => {
    return axios.get(`${REST_API_BASE_URL}/topicos`, )
}



export const getCursos = (token) => axios.get(`${REST_API_BASE_URL}/cursos`, {
    headers: {
        'Authorization': `Bearer ${token}`,
    }
  });

export const createTopic = (topic, token) => axios.post(`${REST_API_BASE_URL}/topicos`, topic,  {
    headers: {
        'Authorization': `Bearer ${token}`,
    }
  });

