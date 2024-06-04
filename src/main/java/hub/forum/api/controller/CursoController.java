package hub.forum.api.controller;

import hub.forum.api.domain.curso.Curso;
import hub.forum.api.domain.curso.DadosCadastroCurso;
import hub.forum.api.repository.CursoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroCurso dados){
        repository.save(new Curso(dados));
    }


    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos(){
        var cursos = repository.findAll();
        return ResponseEntity.ok(cursos);
    }
}
