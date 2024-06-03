import React, { useState, useEffect } from "react";
import "./TopicComponentForm.css";
import { createTopic, getCursos } from "../services/TopicService";
import { useNavigate } from "react-router-dom";

const TopicComponent = () => {
  const user = JSON.parse(localStorage.getItem("user"));
  const token = user.token;
  const navigator = useNavigate();


  const [prefixo, setPrefixo] = useState("");
  const [tituloSemPrefixo, setTituloSemPrefixo] = useState("");
  const [mensagem, setMensagem] = useState("");
  const [usuarioId] = useState(user.usuario.id);
  const [cursoId, setCursoId] = useState("");
  const [cursos, setCursos] = useState([]);

  useEffect(() => {
    getCursos(token)
      .then((response) => {
        setCursos(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [token]);


  function saveTopic(e) {
    e.preventDefault();
    const titulo = `${prefixo} ${tituloSemPrefixo}`;
    const topic = { titulo, mensagem, usuarioId, cursoId };
    createTopic(topic, token).then(() => {
      navigator("/");
    });
  }

  return (
    <section>
      <div className="container">
        <div className="container-header">
          <div className="container-title">
            <h4>Criar Tópico</h4>
          </div>
        </div>

        <form onSubmit={saveTopic}>
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
            </div>
            <div className="form-reply-button">
              <button type="submit" className="button-create-topic">
                Criar Tópico
              </button>
            </div>
          </div>
        </form>
      </div>
    </section>
  );
};

export default TopicComponent;
