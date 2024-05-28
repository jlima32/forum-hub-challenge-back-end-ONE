package hub.forum.api.resposta;


import hub.forum.api.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    private String dataCriacao;
    private Long usuarioId;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean solucao;

    public Resposta(DadosCadastroResposta dados, Topico topico){
        this.mensagem = dados.mensagem();
        this.topico = topico;
        this.dataCriacao = dados.dataCriacao();
        this.usuarioId = dados.usuarioId();
        this.solucao = dados.solucao();
    }

}
