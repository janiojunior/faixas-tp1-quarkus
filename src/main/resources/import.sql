insert into faixa (nome, preco) values('Faixa Branca', 100.0);
insert into faixa (nome, preco) values('Faixa Azul', 110.0);
insert into faixa (nome, preco) values('Faixa Roxa', 120.0);
insert into faixa (nome, preco) values('Faixa Maron', 130.0);
insert into faixa (nome, preco) values('Faixa Preta', 140.0);

insert into estado (nome, sigla) values('Tocantins', 'TO');
insert into estado (nome, sigla) values('Goiás', 'GO');
insert into estado (nome, sigla) values('São Paulo', 'SP');
insert into estado (nome, sigla) values('Rio de Janeiro', 'RJ');

insert into municipio (nome, id_estado) values('Palmas', 1);
insert into municipio (nome, id_estado) values('Paraiso', 1);
insert into municipio (nome, id_estado) values('Porto Nacional', 1);

insert into Pessoa(nome) values ('Leandra');
insert into Pessoa(nome) values ('Fredson');

insert into PessoaFisica(id, cpf, sexo) values (1, '111', 1);
insert into PessoaFisica(id, cpf, sexo) values (2, '222', 2);

insert into Usuario(username, senha, perfil) values ('janio', '0cctg7WgpEz7kC/AzVC+KX+bZLPXDtgJDqWWZWnmzHH+7Na2YVxYYSFPxcf7ImAjqfNckx0aT4n5qKM7WEoeEQ==', 1);
insert into Usuario(username, senha, perfil) values ('carloshenrique', '0cctg7WgpEz7kC/AzVC+KX+bZLPXDtgJDqWWZWnmzHH+7Na2YVxYYSFPxcf7ImAjqfNckx0aT4n5qKM7WEoeEQ==', 2);