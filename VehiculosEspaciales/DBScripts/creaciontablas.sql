DROP DATABASE vehiculosespaciales;

CREATE SCHEMA IF NOT EXISTS vehiculosespaciales;

USE vehiculosespaciales;

DROP TABLE IF EXISTS vehiculo;
CREATE TABLE vehiculo
(
	v_matricula INT NOT NULL,
    v_nombre CHAR(50) NOT NULL,
    v_velocidad FLOAT NOT NULL,
    v_longitud FLOAT NOT NULL,
    
    PRIMARY KEY(v_matricula)
);

INSERT INTO vehiculo(v_matricula, v_nombre, v_velocidad, v_longitud)
VALUES (1,'Halcón Milenario', 75, 34.37),
		(2,'Ala-X', 100, 12.5),
        (3,'Ala-Y', 80, 14),
        (4,'Ala-A', 120, 9.6),
        (5,'Interceptor TIE', 105, 9.2),
        (6,'Esclavo 1', 70, 21.1),
        (7,'Destructor Estelar', 60, 1600),
        (8, 'Estrella de la Muerte', 10, 120000),
        (9, 'Transbordador Imperial', 50, 20),
        (10, 'Ejecutor', 40, 19000);
        
DROP TABLE IF EXISTS ligero;
CREATE TABLE ligero
(
	l_matricula INT NOT NULL,
    l_color VARCHAR(20) NOT NULL,
    l_androide VARCHAR(30),
    
    PRIMARY KEY(l_matricula),
    
    FOREIGN KEY (l_matricula)
    REFERENCES vehiculo (v_matricula)
    
    ON DELETE CASCADE
    ON UPDATE CASCADE
);	

INSERT INTO ligero(l_matricula, l_color, l_androide)
VALUES (2, 'BLANCO/ROJO', 'R2-D2'),
		(3, 'AMARILLO', 'C-3PO'),
        (4, 'ROJO', NULL),
        (5, 'NEGRO', 'ANDROIDE TIE');
        
        
DROP TABLE IF EXISTS transporte;
CREATE TABLE  transporte
(
	t_matricula INT NOT NULL,
    t_tripulantes INT NOT NULL,
    t_pasajeros INT NOT NULL,
    
    PRIMARY KEY(t_matricula),
    
    FOREIGN KEY (t_matricula)
    REFERENCES vehiculo(v_matricula)
    
	ON DELETE CASCADE
    ON UPDATE CASCADE
);        

INSERT INTO transporte(t_matricula, t_tripulantes, t_pasajeros)
VALUES (1,4,6),
		(6,1,6),
        (7,46070,0),
        (8,342953,843342),
        (9,6,20),
        (10,279144,38000);
        
        
DROP TABLE IF EXISTS capitan;
CREATE TABLE capitan
(
	c_licencia INT NOT NULL,
    c_nombre CHAR(40) NOT NULL,
    c_especie CHAR(30) NOT NULL,
    c_transporte INT NOT NULL,
    
    PRIMARY KEY(c_licencia),
    
    FOREIGN KEY(c_transporte)
    REFERENCES transporte(t_matricula)
);

INSERT INTO capitan(c_licencia, c_nombre, c_especie, c_transporte)
VALUES (1,'Han Solo', 'Humano', 1),
		(2,'Jango Fett', 'Mandaloriano', 6),
        (3,'General Grievous', 'Androide', 7),
        (4,'Grand Moff Tarkin', 'Humano', 8),
        (5,'Darth Vader', 'Humano/Androide', 9),
        (6,'Kendal Ozzel', 'Humano', 10);
        
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente
(
	c_identidad INT NOT NULL,
    c_nombre CHAR(40) NOT NULL,
	c_especie CHAR(30) NOT NULL,
    c_genero CHAR(30),
    
    PRIMARY KEY (c_identidad)
);

INSERT INTO cliente(c_identidad, c_nombre, c_especie, c_genero)
VALUES (1, 'Luke Skywalker', 'Humano', 'Masculino'),
		(2, 'Leia Organa', 'Humano', 'Femenino'),
        (3, 'Rey Skywalker', 'Humano', 'Femenino'),
		(4, 'Obi-Wan Kenobi', 'Humano', 'Masculino'),
        (5, 'Maz Kanata', 'Humanoide', 'Femenino'),
        (6, 'Anakin Skywalker', 'Humano', 'Masculino'),
        (7, 'Yoda', 'Yoda', 'Masculino'),
        (8, 'Ahsoka Tano', 'Togruta', 'Femenino'),
        (9, 'Grogu', 'Yoda', 'Masculino'),
        (10, 'Aayla Secura', "Twi'lek",	'Femenino'),
        (11, 'Chewbacca', 'Wookiee', 'Masculino'),
        (12, 'Wicket W. Warrick', 'Ewok', 'Masculino');
        
DROP TABLE IF EXISTS alquiler;
CREATE TABLE alquiler
(
	a_id INT NOT NULL,
    a_cliente INT NOT NULL,
    a_vehiculo INT NOT NULL,
    a_fecha DATETIME NOT NULL,
    a_ocasion VARCHAR(50) NOT NULL,
    a_duracion INT NOT NULL,
    a_costo DOUBLE NOT NULL,
    
    PRIMARY KEY(a_id),
    
    FOREIGN KEY(a_cliente)
    REFERENCES cliente(c_identidad),
    
    FOREIGN KEY(a_vehiculo)
    REFERENCES vehiculo(v_matricula)
);

INSERT INTO alquiler(a_id, a_cliente, a_vehiculo, a_fecha, a_ocasion, a_duracion, a_costo)
VALUES  (7110, 1, 6, '2005-05-19 00:00:00', 'La Venganza de los Sith', 4, 238.03),
		(7143, 2, 6, '2018-05-25 00:00:00', 'Han Solo', 10, 252.99),
		(7176, 3, 9, '2015-12-18 00:00:00', 'El Despertar de la Fuerza', 14, 1095.27),
        (7187, 1, 1, '2018-05-25 00:00:00', 'Han Solo', 15, 374.64),
        (7209, 4, 8, '1999-05-19 00:00:00', 'La Amenaza Fantasma', 18, 1145.38),
        (7220, 2, 9, '2018-05-25 00:00:00', 'Han Solo', 17, 839.24),
        (7242, 5, 10, '2017-12-15 00:00:00', 'Los Últimos JEDI', 17, 1396.31),
        (7253, 3, 6,'1999-05-19 00:00:00', 'La Amenaza Fantasma', 24, 826.54),
        (7264, 1, 3,'1999-05-19 00:00:00', 'La Amenaza Fantasma', 9, 427.71),
        (7275, 6, 6, '2018-05-25 00:00:00', 'Han Solo', 7, 556.67),
        (7286, 4, 6, '2015-12-18 00:00:00', 'El Despertar de la Fuerza', 9, 451.35),
        (7297, 2, 8, '1977-05-25 00:00:00', 'Una nueva esperanza', 9, 395.32),
        (7308, 7, 5, '2018-05-25 00:00:00', 'Han Solo', 13, 1099.22),
        (7319, 5, 2, '2002-05-16 00:00:00', 'El Ataque de los Clones', 11, 833.2),
        (7330, 3, 8, '2019-12-20 00:00:00', 'El Ascenso de Skywalker', 23, 528.94),
        (7341, 8, 10, '1983-05-25 00:00:00', 'El Retorno del JEDI', 11, 207.56),
        (7352, 6, 4, '2017-12-15 00:00:00', 'Los Últimos JEDI', 15, 492.47),
        (7363, 4, 8, '2016-12-16 00:00:00', 'Rogue One', 11, 742.71),
        (7374, 9, 10, '2016-12-16 00:00:00', 'Rogue One', 24, 175.44),
        (7385, 7, 2, '1983-05-25 00:00:00', 'El Retorno del JEDI', 13, 1016.47),
        (7396, 5, 4, '2016-12-16 00:00:00', 'Rogue One', 7, 19.04),
        (7407, 10, 1, '2019-12-20 00:00:00', 'El Ascenso de Skywalker', 24, 387.95),
        (7418, 8, 8, '2002-05-16 00:00:00', 'El Ataque de los Clones', 19, 1024.49),
        (7429, 6, 4, '2002-05-16 00:00:00', 'El Ataque de los Clones', 20, 444.75),
        (7451, 9, 4, '2005-05-19 00:00:00', 'La Venganza de los Sith', 4, 69.09),
        (7462, 7, 3, '1999-05-19 00:00:00', 'La Amenaza Fantasma', 7, 556.8),
        (7484, 10, 6, '2018-05-25 00:00:00', 'Han Solo', 20, 272.61),
        (7495, 8, 9, '2016-12-16 00:00:00', 'Rogue One', 6, 116.87),
        (7528, 9, 6, '1977-05-25 00:00:00', 'Una nueva esperanza', 4, 285.43),
        (7561, 10, 6, '1980-05-21 00:00:00', 'El Imperio contraataca', 28, 1377.01);
        
        