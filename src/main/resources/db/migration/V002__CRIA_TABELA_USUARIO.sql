CREATE TABLE usuario (
    id_usuario SERIAL PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ativo BOOLEAN NOT NULL,
    id_pessoa BIGINT,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa)
);
