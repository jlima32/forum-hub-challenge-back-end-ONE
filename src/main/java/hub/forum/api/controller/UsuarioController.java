package hub.forum.api.controller;

import hub.forum.api.usuario.DadosCadastroUsuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroUsuario dados){
        System.out.println(dados);
    }

}
