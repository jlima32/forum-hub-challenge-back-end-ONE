package hub.forum.api.controller;

import hub.forum.api.repository.RespostaRepository;
import hub.forum.api.resposta.DadosCadastroResposta;
import hub.forum.api.resposta.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroResposta dados){
        repository.save(new Resposta(dados));
    }

}
