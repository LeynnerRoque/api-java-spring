create table paciente
(

    id            bigint       not null auto_increment,
    nome          varchar(100) not null,
    email         varchar(100) not null unique,
    cpf           varchar(6)   not null unique,

    primary key (id)

);


create table consultas
(

    id                 bigint       not null auto_increment,
    idMedico          bigint not null,
    idPaciente         bigint not null,

    primary key (id)

);