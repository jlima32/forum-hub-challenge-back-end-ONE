package hub.forum.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank(message = "O título é obrigatório")
        String titulo,
        @NotBlank(message = "A mensagem é obrigatória")
        String mensagem,
        @NotNull(message = "O Status do tópico é obrigatório")
        EstadoTopico estadoTopico,
        @NotNull(message = "O curso é obrigatório")
        Long cursoId,
        @NotNull(message = "O usuário é obrigatório")
        Long usuarioId
)
{

    public Long cursoId() {
        return cursoId;
    }

    public Long usuarioId() {
        return usuarioId;
    }
}
