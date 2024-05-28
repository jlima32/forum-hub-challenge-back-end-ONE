package hub.forum.api.resposta;

public record DadosCadastroResposta(String mensagem,
                                    Long topicoId,
                                    String dataCriacao,
                                    Long usuarioId,
                                    Boolean solucao) {
}
