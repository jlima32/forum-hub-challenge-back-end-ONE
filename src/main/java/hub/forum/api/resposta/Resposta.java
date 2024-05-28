package hub.forum.api.resposta;


import com.fasterxml.jackson.annotation.JsonBackReference;
import hub.forum.api.topico.Topico;
import hub.forum.api.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @JsonBackReference
    private Topico topico;

    @Column(name= "data_criacao")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean solucao;

    public Resposta(DadosCadastroResposta dados, Topico topico, Usuario usuario){
        this.mensagem = dados.mensagem();
        this.topico = topico;
        this.usuario = usuario;
        this.solucao = dados.solucao();
    }


    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
