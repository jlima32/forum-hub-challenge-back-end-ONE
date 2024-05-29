package hub.forum.api.domain.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String nome;
    private String email;
    @JsonIgnore
    private String senha;

    public Usuario(DadosCadastroUsuario dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

}