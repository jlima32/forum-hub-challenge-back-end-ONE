import React, { useEffect, useState } from "react";
import "./TopicViewComponent.css";
import { createReply, getTopic } from "../services/TopicService";
import { useParams } from "react-router-dom";
import { useNavigate } from "react-router-dom";

const TopicViewComponent = () => {
  const navigator = useNavigate();

  const { id } = useParams();
  const user = JSON.parse(localStorage.getItem("user"));
  const token = user.token;
  const [topic, setTopic] = useState(null);
  const [loading, setLoading] = useState(true);
  const [mensagem, setMensagem] = useState("");
  const [topicoId, setTopicoId] = useState("");
  const [usuarioId] = useState(user.usuario.id);
  const [solucao] = useState(0);

  useEffect(() => {
    if (id) {
      getTopic(id, token)
        .then((response) => {
          setTopic(response.data);
          setLoading(false);
        })
        .catch(() => {
          setLoading(false);
        });
    }
  }, [id, token, navigator]);

  function saveReply(e) {
    e.preventDefault();
    const reply = { mensagem, topicoId, usuarioId, solucao };
    createReply(reply, token);
    window.location.reload();
  }

  function updateTopic(id) {
    navigator(`/update-topic/${id}`);
  }

  if (loading) {
    return <p>...</p>;
  }

  return (
    <section>
      <div className="container">
        <div className="container-header">
          <div className="container-title">
            <h4> {`Referente ao curso ${topic.curso.nome}`}</h4>
          </div>
          {user.usuario.id === topic.autor.id ? (
            <div className="edit-buttons">

              <button
                className="button-edit-topic"
                onClick={() => updateTopic(topic.id)}
                >
                Editar
              </button>
              <button
                className="button-del-topic"
                onClick={() => updateTopic(topic.id)}
                >
                Excluir
              </button>
            </div>
          ) : (
            ""
          )}
        </div>

        <div className="container-topic-content">
          <div className="container-topic-content-header">
            <i className="bx bx-message-rounded-detail"></i>
            <div className="topic-content-header-details">
              <div className="toip-title">
                <h4>{topic.titulo}</h4>
              </div>
              <div className="topic-author">
                <p>
                  criado por{" "}
                  <span className="author-name">{topic.autor.nome}</span> em{" "}
                  {topic.dataCriacao}
                </p>
              </div>
            </div>
          </div>

          <div className="topic-message">
            <p>{topic.mensagem}</p>
          </div>
        </div>
        {topic.respostas &&
          topic.respostas.map((resposta) => (
            <div key={resposta.id} className="topic-message-response">
              <div className="topic-message-response-header">
                <p>
                  <span className="author-name">{resposta.autor}</span>{" "}
                  respondeu:
                </p>
              </div>
              <div className="topic-message-response-content">
                <p>{resposta.mensagem}</p>
              </div>
              <div className="topic-message-response-date">
                <p>
                  em:{" "}
                  <span className="author-name">{resposta.dataCriacao}</span>
                </p>
              </div>
            </div>
          ))}

        <form onSubmit={saveReply}>
          <div className="topic-form-response">
            <div className="form-response-field">
              <textarea
                className="form-response-text"
                rows="15"
                name="mensagem"
                id="mensagem"
                value={mensagem}
                placeholder="O que você acha disso?"
                onChange={(e) => {
                  setMensagem(e.target.value);
                  setTopicoId(topic.id);
                }}
                required
              ></textarea>
            </div>
            <div className="form-reply-button">
              <button className="button-reply">Responder</button>
            </div>
          </div>
        </form>
      </div>
    </section>
  );
};

export default TopicViewComponent;
