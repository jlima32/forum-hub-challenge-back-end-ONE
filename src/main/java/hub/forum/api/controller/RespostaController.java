package hub.forum.api.controller;

import hub.forum.api.resposta.DadosCadastroResposta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("respostas")
public class RespostaController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroResposta dados){
        System.out.println(dados);
    }

}
