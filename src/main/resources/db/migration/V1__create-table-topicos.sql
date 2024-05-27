create table topicos(

    id bigint auto_increment PRIMARY KEY,
    titulo varchar(255) not null,
    mensagem TEXT not null,
    dataCriacao varchar(20) not null,
    estadoTopico varchar(20) not null,
    curso varchar(255) not null


)