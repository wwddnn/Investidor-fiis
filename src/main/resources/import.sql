
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ana', 'ana@gmail.com', '21992224411', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Bruno', 'bruno@hotmail.com', '21974758889', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Carla', 'carla@outlook.com', '11995552244', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Dias', 'dias@msn.com', '21997788112', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ezequiel', 'eze@hotmail.com', '21988556644', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ferreira', 'ferreira@ig.com.br', '21977745321', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Gigi', 'gigi@uol.com.br', '21996883715', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Hellen', 'hellen@terra.com.br', '21995746312', 'Rico');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ifen', 'ifen@estacio.com.br', '21997346514', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Jullia', 'jullia@bol.com.br', '21993311232', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Kiaan', 'kiaan@terra.com.br', '21993356782', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Liane', 'liane@uol.com.br', '21993388731', 'NuInvest');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Michael', 'michael@hotmail.com', '21997548730', 'Clear');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Nico', 'nico@uol.com.br', '21993388245', 'XP');
INSERT INTO tb_investidor (nome, email, telefone, corretora) VALUES ('Ophra', 'ophra@gmail.com.br', '21993383457', 'Rico');


INSERT INTO tb_tipo (tipo) VALUES ('Logístico');
INSERT INTO tb_tipo (tipo) VALUES ('Hedge Fund');
INSERT INTO tb_tipo (tipo) VALUES ('CRI');
INSERT INTO tb_tipo (tipo) VALUES ('Agro');
INSERT INTO tb_tipo (tipo) VALUES ('Shopping');
INSERT INTO tb_tipo (tipo) VALUES ('Fofis');


INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('XPLG11', 'Fii que investe em galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('VGHF11', 'Fii que investe tanto em ações quanto em outros Fiis', 2);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('URPR11', 'Fii que investe em CRIs e Fiis', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('SNAG11', 'Fii que investe em Agro', 4);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('RECR11', 'Fii que investe predominantemente em inflação', 3);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('XPML11', 'Fii que investe shoppings centers', 5);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('BCFF11', 'Fii que investe outros Fiis', 6);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('BTLG11', 'Fii que investe galpões logísticos', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('RECR11', 'Fii que investe em CRIs', 1);
INSERT INTO tb_fii (nome, descricao, tipo_id) VALUES ('MCCI11', 'Fii que investe em CRIs', 1);


INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (1, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (1, 10);
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
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (10, 10);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (11, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (11, 2);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (12, 5);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (12, 4);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (13, 1);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (14, 9);
INSERT INTO tb_investidor_fii (investidor_id, fii_id) VALUES (15, 10);



