CREATE TABLE roupas (
    id BIGSERIAL PRIMARY KEY ,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    tamanho VARCHAR(10),
    valor NUMERIC(10, 2) NOT NULL,
    marca VARCHAR(100),
    genero VARCHAR(20),
    cor VARCHAR(20),

    CHECK (tamanho IN ('PP', 'P', 'M', 'G', 'GG', 'XG', 'UNICO')),
    CHECK (genero IN ('MASCULINO', 'FEMININO', 'UNISSEX')),
    CHECK (cor IN (
        'PRETO', 'BRANCO', 'CINZA', 'VERMELHO', 'AZUL', 'VERDE',
        'AMARELO', 'LARANJA', 'ROSA', 'ROXO', 'MARROM',
        'BEGE', 'BORDO', 'DOURADO', 'PRATA'
    ))
);