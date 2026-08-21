CREATE TABLE tabuleiro (
    id BIGSERIAL PRIMARY KEY
);

CREATE TABLE casa (
    id BIGSERIAL PRIMARY KEY,

    tabuleiro_id BIGINT NOT NULL,

    linha INTEGER NOT NULL,
    coluna INTEGER NOT NULL,
    numero_inicial INTEGER,
    fixa BOOLEAN NOT NULL,

    CONSTRAINT fk_casa_tabuleiro
        FOREIGN KEY (tabuleiro_id)
        REFERENCES tabuleiro (id),

    CONSTRAINT uq_casa_tabuleiro_id
        UNIQUE (tabuleiro_id, id),

    CONSTRAINT uq_casa_posicao
        UNIQUE (tabuleiro_id, linha, coluna),

    CONSTRAINT ck_casa_linha
        CHECK (linha BETWEEN 1 AND 9),

    CONSTRAINT ck_casa_coluna
        CHECK (coluna BETWEEN 1 AND 9),

    CONSTRAINT ck_casa_numero_inicial
        CHECK (
            numero_inicial IS NULL
            OR numero_inicial BETWEEN 1 AND 9
        )
);

CREATE TABLE partida (
    id BIGSERIAL PRIMARY KEY,

    tabuleiro_id BIGINT NOT NULL,

    CONSTRAINT fk_partida_tabuleiro
        FOREIGN KEY (tabuleiro_id)
        REFERENCES tabuleiro (id),

    CONSTRAINT uq_partida_tabuleiro_id
        UNIQUE (tabuleiro_id, id)
);

CREATE TABLE estado_casa (
    id BIGSERIAL PRIMARY KEY,

    tabuleiro_id BIGINT NOT NULL,
    partida_id BIGINT NOT NULL,
    casa_id BIGINT NOT NULL,

    numero_jogado INTEGER,

    CONSTRAINT fk_estado_casa_partida
        FOREIGN KEY (tabuleiro_id, partida_id)
        REFERENCES partida (tabuleiro_id, id),

    CONSTRAINT fk_estado_casa_casa
        FOREIGN KEY (tabuleiro_id, casa_id)
        REFERENCES casa (tabuleiro_id, id),

    CONSTRAINT uq_estado_casa_partida_casa
        UNIQUE (partida_id, casa_id),

    CONSTRAINT ck_estado_casa_numero_jogado
        CHECK (
            numero_jogado IS NULL
            OR numero_jogado BETWEEN 1 AND 9
        )
);

CREATE TABLE candidato (
    id BIGSERIAL PRIMARY KEY,

    estado_casa_id BIGINT NOT NULL,
    numero INTEGER NOT NULL,

    CONSTRAINT fk_candidato_estado_casa
        FOREIGN KEY (estado_casa_id)
        REFERENCES estado_casa (id),

    CONSTRAINT uq_candidato_estado_casa_numero
        UNIQUE (estado_casa_id, numero),

    CONSTRAINT ck_candidato_numero
        CHECK (numero BETWEEN 1 AND 9)
);
