package hub.forum.api.controller;

import hub.forum.api.domain.resposta.DadosCadastroResposta;
import hub.forum.api.domain.resposta.Resposta;
import hub.forum.api.service.RespostaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public Resposta cadastrar(@RequestBody @Valid DadosCadastroResposta dados){
        return respostaService.cadastrarResposta(dados);
    }

}
