package hub.forum.api.controller;

import hub.forum.api.domain.usuario.DadosAutenticacao;
import hub.forum.api.domain.usuario.DadosLoginResponse;
import hub.forum.api.domain.usuario.Usuario;
import hub.forum.api.dto.UsuarioDto;
import hub.forum.api.infra.DadosTokenJWT;
import hub.forum.api.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication =  manager.authenticate(authenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();
        String tokenJWT = tokenService.gerarToken(usuario);
        UsuarioDto usuarioDto = new UsuarioDto(usuario);

        return ResponseEntity.ok(new DadosLoginResponse(tokenJWT, usuarioDto));

    }
}
