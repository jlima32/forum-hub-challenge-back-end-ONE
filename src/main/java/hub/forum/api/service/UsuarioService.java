package hub.forum.api.service;

import hub.forum.api.domain.usuario.DadosCadastroUsuario;
import hub.forum.api.domain.usuario.Usuario;
import hub.forum.api.dto.UsuarioDto;
import hub.forum.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

@Autowired
private UsuarioRepository repository;

@Autowired
private PasswordEncoder passwordEncoder;

    public UsuarioDto criarUsuario(DadosCadastroUsuario dados){
        Usuario usuario = new Usuario(dados);
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return new UsuarioDto(usuario);

    }

}
