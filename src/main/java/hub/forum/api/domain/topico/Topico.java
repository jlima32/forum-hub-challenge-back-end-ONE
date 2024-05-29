package hub.forum.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import hub.forum.api.domain.curso.Curso;
import hub.forum.api.domain.resposta.Resposta;
import hub.forum.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

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
    private List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCadastroTopico dados, Curso curso, Usuario usuario){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.estadoTopico = dados.estadoTopico();
        this.curso = curso;
        this.usuario = usuario;
    }

    public Topico(DadosCadastroTopico dados) {
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setEstadoTopico(EstadoTopico estadoTopico) {
        this.estadoTopico = estadoTopico;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
