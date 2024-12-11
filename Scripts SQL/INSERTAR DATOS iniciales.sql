insert into usuario (id_login,contrasena,nombre,apellido) values ('bedel_prueba1', '$2a$10$GNSeI6qYWnOdOWVluqaWQ.pdm2gNUPHC1VwBDJExvS7sDPnY7cIKe'/*contraseña: Bedel_prueba1$*/, 'bedel', 'prueba');
insert into usuario (id_login,contrasena,nombre,apellido) values ('bedel_prueba2', '$2a$10$4tiIF1RBLc01duBvB8tYgOpAZnvqSCR2cO.oTK3PkKE6/K.xG5.o2'/*contraseña: Bedel_prueba2$*/, 'bedel', 'prueba');
insert into usuario (id_login,contrasena,nombre,apellido) values ('Admin','$2a$10$yNBczGnUsKjUACLs3EfZ.OnkKUWuZ9otvhEfG9NJPadXAMCamnaUG'/*contraseña: Admin_general$1*/,'Admin','Admin');

insert into bedel values (1, 'NOCHE', true);
insert into bedel values(2,'MAÑANA',true);

insert into administrador values(3);

INSERT INTO cuatrimestre (fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre)
VALUES ('2024-02-01', '2024-06-30');

INSERT INTO cuatrimestre (fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre)
VALUES ('2024-08-01', '2024-12-31');

INSERT INTO cuatrimestre (fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre)
VALUES ('2025-03-01', '2025-06-30');

INSERT INTO cuatrimestre (fecha_inicio_cuatrimestre, fecha_fin_cuatrimestre)
VALUES ('2025-08-01', '2025-12-31');

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('GENERAL', 'A1', TRUE, 30, 2, 'TIZA', TRUE, TRUE, TRUE);

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('GENERAL', 'A2', TRUE, 25, 2, 'TIZA', FALSE, TRUE, TRUE);

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('LABORATORIO', 'A3', TRUE, 40, 3, 'FIBRON', FALSE, TRUE, TRUE);

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('LABORATORIO', 'A4', TRUE, 50, 3, 'FIBRON', FALSE, TRUE, TRUE);

INSERT INTO aula_laboratorio(id_aula,cantidad_pc) VALUES (3,20);
INSERT INTO aula_laboratorio(id_aula,cantidad_pc) VALUES (4,28);

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('MULTIMEDIOS', 'A5', TRUE, 20, 1, 'FIBRON', TRUE, TRUE, TRUE);

INSERT INTO aula_general (tipo, ubicacion, estado, capacidad, piso, tipo_pizarron, ventiladores, aire_acondicionado, habilitado)
VALUES ('MULTIMEDIOS', 'A6', TRUE, 30, 1, 'TIZA', FALSE, TRUE, TRUE);

INSERT INTO aula_multimedios(id_aula,televisor,canon,computadora) VALUES(5,FALSE,TRUE,TRUE);
INSERT INTO aula_multimedios(id_aula,televisor,canon,computadora) VALUES(6,TRUE,TRUE,TRUE);

-- Insertar Reserva 1
INSERT INTO reserva (id_docente, nombre_docente, apellido_docente, email_docente, id_catedra, nombre_catedra, fecha_registro, id_bedel)
VALUES (101, 'Juan', 'Pérez', 'juan.perez@universidad.edu', 10, 'Matemáticas', NOW(), 1);

INSERT INTO reserva_periodica (id_reserva, tipo, dias_semana)
VALUES (1, 'CUATRIMESTRAL', '["LUNES"]');

INSERT INTO periodo_asignado (id_cuatrimestre, id_reserva_periodica)
VALUES (1, 1); -- Cuatrimestre 1, Reserva Periódica 1

INSERT INTO detalle_reserva (id_reserva, horario_inicio, fecha, cant_modulos, dia_reserva, id_aula)
VALUES (1, '09:00:00', '2024-01-10', 2, 'LUNES', 1);


-- Insertar Reserva 2
INSERT INTO reserva (id_docente, nombre_docente, apellido_docente, email_docente, id_catedra, nombre_catedra, fecha_registro, id_bedel)
VALUES (102, 'Ana', 'Gómez', 'ana.gomez@universidad.edu', 20, 'Física', NOW(), 2);

INSERT INTO reserva_periodica (id_reserva, tipo, dias_semana)
VALUES (2, 'CUATRIMESTRAL', '["LUNES"]');

INSERT INTO periodo_asignado (id_cuatrimestre, id_reserva_periodica)
VALUES (1, 2); 

INSERT INTO detalle_reserva (id_reserva, horario_inicio, fecha, cant_modulos, dia_reserva, id_aula)
VALUES (2, '10:30:00', '2024-01-10', 3, 'LUNES', 2);

