CREATE TABLE produtos (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          nome VARCHAR(100),
          tamanho VARCHAR(20),
          descricao VARCHAR(255),
          quantidade INT,
          valor DECIMAL(10,2),
          loja_id BIGINT,
          createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
          updatedat TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          FOREIGN KEY (loja_id) REFERENCES lojas(id)
);