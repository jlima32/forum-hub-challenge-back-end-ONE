package hub.forum.api.service;

import hub.forum.api.domain.curso.Curso;
import hub.forum.api.domain.topico.EstadoTopico;
import hub.forum.api.dto.AtualizacaoTopicoDto;
import hub.forum.api.dto.TopicoDto;
import hub.forum.api.infra.SecurityFilter;
import hub.forum.api.infra.TratadorDeErros;
import hub.forum.api.repository.CursoRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.repository.UsuarioRepository;
import hub.forum.api.domain.topico.DadosCadastroTopico;
import hub.forum.api.domain.topico.Topico;
import hub.forum.api.domain.usuario.Usuario;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TratadorDeErros tratadorDeErros;




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
        topico.setEstadoTopico(EstadoTopico.valueOf("ABERTO"));
        topicoRepository.save(topico);
        return new TopicoDto(topico);
    }

   public List<TopicoDto> listarTopicos() {
       Pageable pageable = PageRequest.of(0,20, Sort.by("dataCriacao").descending());
       Page<Topico> topicosPage = topicoRepository.findAll(pageable);
       return topicosPage.stream()
               .map(TopicoDto::new)
               .collect(Collectors.toList());
   }

   public TopicoDto buscarPorId(Long id){
        var topico = topicoRepository.getReferenceById(id);
        return new TopicoDto(topico);
   }

   @Transactional
   public TopicoDto atualizarTopico(Long id, Long idUsuario, AtualizacaoTopicoDto dadosAtualizacao){
       Optional<Topico> optionalTopico = topicoRepository.findById(id);
       if (optionalTopico.isPresent()){
           Topico topico = optionalTopico.get();
           if (topico.getUsuario().getId().equals(idUsuario)){

               topico.setTitulo(dadosAtualizacao.getTitulo());
               topico.setMensagem(dadosAtualizacao.getMensagem());
               topico.setEstadoTopico(dadosAtualizacao.getEstadoTopico());

               return new TopicoDto(topico);
           }else{
               throw new IllegalArgumentException();
           }
       }else{
        throw new EntityNotFoundException();
       }

   }

   @Transactional
   public void deletarTopico(Long id, Long idUsuario){
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()){
            Topico topico = optionalTopico.get();
            if (topico.getUsuario().getId().equals(idUsuario)){
                topicoRepository.deleteById(id);
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new EntityNotFoundException();
        }
   }



}
