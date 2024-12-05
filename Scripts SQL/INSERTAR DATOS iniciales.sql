insert into usuario (id_login,contrasena,nombre,apellido) values ('bedel_prueba1', '$2a$10$GNSeI6qYWnOdOWVluqaWQ.pdm2gNUPHC1VwBDJExvS7sDPnY7cIKe'/*contraseña: Bedel_prueba1$*/, 'bedel', 'prueba');
insert into usuario (id_login,contrasena,nombre,apellido) values ('bedel_prueba2', '$2a$10$4tiIF1RBLc01duBvB8tYgOpAZnvqSCR2cO.oTK3PkKE6/K.xG5.o2'/*contraseña: Bedel_prueba2$*/, 'bedel', 'prueba');
insert into usuario (id_login,contrasena,nombre,apellido) values ('Admin','$2a$10$yNBczGnUsKjUACLs3EfZ.OnkKUWuZ9otvhEfG9NJPadXAMCamnaUG'/*contraseña: Admin_general$1*/,'Admin','Admin');

insert into bedel values (1, 'NOCHE', true);
insert into bedel values(2,'MAÑANA',true);

insert into administrador values(3);

insert into cuatrimestre (fecha_inicio_cuatrimestre,fecha_fin_cuatrimestre) values ('2024-03-27','2024-07-06');
insert into cuatrimestre (fecha_inicio_cuatrimestre,fecha_fin_cuatrimestre) values ('2024-08-06','2024-12-04');

insert into aula_general (tipo,ubicacion,estado,capacidad,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado) values ('multimedios','2° piso aula 15',true,50,2,'tiza',true,true,true);
insert into aula_general (tipo,ubicacion,estado,capacidad,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado) values ('laboratorio','1° piso aula 10',true,25,1,'fibron',true,true,true);

insert into aula_laboratorio values (2,15);
insert into aula_multimedios values (1,true,true,true);