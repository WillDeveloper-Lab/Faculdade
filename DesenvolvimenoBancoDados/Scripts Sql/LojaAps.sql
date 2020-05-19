create database Loja;
use lojaAps;

create table Cliente(
    CODCLI integer not null AUTO_INCREMENT,
    NOME varchar(50) not null,
    BONUS varchar(1) not null,
    PERFIL integer not null,
    STATUS varchar(1) not null,
    PRIMARY KEY (`CODCLI`)
);

create table Localidade(
    CODLOCAL integer not null AUTO_INCREMENT,
    NOME varcahr(35) not null,
    ENDERECO varchar(80) not null,
    TELEFONE varchar(14) not null,
    PRIMARY KEY (`CODLOCAL`)
);

create table Produto(
    CODPROD  integer not null AUTO_INCREMENT,
    CODLOCAL integer not null,
    DESCRICAO varchar(35),
    QTD_ESTOQUE integer,
    PRECO_UNITARIO money,
    FOREIGN KEY (CODLOCAL) REFERENCES Localidade(CODLOCAL),
    PRIMARY KEY (`CODPROD`)
);

create table Venda(
    CODCLI integer not null,
    CODPROD integer not null,
    CODLOCAL integer not null,
    QTD_VENDA integer,
    VALOR_TOTAL money,
    DATA_VENDA date,
    PRIMARY KEY (`CODCLI`),
    PRIMARY KEY (`CODPROD`),
    PRIMARY KEY (`CODLOCAL`),
    FOREIGN KEY (CODCLI) REFERENCES Cliente(CODCLI),
    FOREIGN KEY (CODPROD) REFERENCES Produto(CODPROD),
    FOREIGN KEY (CODLOCAL) REFERENCES Localidade(CODLOCAL),

);