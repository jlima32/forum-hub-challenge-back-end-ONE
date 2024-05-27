package hub.forum.api.controller;

import hub.forum.api.topico.DadosCadastroTopico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroTopico dados){
        System.out.println(dados);
    }
}
