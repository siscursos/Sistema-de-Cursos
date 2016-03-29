SET SQL_SAFE_UPDATES=0;
DROP DATABASE IF exists db_curso;
CREATE DATABASE db_curso;
USE db_curso;

CREATE TABLE Aluno(
cpf       varchar(11) not null,
nome      varchar(50) not null,
endereco  varchar(150) not null,
telefone  varchar(12) not null,
email     varchar(45) not null,
rg        varchar(9) not null,
CONSTRAINT pk_aluno PRIMARY KEY (cpf));

CREATE TABLE Curso(
codigo       integer not null,
area		 varchar(20),
nome         varchar(50) not null,
data_inicio  datetime not null,
data_termino datetime not null,
horario      varchar(9) not null,
n_vagas      integer not null,
valor        decimal not null,
CONSTRAINT pk_curso PRIMARY KEY (codigo));

CREATE TABLE Informatica(
Curso_codigo_informatica  integer not null,
n_laboratorio             integer not null,
reg_softwares             varchar(400),
CONSTRAINT fk_codigo_curso_informatica FOREIGN KEY (Curso_codigo_informatica) REFERENCES Curso (codigo) on delete cascade,
CONSTRAINT pk_codigo_informatica       PRIMARY KEY (Curso_codigo_informatica));

CREATE TABLE Artes(
Curso_codigo_artes       integer not null,
descricao_material varchar(400) not null,
CONSTRAINT fk_codigo_curso_artes FOREIGN KEY (Curso_codigo_artes) REFERENCES Curso (codigo) on delete cascade,
CONSTRAINT pk_codigo_artes       PRIMARY KEY (Curso_codigo_artes));

CREATE TABLE Matricula(
codigo_matricula integer not null,
data_matricula   datetime not null,
valor_matricula  decimal(4) not null,
status_matricula varchar(10) not null,
Aluno_cpf        varchar(11) not null,
CONSTRAINT fk_aluno_cpf              FOREIGN KEY (Aluno_cpf)    REFERENCES Aluno (cpf),
CONSTRAINT pk_codigo_matricula       PRIMARY KEY (codigo_matricula));

CREATE TABLE CursoMatricula(
Matricula_codigo_matricula integer not null,
Curso_codigo               integer not null,
CONSTRAINT fk_codigo_matricula_curso FOREIGN KEY (Matricula_codigo_matricula) REFERENCES Matricula(codigo_matricula) on delete cascade,
CONSTRAINT fk_codigo_curso_matricula FOREIGN KEY (Curso_codigo) REFERENCES Curso(codigo) on delete cascade,
CONSTRAINT pk_codigo_matricula_curso       PRIMARY KEY (Matricula_codigo_matricula, Curso_codigo));



CREATE TABLE SisAcesso(
Aluno_cpf    varchar(11),
tipo_usuario integer not null,
login     varchar(45) not null,
senha     varchar(20) not null,
CONSTRAINT fk_cpf_aluno       FOREIGN KEY (Aluno_cpf) REFERENCES Aluno(cpf),
CONSTRAINT pk_login           PRIMARY KEY (login));

CREATE TABLE LogMatricula(
Matricula_codigo_matricula integer not null,
data                       datetime not null,
/*nome_atendente             varchar(45) not null,*/
operacao                   varchar(20),
CONSTRAINT fk_codigo_matricula       FOREIGN KEY (Matricula_codigo_matricula) REFERENCES Matricula(codigo_matricula),
/*CONSTRAINT fk_nome_atendente         FOREIGN KEY (nome_atendente) REFERENCES SisAcesso(login),*/
CONSTRAINT pk_codigo_matricula       PRIMARY KEY (Matricula_codigo_matricula));