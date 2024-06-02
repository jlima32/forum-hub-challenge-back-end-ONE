import './ListTopicComponent.css'


const ListTopicComponent = () => {
  

    const topicData = [
        {
            "id": 1,
            "título": "Tópico 01",
            "mensagem": "Teste 01"
        },
        {
            "id": 2,
            "título": "Tópico 02",
            "mensagem": "Teste 02"
        },
        {
            "id": 3,
            "título": "Tópico 03",
            "mensagem": "Teste 03"
        }
    ]


return (

    <div className="container">
        <div className="container-header">
            <div className="container-title">
                <h4>Tópicos</h4>
            </div>
                <a href="#" className="button-new-topic">Criar Tópico</a>
        </div>
    {
        topicData.map(topic =>

            <div className="container-content" key={topic.id}>
            <div className="topic-status solved">
                <i className="bx bxs-check-circle"></i>
            </div>
            <div className="topic-data">
                <div className="topic-title">
                    <h4><a href="">[Dúvida] Erro no Spring boot</a></h4>
                </div>
                <div className="topic-category-course">
                    <div className="topic-category-name programacao">Programação</div>
                    <div className="topic-course-name programacao">BDD e Java Spring Boot</div>
                </div>
                <div className="topic-author">
                    <p>criado por <span className="author-name">Juan Lima</span> (10 respostas)</p>
                </div>
            </div>
        </div>
        
        )
    }

    </div>
  )

}

export default ListTopicComponent