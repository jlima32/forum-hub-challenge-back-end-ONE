package hub.forum.api.controller;

import hub.forum.api.resposta.DadosCadastroResposta;
import hub.forum.api.resposta.Resposta;
import hub.forum.api.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public Resposta cadastrar(@RequestBody DadosCadastroResposta dados){
        return respostaService.cadastrarResposta(dados);
    }

}
