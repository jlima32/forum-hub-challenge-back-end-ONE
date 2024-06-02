package hub.forum.api.dto;


import hub.forum.api.domain.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {

    private Long id;
    private String nome;

    public UsuarioDto(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }

}
