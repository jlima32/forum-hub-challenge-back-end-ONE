package hub.forum.api.topico;

public record DadosCadastroTopico(String titulo,
                                  String mensagem,
                                  String dataCriacao,
                                  EstadoTopico estadoTopico,
                                  Long cursoId
                                  ) {

    public Long cursoId() {
        return cursoId;
    }
}
