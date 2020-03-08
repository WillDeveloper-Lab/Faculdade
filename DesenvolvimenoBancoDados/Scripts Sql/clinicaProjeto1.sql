--1)
CREATE DATABASE CLINICA;
use clinica;
--2)
CREATE TABLE Ambulatorios (
	nroa integer PRIMARY KEY,
	andar numeric(3) NOT NULL,
	capacidade smallint
);

CREATE TABLE Medicos (
	codm integer,
	nome varchar(40) NOT NULL,
	idade smallint NOT NULL,
	especialidade char(20), 
	CPF numeric(11) UNIQUE,
	cidade varchar(30),
	nroa integer,
	PRIMARY KEY(codm),
	FOREIGN KEY(nroa) REFERENCES Ambulatorios (nroa)	
);

ALTER TABLE Medicos ADD constraint FK_Ambulatorios_Medicos
FOREIGN KEY(nroa) REFERENCES Ambulatorios (nroa);

CREATE TABLE Pacientes (
	codp integer PRIMARY KEY, 
	nome varchar(40) NOT NULL,
    idade smallint NOT NULL,
	cidade char(30),
    CPF numeric(11) UNIQUE,
    doenca varchar(40) NOT NULL
);

CREATE TABLE Funcionarios (
	codf integer PRIMARY KEY,
	nome varchar(40) NOT NULL,
	idade smallint,
	CPF numeric(11) UNIQUE,
	cidade varchar(30),
	salario numeric(10),
	cargo varchar(20)
);

CREATE TABLE Consultas(
	codm integer,
	codp integer,
	data date,
	hora time,
    PRIMARY KEY(codm, codp, data, hora),
	FOREIGN KEY(codm) REFERENCES Medicos (codm),
    FOREIGN KEY(codp) REFERENCES Pacientes (codp)
);

ALTER TABLE Consultas ADD constraint FK_Medicos_Consultas
FOREIGN KEY(codm) REFERENCES Medicos (codm);
ALTER TABLE Consultas ADD constraint FK_Pacientes_Consultas
FOREIGN KEY(codp) REFERENCES Pacientes (codp);

--3)
ALTER TABLE Funcionarios ADD nroa integer;
ALTER TABLE Funcionarios ADD constraint fk_nroa
FOREIGN KEY(nroa) REFERENCES Ambulatorios (nroa);

--4)
DROP INDEX indMedico_CPF ON medicos;
DROP INDEX indPaciente_DOENCA ON Pacientes;
CREATE UNIQUE INDEX indMedico_CPF ON medicos (CPF);
CREATE INDEX indPaciente_DOENCA ON Pacientes (doenca);

--5)
DROP INDEX indPaciente_DOENCA ON Pacientes;

--6)
ALTER TABLE Funcionarios DROP FOREIGN KEY fk_nroa;
ALTER TABLE Funcionarios DROP COLUMN cargo;
ALTER TABLE Funcionarios DROP COLUMN nroa;

--Incluindo Ambulatorio
INSERT into ambulatorios (nroa,andar,capacidade) VALUES (1,1,30);
INSERT into ambulatorios (nroa,andar,capacidade) VALUES (2,1,50);
INSERT into ambulatorios (nroa,andar,capacidade) VALUES (3,2,40);
INSERT into ambulatorios (nroa,andar,capacidade) VALUES (4,2,25);
INSERT into ambulatorios (nroa,andar,capacidade) VALUES (5,2,55);

--Incluindo medicos
INSERT INTO medicos (codm,nome,idade,especialidade,CPF,cidade,nroa) VALUES (1,'Joao',40,'ortopedia',10000100000,'Florianopolis',1);
INSERT INTO medicos (codm,nome,idade,especialidade,CPF,cidade,nroa) VALUES (2,'Maria',42,'traumatologia',10000110000,'Blumenau',2);
INSERT INTO medicos (codm,nome,idade,especialidade,CPF,cidade,nroa) VALUES (3,'Pedro',51,'pediatria',11000100000,'Sao Jose',2);
INSERT INTO medicos (codm,nome,idade,especialidade,CPF,cidade,nroa) VALUES (4,'Carlos',28,'Ortopedia',11000110000,'Joinville',null);
INSERT INTO medicos (codm,nome,idade,especialidade,CPF,cidade,nroa) VALUES (5,'Marcia',33,'neurologia',11000111000,'Biguacu',3);

--Incluindo pacientes
INSERT into pacientes (codp,nome,idade,cidade,CPF,doenca) VALUES (1, 'Ana', 20, 'Florianopolis', 20000200000, 'gripe');
INSERT into pacientes (codp,nome,idade,cidade,CPF,doenca) VALUES (2, 'Paulo', 24, 'Palhoca', 20000220000, 'fratura');
INSERT into pacientes (codp,nome,idade,cidade,CPF,doenca) VALUES (3, 'Lucia', 30, 'Biguacu', 22000200000, 'tendinite');
INSERT into pacientes (codp,nome,idade,cidade,CPF,doenca) VALUES (4, 'Carlos', 28, 'Joinville', 11000110000, 'sarampo');

--Inserindo funcionarios
INSERT INTO Funcionarios (codf,nome,idade,CPF,cidade,salario,nroa,cargo) VALUES (1,'Rita',32,20000100000,'Sao Jose',1200, 2,'Secretaria');
INSERT INTO Funcionarios (codf,nome,idade,CPF,cidade,salario,nroa,cargo) VALUES (2,'Maria',55,30000110000,'Palhoca',1220, 4, 'Contadora');
INSERT INTO Funcionarios (codf,nome,idade,CPF,cidade,salario,nroa,cargo) VALUES (3,'Caio',45,41000100000,'Florianopolis',1100, 5,'Analista de Sistemas');
INSERT INTO Funcionarios (codf,nome,idade,CPF,cidade,salario,nroa,cargo) VALUES (4,'Carlos',44,51000110000,'Florianopolis',1200, 3,'Secretario');
INSERT INTO Funcionarios (codf,nome,idade,CPF,cidade,salario,nroa,cargo) VALUES (5,'Paula',33,61000111000,'Florianopolis',2500, 1,'Telefonista');

-- inserindo consultas
INSERT into consultas (codm,codp,`data`,hora) VALUES (1,1,STR_TO_DATE('12/06/2006','%d/%m/%Y'),STR_TO_DATE('14:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (1,4,STR_TO_DATE('13/06/2006','%d/%m/%Y'),STR_TO_DATE('10:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (2,1,STR_TO_DATE('13/06/2006','%d/%m/%Y'),STR_TO_DATE('09:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (2,2,STR_TO_DATE('13/06/2006','%d/%m/%Y'),STR_TO_DATE('11:00','%H:%i'));
INSERT into consultas (codm,codp,`data`,hora) VALUES (2,3,STR_TO_DATE('14/06/2006','%d/%m/%Y'),STR_TO_DATE('14:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (2,4,STR_TO_DATE('14/06/2006','%d/%m/%Y'),STR_TO_DATE('17:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (3,1,STR_TO_DATE('19/06/2006','%d/%m/%Y'),STR_TO_DATE('18:00','%H:%i'));
INSERT into consultas (codm,codp,`data`,hora) VALUES (3,3,STR_TO_DATE('12/06/2006','%d/%m/%Y'),STR_TO_DATE('10:00','%H:%i'));
INSERT into consultas (codm,codp,`data`,hora) VALUES (3,4,STR_TO_DATE('19/06/2006','%d/%m/%Y'),STR_TO_DATE('13:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (4,4,STR_TO_DATE('20/06/2006','%d/%m/%Y'),STR_TO_DATE('13:00','%H:%i')); 
INSERT into consultas (codm,codp,`data`,hora) VALUES (4,4,STR_TO_DATE('22/06/2006','%d/%m/%Y'),STR_TO_DATE('19:30','%H:%i'));