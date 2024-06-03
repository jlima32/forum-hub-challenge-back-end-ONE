import React, { useState } from 'react'

const TopicComponent = () => {

    const [titulo, setTitulo] = useState('');
    const [mensagem, setMensagem] = useState('');
    const [usuarioId, setUsuarioId] = useState('');
    const [cursoId, setCursoId] = useState('');

  return (
    <section>
        <div className="container">
        
            <div className="container-header">
                <div className="container-title">
                    <h4>Criar Tópico</h4>
                </div>
            </div>

            <div className="new-topic-content">
                <div className="form-new-topic">
                    <select name="prefix" id="" className='select-prefix'>
                        <option value="">Prefixo</option>
                        <option value="">Bug</option>
                        <option value="">Projeto</option>
                        <option value="">Dúvida</option>
                    </select>
                    <input type="text" name='titulo' className='input-prefix' placeholder='Título do tópico' />
                    <select name="course" id="" className='select-course-name'>
                        <option value="1">PHP e PDO: trabalhando com bancos de dados</option>
                        <option value="2">Java: criando a sua primeira aplicação</option>
                        <option value="4">Redes: dos conceitos iniciais à criação de uma intranet</option>
                    </select>
                    <textarea name="" id="" className='new-topic-textarea' rows='15' placeholder='Detalhes da dúvida'></textarea>
                </div>
                <div className="form-reply-button">
                    <button className="button-create-topic">Criar Tópico</button>
                </div>



            </div>



        </div>
    </section>
  )
}

export default TopicComponent