create schema lojadeinstrumentos;	

use lojadeinstrumentos;

create table cliente(
      nome varchar(50) NOT NULL,
      id_cliente int   primary key auto_increment ,
      cpf varchar (14)  NOT NULL unique,
      dataNasc Date NOT NULL ,
      cep varchar (10) NOT NULL ,
      endereco varchar (50) NOT NULL,
      numero int  NOT NULL,
      complemento varchar (15),
      bairro varchar (15) NOT NULL,
	  celular varchar (18) NOT NULL,
	  sexo varchar (10) NOT NULL,
      estadocivil varchar (10) NOT NULL,
      email varchar (50) NOT NULL
      );
select * from cliente;
describe  cliente;

create table produto (
id_produto int primary key auto_increment ,
quantidade_produto int not null,
produto   varchar(15) unique,
valor_produto decimal (9,2)
);
select * from produto;
describe produto;
CREATE TABLE venda (
   id_venda INT PRIMARY KEY AUTO_INCREMENT,
   id_cliente int NOT NULL,
   valor_total DECIMAL(9,2) NOT NULL,
   data_venda DATE NOT NULL,
   FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);
desc venda;
select * from venda;
SELECT * FROM venda WHERE data_venda BETWEEN '2023/05/01' AND '2023/05/31';
SELECT v.id_venda, v.data_venda, v.valor_total, c.id_cliente, c.nome AS nome_cliente
FROM venda v
INNER JOIN cliente c ON v.id_cliente = c.id_cliente
WHERE v.data_venda BETWEEN '2023-05-01' AND '2023-05-31';

SELECT iv.id_ItemVenda, iv.quantidade_produto, iv.valor_produto,
       p.produto AS nome_produto,
       v.id_venda, v.data_venda, v.valor_total,
       c.id_cliente, c.nome AS nome_cliente
FROM itemvenda iv
INNER JOIN produto p ON iv.id_produto = p.id_produto
INNER JOIN venda v ON iv.id_Venda = v.id_venda
INNER JOIN cliente c ON v.id_cliente = c.id_cliente
WHERE v.data_venda BETWEEN '2023-05-01' AND '2023-05-31' ORDER BY iv.id_ItemVenda;

create table itemvenda(
id_ItemVenda INT NOT NULL AUTO_INCREMENT,
id_produto int not null,
id_Venda int not null,
quantidade_produto  int not null,
valor_produto decimal (9,2)not null,
primary key(id_ItemVenda),
foreign key(id_produto) references Produto(id_produto),
foreign key(id_Venda) references venda(id_Venda)
);
select * from venda ;
select * from itemvenda;
describe itemvenda;
