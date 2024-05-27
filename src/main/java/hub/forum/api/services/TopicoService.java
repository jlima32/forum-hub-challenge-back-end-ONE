package hub.forum.api.services;

import hub.forum.api.curso.Curso;
import hub.forum.api.repository.CursoRepository;
import hub.forum.api.repository.TopicoRepository;
import hub.forum.api.topico.DadosCadastroTopico;
import hub.forum.api.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void criarTopico(DadosCadastroTopico dados){
        Curso curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado!"));
        Topico topico = new Topico(dados,curso);
        topicoRepository.save(topico);
    }

    public List<Topico> listarTopicos(){
        return topicoRepository.findAll();
    }


}
