import React, {useEffect, useState} from 'react'

import './ListTopicComponent.css'
import { listTopics } from '../services/TopicService'


const ListTopicComponent = () => {
  
    const [topics, setTopics] = useState([])

    useEffect(() => {
        listTopics().then((response) => {
            setTopics(response.data);
        }).catch(error => {
            console.error(error);
        })

    }, [])


return (

    <div className="container">
        <div className="container-header">
            <div className="container-title">
                <h4>Tópicos</h4>
            </div>
                <a href="#" className="button-new-topic">Criar Tópico</a>
        </div>
    {
        topics.map((topic) =>

            <div className="container-content" key={topic.id}>
            <div className="topic-status solved">

                <i className="bx bxs-check-circle"></i>
            </div>
            <div className="topic-data">
                <div className="topic-title">
                    <h4><a href="">{topic.titulo}</a></h4>
                </div>
                <div className="topic-category-course">
                    <div className={`topic-category-name programacao ${(topic.curso.categoria).toLowerCase()}`}>{topic.curso.categoria}</div>
                    <div className={`topic-course-name programacao ${(topic.curso.categoria).toLowerCase()}`}>{topic.curso.nome}</div>
                </div>
                <div className="topic-author">
                    <p>criado por <span className="author-name">{topic.autor.nome}</span> {`(${(topic.respostas).length} respostas)`}</p>
                </div>
            </div>
        </div>
        
        )
    }

    </div>
  )

}

export default ListTopicComponent