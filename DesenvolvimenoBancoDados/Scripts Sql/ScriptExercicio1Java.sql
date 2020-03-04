create database Loja;
use Loja;	
create table Produto(
	Id integer NOT NULL AUTO_INCREMENT,
	Nome varchar(50) NOT NULL,
	Quantidade integer NOT NULL,
	Valor double NOT NULL,
	PRIMARY KEY (`Id`)
);
INSERT into Produto (Nome,Quantidade,Valor) VALUES ("Arroz",100,3.5);
INSERT into Produto (Nome,Quantidade,Valor) VALUES ("feijao",30,3.8);
INSERT into Produto (Nome,Quantidade,Valor) VALUES ("macarrao",50,2.69);