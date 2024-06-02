package hub.forum.api.repository;

import hub.forum.api.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findAll(Pageable pageable);


    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
