CREATE TABLE lojas (
            id BIGINT AUTO_INCREMENT PRIMARY KEY,
            razao_social VARCHAR(100) NOT NULL,
            cnpj VARCHAR(14),
            email VARCHAR(100),
            telefone VARCHAR(15),
            logradouro VARCHAR(100),
            bairro VARCHAR(100),
            cep VARCHAR(8),
            cidade VARCHAR(100),
            uf CHAR(2),
            complemento VARCHAR(100),
            numero varchar(20),
            createdat TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            updatedat TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);