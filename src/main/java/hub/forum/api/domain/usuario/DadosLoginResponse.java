package hub.forum.api.domain.usuario;

import hub.forum.api.dto.UsuarioDto;

public record DadosLoginResponse(String token, UsuarioDto usuario) {
}
