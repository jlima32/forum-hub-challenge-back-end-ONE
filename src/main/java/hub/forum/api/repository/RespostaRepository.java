package hub.forum.api.repository;

import hub.forum.api.resposta.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
