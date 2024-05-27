package hub.forum.api.services;

import hub.forum.api.curso.Curso;
import hub.forum.api.repository.CursoRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.topico.DadosCadastroTopico;
import hub.forum.api.topico.Topico;
import hub.forum.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void criarTopico(DadosCadastroTopico dados){
        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));
        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
        Topico topico = new Topico(dados,curso,usuario);
        topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos(){
        return topicoRepository.findAll();
    }


}
