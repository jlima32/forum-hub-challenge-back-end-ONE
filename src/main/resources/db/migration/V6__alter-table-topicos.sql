ALTER TABLE topicos ADD COLUMN usuario_id BIGINT;
ALTER TABLE topicos ADD CONSTRAINT fk_usuario FOREIGN KEY  (usuario_id) REFERENCES usuarios(id);
