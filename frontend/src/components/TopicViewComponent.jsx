import React, { useEffect, useState } from 'react'
import './TopicViewComponent.css'
import { getTopic } from '../services/TopicService'
import { useParams } from 'react-router-dom'


const TopicViewComponent = () => {
    
const {id} = useParams();
const user = JSON.parse(localStorage.getItem("user"));
const token = user.token;
const [topic, setTopic] = useState(null);
const [loading, setLoading] = useState(true);


useEffect(() => {
    if(id){
        getTopic(id,token).then((response) =>{
            setTopic(response.data);
            setLoading(false);
        }).catch(error => {
            console.error(error);
            setLoading(false);
        })
    }
}, [id, token])


if(loading){
    return <p> carregando dados</p>
}

  return (
    <section>
         <div className="container">

            <div className="container-header">
                <div className="container-title">
                    <h4> {`Referente ao curso ${topic.curso.nome}`}</h4>
                </div>                
            </div> 

            <div className="container-topic-content">

                <div className="container-topic-content-header">
                    <i className='bx bx-message-rounded-detail'></i>
                    <div className="topic-content-header-details">
                        <div className="toip-title">
                            <h4>{topic.titulo}</h4>
                        </div>
                        <div className="topic-author">
                        <p>criado por <span className="author-name">{topic.autor.nome}</span> em {topic.dataCriacao}</p>
                        </div>
                    </div>
                </div>

                <div className="topic-message">
                <p>{topic.mensagem}</p>
                </div>

            </div>
            {
                topic.respostas && topic.respostas.map((resposta) => ( 

                    <div key={resposta.id} className="topic-message-response">
                <div className="topic-message-response-header">
                    <p><span className="author-name">{resposta.autor}</span> respondeu:</p>
                </div>
                <div className="topic-message-response-content">
                    <p>{resposta.mensagem}</p>
                </div>
                <div className="topic-message-response-date">
                    <p>em: <span className="author-name">{resposta.dataCriacao}</span></p>
                </div>
            </div>
                ))
            }

            <div className="topic-form-response">
                <div className="form-response-field">
                    <textarea className='form-response-text' rows="15" name="" id="" placeholder='O que você acaha disso? '></textarea>
                </div>
                <div className="form-reply-button">
                    <button className='button-reply'>Responder</button>
                </div>
            </div>

         </div>
    </section>
  )
}

export default TopicViewComponent