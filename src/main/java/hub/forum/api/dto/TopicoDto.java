package hub.forum.api.dto;


import hub.forum.api.topico.Topico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private String dataCriacao;
    private String autor;
    private List<RespostaDto> respostas;


    public TopicoDto(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.autor = topico.getUsuario().getNome();
        this.respostas = topico.getRespostas().stream()
                .map(RespostaDto::new)
                .collect(Collectors.toList());
    }

}
