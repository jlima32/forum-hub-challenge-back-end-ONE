package hub.forum.api.topico;

public record DadosCadastroTopico(String titulo,
                                  String mensagem,
                                  String dataCriacao,
                                  EstadoTopico estadoTopico,
                                  Long cursoId,
                                  Long usuarioId
                                  ) {

    public Long cursoId() {
        return cursoId;
    }

    public Long usuarioId() {
        return usuarioId;
    }
}
