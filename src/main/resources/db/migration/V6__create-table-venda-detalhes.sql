CREATE TABLE venda_detalhes (
        venda_id BIGINT,
        produto_id BIGINT,
        quantidade BIGINT,
        desconto DECIMAL(10,2),
        valor DECIMAL(10,2),
        valor_total DECIMAL(10,2),
        FOREIGN KEY (venda_id) REFERENCES vendas(id),
        FOREIGN KEY (produto_id) REFERENCES produtos(id)
);