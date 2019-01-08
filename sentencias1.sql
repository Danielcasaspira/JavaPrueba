/*SENTENCIAS INSERT*/
INSERT INTO persona(nombre, apellido) VALUES('Juan','Perez');

INSERT INTO persona(nombre, apellido) VALUES('Karla','Esparza');

INSERT INTO persona(nombre, apellido) VALUES('Eduardo','Alvarez');

/*SENTENCIAS SELECT*/
SELECT * FROM persona;

/*SENTENCIAS UPDATE*/
UPDATE PERSONA SET nombre = 'Juanito' WHERE id_persona = 1;

/*SENTENCIAS DELETE*/
DELETE FROM PERSONA WHERE id_persona = 3;