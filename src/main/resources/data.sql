INSERT INTO TB_BRQ_CANDIDATO(nm_candidato, nr_cpf, ds_email, nr_telefone, tp_genero, dt_nascimento, nm_certificacao) VALUES('Robin', '33747014800', 'robin@hotmail.com', '11942426655', 'MASCULINO', '1989-05-05 18:00:00', null);
INSERT INTO TB_BRQ_CANDIDATO(nm_candidato, nr_cpf, ds_email, nr_telefone, tp_genero, dt_nascimento, nm_certificacao) VALUES('Batman', '33747014801', 'batman@hotmail.com', '11942426656', 'MASCULINO', '1989-05-06 19:00:00', 'Kotlin');
INSERT INTO TB_BRQ_CANDIDATO(nm_candidato, nr_cpf, ds_email, nr_telefone, tp_genero, dt_nascimento, nm_certificacao) VALUES('Anny', '33747014802', 'anny@hotmail.com', '11942426657', 'FEMININO', '1989-05-07 20:00:00', 'Kotlin');
INSERT INTO TB_BRQ_CANDIDATO(nm_candidato, nr_cpf, ds_email, nr_telefone, tp_genero, dt_nascimento, nm_certificacao) VALUES('Arnoldo', '33747014803', 'arnoldo@hotmail.com', '11942426658', 'MASCULINO', '1989-05-08 21:00:00', null);

INSERT INTO TB_BRQ_SKILL(nm_skill) VALUES('Kotlin');
INSERT INTO TB_BRQ_SKILL(nm_skill) VALUES('Kanban');
INSERT INTO TB_BRQ_SKILL(nm_skill) VALUES('Spring Boot');

INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(1, 1);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(1, 2);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(1, 3);

INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(2, 1);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(2, 2);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(2, 3);

INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(3, 1);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(3, 2);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(3, 3);

INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(4, 1);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(4, 2);
INSERT INTO TB_BRQ_CANDIDATO_SKILL(candidato_id_candidato, skill_id_skill) VALUES(4, 3);