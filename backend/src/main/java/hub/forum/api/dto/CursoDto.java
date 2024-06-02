package hub.forum.api.dto;

import hub.forum.api.domain.curso.Curso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {

    private Long id;
    private String nome;
    private String categoria;

    public CursoDto(Curso curso){
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }


}
