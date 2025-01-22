INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ana', 'ana@gmail.com', '21992224411', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Andre', 'andre@gmail.com', '21992222222', 'Avenue');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Aline', 'aline@gmail.com', '21992229999', 'Genial');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Bruno', 'bruno@hotmail.com', '21974758889', 'Avenue');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Breno', 'breno@hotmail.com', '21974752222', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Carla', 'carla@outlook.com', '11995552244', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Carol', 'carol@outlook.com', '11995552222', 'Toro');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Dias', 'dias@msn.com', '21997788112', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Deco', 'deco@msn.com', '21997788222', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ezequiel', 'eze@hotmail.com', '21988556644', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ferreira', 'ferreira@ig.com.br', '21977745321', 'Avenue');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Gigi', 'gigi@uol.com.br', '21996883715', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Hellen', 'hellen@terra.com.br', '21995746312', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ifen', 'ifen@estacio.com.br', '21997346514', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Jullia', 'jullia@bol.com.br', '21993311232', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Kiaan', 'kiaan@terra.com.br', '21993356782', 'Toro');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Liane', 'liane@uol.com.br', '21993388731', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Michael', 'michael@hotmail.com', '21997548730', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Nico', 'nico@uol.com.br', '21993388245', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Nerdin', 'nerdin@ig.com.br', '21993388277', 'Genial');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ophra', 'ophra@gmail.com.br', '21993383457', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Origami', 'origami@terra.com.br', '21993383499', 'Toro');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Patlin', 'patlin@hotmail.com', '21993383431', 'Genial');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Querubim', 'querubim@hotmail.com', '21993383499', 'Clear');


INSERT INTO tb_tipo (nome) VALUES ('Logístico');
INSERT INTO tb_tipo (nome) VALUES ('Hedge Fund');
INSERT INTO tb_tipo (nome) VALUES ('CRI');
INSERT INTO tb_tipo (nome) VALUES ('Agro');
INSERT INTO tb_tipo (nome) VALUES ('Shopping');
INSERT INTO tb_tipo (nome) VALUES ('Fofis');
INSERT INTO tb_tipo (nome) VALUES ('Desenvolvimento');


INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('XPLG11', 'Fii que investe em galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('VGHF11', 'Fii que investe tanto em ações quanto em outros Fiis', 2);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('URPR11', 'Fii que investe em CRIs e Fiis', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('SNAG11', 'Fii que investe em Agro', 4);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('RECR11', 'Fii que investe predominantemente em inflação', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('XPML11', 'Fii que investe shoppings centers', 5);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('BCFF11', 'Fii que investe outros Fiis', 6);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('BTLG11', 'Fii que investe galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('SNCI11', 'Fii que investe em CRIs', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('MCCI11', 'Fii que investe em CRIs', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('SNFZ11', 'Fii que investe em Agro', 4);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('BRCO11', 'Fii que investe em galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('MXRF11', 'Fii que investe em galpões logísticos', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('TGAR11', 'Fii de desenvolvimento', 7);



INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (1, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (1, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (2, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (2, 7);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (3, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (3, 9);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (4, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (4, 3);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (5, 10);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (5, 6);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (6, 5);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (6, 8);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (7, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (7, 8);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (8, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (9, 6);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (10, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (10, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (11, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (11, 12);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (12, 5);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (12, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (13, 12);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (14, 9);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (15, 10);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (15, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (16, 10);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (16, 11);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (17, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (17, 12);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (18, 10);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (18, 9);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (19, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (19, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (20, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (20, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (21, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (21, 7);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (22, 8);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (22, 13);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (23, 3);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (23, 5);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (24, 7);





