-- crear usuario --
CREATE USER ControlViajes IDENTIFIED BY admin;

-- otorgar todos los privilegios --
GRANT ALL PRIVILEGES TO ControlViajes;

-- las tablas fueron creadas mediante la aplicacion --
-------   SERVICIO CONTROL DE VIAJES ---

-- consultar tablas --
SELECT * FROM PASAJERO;
SELECT * FROM DESTINO;

-- generar un commit --
COMMIT;