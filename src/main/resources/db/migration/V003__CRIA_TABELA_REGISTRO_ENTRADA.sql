CREATE TABLE registro_entrada (
    id_registro_entrada SERIAL PRIMARY KEY,
    data_entrada TIMESTAMP WITH TIME ZONE NOT NULL,
    data_saida TIMESTAMP WITH TIME ZONE,
    id_usuario BIGINT,
    ip VARCHAR(45),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);
