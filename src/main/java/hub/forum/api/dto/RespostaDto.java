package hub.forum.api.dto;

import hub.forum.api.domain.resposta.Resposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDto {
    private Long id;
    private String mensagem;
    private String autor;
    private String dataCriacao;
    private Boolean solucao;

    public RespostaDto(Resposta resposta){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.autor = resposta.getUsuario().getNome();
        this.dataCriacao = resposta.getDataCriacao().format(formatter);
        this.solucao = resposta.getSolucao();
    }

}
