package hub.forum.api.topico;

import hub.forum.api.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Topico(DadosCadastroTopico dados, Curso curso){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.estadoTopico = dados.estadoTopico();
        this.curso = curso;
    }

    public Topico(DadosCadastroTopico dados) {
    }
}
