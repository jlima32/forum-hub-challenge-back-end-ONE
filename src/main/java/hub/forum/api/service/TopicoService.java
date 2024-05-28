package hub.forum.api.service;

import hub.forum.api.curso.Curso;
import hub.forum.api.dto.TopicoDto;
import hub.forum.api.repository.CursoRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.topico.DadosCadastroTopico;
import hub.forum.api.topico.Topico;
import hub.forum.api.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;



    public TopicoDto criarTopico(DadosCadastroTopico dados){
        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));
        Usuario usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));
        Topico topico = new Topico(dados,curso,usuario);
        if (topicoRepository.existsByTituloAndMensagem(topico.getTitulo(),topico.getMensagem())){
            throw new RuntimeException("Já existe um tópico com o mesmo título e mensagem");
        }
        topico.setDataCriacao(LocalDateTime.now());
        topicoRepository.save(topico);
        return new TopicoDto(topico);
    }

   public List<TopicoDto> listarTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return topicos.stream()
                .map(TopicoDto::new)
                .collect(Collectors.toList());
   }




}
