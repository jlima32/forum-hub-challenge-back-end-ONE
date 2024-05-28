CREATE TABLE respostas (

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT,
    topico_id BIGINT,
    data_criacao VARCHAR(20),
    usuario_id BIGINT,
    solucao TINYINT(1) DEFAULT 0

);