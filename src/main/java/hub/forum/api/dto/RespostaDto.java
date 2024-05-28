package hub.forum.api.dto;

import hub.forum.api.resposta.Resposta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.autor = resposta.getUsuario().getNome();
        this.dataCriacao = resposta.getDataCriacao();
        this.solucao = resposta.getSolucao();
    }

}
