package hub.forum.api.topico;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hub.forum.api.curso.Curso;
import hub.forum.api.resposta.Resposta;
import hub.forum.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private String dataCriacao;

    @Enumerated(EnumType.STRING)
    private EstadoTopico estadoTopico;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Resposta> respostas;

    public Topico(DadosCadastroTopico dados, Curso curso, Usuario usuario){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.estadoTopico = dados.estadoTopico();
        this.curso = curso;
        this.usuario = usuario;
    }

    public Topico(DadosCadastroTopico dados) {
    }
}
