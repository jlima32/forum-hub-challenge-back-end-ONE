package hub.forum.api.dto;

import hub.forum.api.domain.topico.EstadoTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AtualizacaoTopicoDto {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;

    @NotNull
    private EstadoTopico estadoTopico;


}


