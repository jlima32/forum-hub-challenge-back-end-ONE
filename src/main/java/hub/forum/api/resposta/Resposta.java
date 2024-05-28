package hub.forum.api.resposta;


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
    private Long topicoId;
    private String dataCriacao;
    private Long usuarioId;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean solucao;

    public Resposta(DadosCadastroResposta dados){
        this.mensagem = dados.mensagem();
        this.topicoId = dados.topicoId();
        this.dataCriacao = dados.dataCriacao();
        this.usuarioId = dados.usuarioId();
        this.solucao = dados.solucao();
    }

}
