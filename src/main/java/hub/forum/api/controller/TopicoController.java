package hub.forum.api.controller;

import hub.forum.api.services.TopicoService;
import hub.forum.api.topico.DadosCadastroTopico;
import hub.forum.api.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroTopico dados){
        topicoService.criarTopico(dados);
    }

    @GetMapping
    public List<Topico> listarTopicos(){
        return topicoService.listarTopicos();
    }
}
