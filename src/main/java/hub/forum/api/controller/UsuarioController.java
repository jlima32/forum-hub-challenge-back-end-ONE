package hub.forum.api.controller;

import hub.forum.api.dto.UsuarioDto;
import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.domain.usuario.DadosCadastroUsuario;
import hub.forum.api.domain.usuario.Usuario;
import hub.forum.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody DadosCadastroUsuario dados){
        UsuarioDto usuarioDto = service.criarUsuario(dados);
        return ResponseEntity.ok(usuarioDto);
    }

}
