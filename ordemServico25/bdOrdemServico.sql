create database dbos2025;
use dbos2025;

create table tbusuarios(
	iduser int primary key,
    usuario varchar(15) not null,
    fone varchar(15),
    login varchar(150) not null unique,
    senha varchar(250) not null,
    perfil varchar(20) not null
);
select * from tbusuarios;
describe tbusuarios;
insert into tbusuarios (iduser, usuario, fone, login, senha, perfil)
values (1,"yas araujo", "66996687701", "yas araujo","senha","Admin");

create table tbclientes(
	idcli int primary key auto_increment,
    nomecli varchar (50) not null,
    endcli varchar(100),
    fonecli varchar(15) not null,
    emailcli varchar(50) unique
);
insert into tbclientes (nomecli, endcli, fonecli, emailcli)
values ("Taylor Swift", "Cornelia Street", "66-99999-1313", "mastermind13@gmail.com:");
select * from tbclientes;

create table tbos(
	os int primary key auto_increment,
    data_os timestamp default current_timestamp,
    tipo varchar(15) not null,
    situacao varchar(20) not null,
    equipamento varchar(150) not null,
    defeito varchar(150),
    servico varchar(150),
    tecnico varchar(30),
    valor decimal(10, 2),
    idcli int not null,
    foreign key(idcli) references tbclientes(idcli)
);
