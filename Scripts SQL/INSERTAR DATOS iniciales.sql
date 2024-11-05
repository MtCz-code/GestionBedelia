insert into usuario (contrasena,nombre,apellido) values (1234,'Pedro','Sanchez');
insert into usuario (contrasena,nombre,apellido) values (4321,'Santiago','Perren');
insert into usuario (contrasena,nombre,apellido) values ('admin','Admin','Admin');

insert into bedel values (1, 'NOCHE', true);
insert into bedel values(2,'DIA',true);

insert into administrador values(3);

insert into cuatrimestre (fecha_inicio_cuatrimestre,fecha_fin_cuatrimestre) values ('2024-03-27','2024-07-06');
insert into cuatrimestre (fecha_inicio_cuatrimestre,fecha_fin_cuatrimestre) values ('2024-08-06','2024-12-04');

insert into aula_general (tipo,ubicacion,estado,capacidad,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado) values ('multimedios','2° piso aula 15',true,50,2,'tiza',true,true,true);
insert into aula_general (tipo,ubicacion,estado,capacidad,piso,tipo_pizarron,ventiladores,aire_acondicionado,habilitado) values ('laboratorio','1° piso aula 10',true,25,1,'fibron',true,true,true);

insert into aula_laboratorio values (2,15);
insert into aula_multimedios values (1,true,true,true);