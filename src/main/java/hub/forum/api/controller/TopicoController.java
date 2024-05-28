package hub.forum.api.controller;

import hub.forum.api.dto.TopicoDto;
import hub.forum.api.service.TopicoService;
import hub.forum.api.topico.DadosCadastroTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid DadosCadastroTopico dados){
        TopicoDto topicoDto = topicoService.criarTopico(dados);
        return ResponseEntity.ok(topicoDto);
    }

    @GetMapping
    public List<TopicoDto> listarTopicos(){

        return topicoService.listarTopicos();
    }
}
