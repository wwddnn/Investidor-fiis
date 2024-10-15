
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ana', 'ana@gmail.com', '21992224411', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Bruno', 'bruno@hotmail.com', '21974758889', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Carla', 'carla@outlook.com', '11995552244', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Dias', 'dias@msn.com', '21997788112', 'Clear');

INSERT INTO tb_tipo (tipo) VALUES ('Logístico');
INSERT INTO tb_tipo (tipo) VALUES ('Hedge Fund');
INSERT INTO tb_tipo (tipo) VALUES ('CRI');
INSERT INTO tb_tipo (tipo) VALUES ('Agro');

INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('XPLG11', 'Fii que investe em galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('VGHF11', 'Fii que investe tanto em ações quanto em outros Fiis', 2);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('URPR11', 'Fii que investe em CRIs e Fiis', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('SNAG11', 'Fii que investe em Agro', 4);

INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (1, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (2, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (3, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (4, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (4, 3);



