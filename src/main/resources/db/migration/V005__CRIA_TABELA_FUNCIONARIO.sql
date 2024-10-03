CREATE TABLE rh.funcionario (
    id_funcionario SERIAL PRIMARY KEY,
    data_admissao DATE NOT NULL,
    id_pessoa BIGINT,
    id_cargo BIGINT,
    situacao VARCHAR(50),
    data_desligamento DATE,
    regime_trabalho VARCHAR(50),
    data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ultima_atualizacao TIMESTAMP,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa) ON DELETE CASCADE,
    FOREIGN KEY (id_cargo) REFERENCES rh.cargo(id_cargo) ON DELETE CASCADE
);
