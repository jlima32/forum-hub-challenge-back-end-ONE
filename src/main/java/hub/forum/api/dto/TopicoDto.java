package hub.forum.api.dto;


import hub.forum.api.domain.curso.Curso;
import hub.forum.api.domain.topico.EstadoTopico;
import hub.forum.api.domain.topico.Topico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;
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
    private CursoDto curso;
    private String status;
    private List<RespostaDto> respostas;


    public TopicoDto(Topico topico){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao().format(formatter);
        this.autor = topico.getUsuario().getNome();
        this.curso = new CursoDto(topico.getCurso());
        this.status = String.valueOf(EstadoTopico.fromString(String.valueOf(topico.getEstadoTopico())));
        this.respostas = topico.getRespostas().stream()
                .map(RespostaDto::new)
                .collect(Collectors.toList());
    }

}
