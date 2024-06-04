import React, { useState, useEffect } from "react";
import "./TopicComponentForm.css";
import { createTopic, getCursos, getTopic, updateTopic } from "../services/TopicService";
import { useNavigate, useParams } from "react-router-dom";

const TopicComponent = () => {
  const {id} = useParams();
  const user = JSON.parse(localStorage.getItem("user"));
  const token = user.token;
  const navigator = useNavigate();


  const [prefixo, setPrefixo] = useState("");
  const [tituloSemPrefixo, setTituloSemPrefixo] = useState("");
  const [mensagem, setMensagem] = useState("");
  const [usuarioId] = useState(user.usuario.id);
  const [cursoId, setCursoId] = useState("");
  const [estadoTopico, setestadoTopico] = useState("");
  const [cursos, setCursos] = useState([]);

  useEffect(() => {
    
    if(id){
      getTopic(id, token).then((response) => {
        if(user.usuario.id !== response.data.autor.id){
          navigator("/");
        }
        setTituloSemPrefixo(response.data.titulo);
        setMensagem(response.data.mensagem);
      }).catch(error => {
        navigator("/");
        console.log(error);
      })
    }

  },[id,token])


  useEffect(() => {
    getCursos(token)
      .then((response) => {
        setCursos(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [token]);




  function saveOrUpdateTopic(e) {
    e.preventDefault();
    const titulo = `${prefixo} ${tituloSemPrefixo}`;
    const topic = { titulo, mensagem, usuarioId, cursoId, estadoTopico };

    if(id){
      updateTopic(id, token, topic).then((response) =>{
      })
    }else{
      createTopic(topic, token).then(() => {
      navigator("/");
    });
    }
  }

  function title(){
    if(id){
      return <h4>Editar Tópico</h4>
    }else{
      return <h4>Criar Tópico</h4>
    }
  }

  function isHidden(){
    if(id){
      return true;
    }
  }

  

  return (
    <section>
      <div className="container">
        <div className="container-header">
          <div className="container-title">
            {
              title()
            }
          </div>
        </div>

        <form onSubmit={saveOrUpdateTopic}>
          <div className="new-topic-content">
            <div className="form-new-topic">
              <select
                value={prefixo}
                name="prefix"
                id="prefixo"
                className="select-prefix"
                onChange={(e) => setPrefixo(e.target.value)}
              >
                <option value="">Prefixo</option>
                <option value="[Bug]">Bug</option>
                <option value="[Dúvida]">Dúvida</option>
                <option value="[Projeto]">Projeto</option>
                <option value="[Reclamação]">Reclamação</option>
                <option value="[Sugestão]">Sugestão</option>
              </select>
              <input
                type="text"
                id="titulo"
                name="titulo"
                value={tituloSemPrefixo}
                className="input-prefix"
                placeholder="Título do tópico"
                onChange={(e) => setTituloSemPrefixo(e.target.value)}
                required
              />
              {!isHidden() && (
                  <select 
                  value={cursoId}
                  name="course"
                  id="cursos"
                  className="select-course-name"
                  onChange={(e) => setCursoId(e.target.value)}
                  required
                  >
                  <option value="">Selecione um curso</option>
                  {cursos.map((curso) => (
                    <option key={curso.id} value={curso.id}>
                      {curso.nome}
                    </option>
                  ))}
                </select>
              )}
              <textarea
                name="mensagem"
                value={mensagem}
                id="mensagem"
                className="new-topic-textarea"
                rows="15"
                placeholder="Detalhes da dúvida"
                onChange={(e) => setMensagem(e.target.value)}
                required
              ></textarea>
              <select
                name="status"
                id="status"
                value={estadoTopico}
                onChange={(e) => setestadoTopico(e.target.value)}
                className="select-course-name"
                required
              >
                <option value="">Status do tópico</option>
                <option value="ABERTO">Aberto</option>
                <option value="RESOLVIDO">Resolvido</option>
              </select>
            </div>
            <div className="form-reply-button">
              <button type="submit" className="button-create-topic">
                Enviar
              </button>
            </div>
          </div>
        </form>
      </div>
    </section>
  );
};

export default TopicComponent;
