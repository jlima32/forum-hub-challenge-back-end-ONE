CREATE TABLE usuarios (

    id bigint auto_increment PRIMARY KEY,
    nome varchar(50) not null,
    email varchar(100) not null,
    senha varchar(25) not null

);