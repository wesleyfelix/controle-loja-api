CREATE TABLE usuario_loja (
        usuario_id BIGINT,
        loja_id BIGINT,
        PRIMARY KEY (usuario_id, loja_id),
        FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
        FOREIGN KEY (loja_id) REFERENCES lojas(id)
);