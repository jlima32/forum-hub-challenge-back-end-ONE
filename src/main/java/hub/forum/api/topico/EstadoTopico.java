package hub.forum.api.topico;

public enum EstadoTopico {
    RESOLVIDO,
    ABERTO;


    public static EstadoTopico fromString(String estadoTopico){
        for (EstadoTopico value : values()){
            if (value.name().equalsIgnoreCase(estadoTopico)){
                return value;
            }
        }

        throw new IllegalArgumentException("Status do tópico inválido: " + estadoTopico);
    }

}
