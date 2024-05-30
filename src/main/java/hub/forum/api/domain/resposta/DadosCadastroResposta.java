package hub.forum.api.domain.resposta;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroResposta(
        @NotBlank(message = "A mensagem é obrigatória")
        String mensagem,
                                    Long topicoId,
                                    String dataCriacao,
                                    Long usuarioId,
                                    Boolean solucao) {
}
