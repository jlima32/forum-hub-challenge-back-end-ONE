package hub.forum.api.domain.resposta;

public record DadosCadastroResposta(String mensagem,
                                    Long topicoId,
                                    String dataCriacao,
                                    Long usuarioId,
                                    Boolean solucao) {
}
