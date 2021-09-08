USE vehiculosespaciales;
SELECT 'Consulta1';
SELECT * FROM capitan ORDER BY c_nombre;

USE vehiculosespaciales;
SELECT 'Consulta2';
SELECT cliente.c_nombre, cliente.c_especie, cliente.c_genero, alquiler.a_fecha, alquiler.a_duracion, alquiler.a_costo
FROM capitan
INNER JOIN transporte ON capitan.c_transporte = transporte.t_matricula
INNER JOIN vehiculo ON transporte.t_matricula = vehiculo.v_matricula
INNER JOIN alquiler ON alquiler.a_vehiculo = vehiculo.v_matricula
INNER JOIN cliente ON alquiler.a_cliente = cliente.c_identidad
WHERE capitan.c_nombre = 'Jango Fett';

SELECT 'Consulta3';
SELECT MAX(v_longitud)
FROM alquiler
INNER JOIN vehiculo ON alquiler.a_vehiculo = vehiculo.v_matricula
WHERE alquiler.a_ocasion = 'El Ataque de los Clones';

SELECT 'Consulta4';
SELECT capitan.c_nombre, COUNT(alquiler.a_id) AS viajes, AVG(alquiler.a_costo)
FROM capitan
INNER JOIN transporte ON capitan.c_transporte = transporte.t_matricula
INNER JOIN vehiculo ON transporte.t_matricula = vehiculo.v_matricula
INNER JOIN alquiler ON alquiler.a_vehiculo = vehiculo.v_matricula
GROUP BY capitan.c_licencia
HAVING viajes >= 4;

SELECT 'Consulta5';
SELECT a_ocasion, COUNT(a_id) as numeroViajes, sum(a_costo) as recaudoTotal, SUM(a_duracion) as duracionTotal
FROM alquiler
GROUP BY a_ocasion
ORDER BY duracionTotal DESC;

USE vehiculosespaciales;
SELECT 'Consulta6';
SELECT cliente.c_nombre,SUM(alquiler.a_duracion)
FROM alquiler
INNER JOIN cliente ON alquiler.a_cliente = cliente.c_identidad
GROUP BY c_nombre
HAVING c_nombre != 'Ahsoka Tano'
ORDER BY SUM(a_duracion) DESC
LIMIT 5;

SELECT 'Consulta7';
SELECT vehiculo.v_nombre, ligero.l_androide, SUM(alquiler.a_costo) AS total
FROM ligero
INNER JOIN vehiculo ON ligero.l_matricula = vehiculo.v_matricula
INNER JOIN alquiler ON alquiler.a_vehiculo = vehiculo.v_matricula
GROUP BY vehiculo.v_nombre
HAVING ligero.l_androide IS NOT NULL
ORDER BY total ASC;


