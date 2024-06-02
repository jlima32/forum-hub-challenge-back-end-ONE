ALTER TABLE topicos CHANGE COLUMN curso curso_id BIGINT;
ALTER TABLE topicos ADD CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES cursos(id);
