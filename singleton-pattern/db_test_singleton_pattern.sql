DROP DATABASE IF EXISTS db_test_singleton_pattern;
CREATE DATABASE IF NOT EXISTS db_test_singleton_pattern;
USE db_test_singleton_pattern;

CREATE TABLE IF NOT EXISTS tb_raca
(
    id   BIGINT UNSIGNED AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,

    UNIQUE (nome),

    PRIMARY KEY (id)
);

INSERT INTO tb_raca (nome) VALUES ('Poodle');
INSERT INTO tb_raca (nome) VALUES ('Bulldog');
INSERT INTO tb_raca (nome) VALUES ('Pitbull');
INSERT INTO tb_raca (nome) VALUES ('Pastor Alemão');
INSERT INTO tb_raca (nome) VALUES ('Vira-lata');
INSERT INTO tb_raca (nome) VALUES ('Beagle');
INSERT INTO tb_raca (nome) VALUES ('Golden Retriever');
INSERT INTO tb_raca (nome) VALUES ('Dálmata');
INSERT INTO tb_raca (nome) VALUES ('Chow Chow');
INSERT INTO tb_raca (nome) VALUES ('Rottweiler');
INSERT INTO tb_raca (nome) VALUES ('Shih Tzu');
INSERT INTO tb_raca (nome) VALUES ('Yorkshire');

SELECT * FROM tb_raca;
