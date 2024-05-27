package hub.forum.api.controller;

import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.usuario.DadosCadastroUsuario;
import hub.forum.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
    }

}
