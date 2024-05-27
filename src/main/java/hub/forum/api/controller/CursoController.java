package hub.forum.api.controller;

import hub.forum.api.curso.DadosCadastroCurso;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroCurso dados){
        System.out.println(dados);
    }

}
