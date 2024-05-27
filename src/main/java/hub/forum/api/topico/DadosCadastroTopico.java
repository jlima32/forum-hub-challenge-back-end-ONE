package hub.forum.api.topico;

public record DadosCadastroTopico(String titulo,
                                  String mensagem,
                                  String dataCriacao,
                                  EstadoTopico estadoTopico,
                                  String curso
                                  ) {
}
