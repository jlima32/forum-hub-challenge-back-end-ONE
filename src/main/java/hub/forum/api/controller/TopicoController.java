package hub.forum.api.controller;

import hub.forum.api.dto.AtualizacaoTopicoDto;
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
    public ResponseEntity<List<TopicoDto>> listarTopicos(){
        var topicos =  topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public TopicoDto buscarPorId(@PathVariable Long id){
        return topicoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Validated AtualizacaoTopicoDto dadosAtualizacao){
         topicoService.atualizarTopico(id, dadosAtualizacao);
        return ResponseEntity.ok(dadosAtualizacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id){
        topicoService.deletarTopico(id);

        return ResponseEntity.noContent().build();
    }



}
