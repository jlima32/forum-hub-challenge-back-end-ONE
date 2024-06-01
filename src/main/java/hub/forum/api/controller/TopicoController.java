package hub.forum.api.controller;

import hub.forum.api.domain.usuario.Usuario;
import hub.forum.api.dto.AtualizacaoTopicoDto;
import hub.forum.api.dto.TopicoDto;
import hub.forum.api.dto.UsuarioDto;
import hub.forum.api.service.TopicoService;
import hub.forum.api.domain.topico.DadosCadastroTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
@Validated
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
        TopicoDto topicoDto = topicoService.criarTopico(dados);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topicoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(topicoDto);
    }

    @GetMapping()
    public ResponseEntity<List<TopicoDto>> listarTopicos(){
        var topicos =  topicoService.listarTopicos();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        var topico = topicoService.buscarPorId(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarTopico(@PathVariable Long id, @RequestBody @Validated AtualizacaoTopicoDto dadosAtualizacao){
         topicoService.atualizarTopico(id, dadosAtualizacao);
        return ResponseEntity.ok(dadosAtualizacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarTopico(@PathVariable Long id, Long idUsuario, @AuthenticationPrincipal Usuario logado){
        topicoService.deletarTopico(id, logado.getId());

        return ResponseEntity.noContent().build();
    }



}
