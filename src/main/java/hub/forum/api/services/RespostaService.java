package hub.forum.api.services;


import hub.forum.api.repository.RespostaRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.resposta.DadosCadastroResposta;
import hub.forum.api.resposta.Resposta;
import hub.forum.api.topico.Topico;
import hub.forum.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Resposta cadastrarResposta(DadosCadastroResposta dados){
        Topico topico = topicoRepository.findById(dados.topicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        Resposta resposta = new Resposta(dados, topico, usuario);
        return respostaRepository.save(resposta);

    }

}
