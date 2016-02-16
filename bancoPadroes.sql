
 CREATE TABLE Usuario(
	matricula VARCHAR(6) NOT NULL,
	nomeUsuario VARCHAR(50) NOT NULL,
	email VARCHAR(60) UNIQUE NOT NULL,
	senha VARCHAR(16) NOT NULL UNIQUE, 
	foto VARCHAR(100) NOT NULL,
	papel VARCHAR(35) NOT NULL,
	status BOOLEAN  DEFAULT TRUE, 
	PRIMARY KEY (matricula) 

);

CREATE TABLE Feriado(
	data DATE NOT NULL,
	nome VARCHAR(30) NOT NULL UNIQUE,
	PRIMARY KEY (nome,data)
);
-- Usuário padrão 1

INSERT INTO usuario (matricula , nomeUsuario, email,senha,foto, papel) VALUES('000000', 'admin', 'admin@gmail.com', 'admin153Chg%','jose2.jpg' ,'ADMISTRAD0R');
