package hub.forum.api.services;


import hub.forum.api.repository.RespostaRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.resposta.DadosCadastroResposta;
import hub.forum.api.resposta.Resposta;
import hub.forum.api.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RespostaService {
    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Resposta cadastrarResposta(DadosCadastroResposta dados){
        Topico topico = topicoRepository.findById(dados.topicoId())
                .orElseThrow(() -> new IllegalArgumentException("Tópico não encontrado"));

        Resposta resposta = new Resposta(dados, topico);
        return respostaRepository.save(resposta);

    }

}
