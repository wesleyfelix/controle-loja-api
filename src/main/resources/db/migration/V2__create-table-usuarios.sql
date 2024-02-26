CREATE TABLE usuarios (
          id BIGINT AUTO_INCREMENT PRIMARY KEY,
          loja_id BIGINT,
          nome VARCHAR(100) not null,
          login VARCHAR(100) not null,
          senha VARCHAR(255) not null,
          perfil INT not null,
          logradouro VARCHAR(100),
          bairro VARCHAR(100),
          cep VARCHAR(9),
          cidade VARCHAR(100),
          uf CHAR(2),
          complemento VARCHAR(100),
          numero varchar(20),
          createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
          updatedat TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
          FOREIGN KEY (loja_id) REFERENCES lojas(id)
);