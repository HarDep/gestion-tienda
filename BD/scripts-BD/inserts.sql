USE proyecto_bases;

INSERT INTO municipios (id_municipio, nombre_municipio) VALUES (1, 'tunja');
INSERT INTO municipios (id_municipio, nombre_municipio) VALUES (2, 'paipa');
INSERT INTO municipios (id_municipio, nombre_municipio) VALUES (3, 'sogamoso');
INSERT INTO municipios (id_municipio, nombre_municipio) VALUES (4, 'duitama');
INSERT INTO municipios (id_municipio, nombre_municipio) VALUES (5, 'ventaquemada');

INSERT INTO roles_empleado (id_rol_empleado, nombre_rol_empleado) VALUES (1, 'supervisor principal');
INSERT INTO roles_empleado (id_rol_empleado, nombre_rol_empleado) VALUES (2, 'repartidor');
INSERT INTO roles_empleado (id_rol_empleado, nombre_rol_empleado) VALUES (3, 'vendedor');
INSERT INTO roles_empleado (id_rol_empleado, nombre_rol_empleado) VALUES (4, 'almacenista');
INSERT INTO roles_empleado (id_rol_empleado, nombre_rol_empleado) VALUES (5, 'cajero');

INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (1, 'LUN', '08:00:00', 5);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (2, 'LUN', '14:00:00', 5);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (3, 'MAR', '07:00:00', 5);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (4, 'MAR', '14:00:00', 4);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (5, 'MIE', '08:30:00', 4);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (6, 'MIE', '14:00:00', 3);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (7, 'JUE', '08:00:00', 4);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (8, 'JUE', '13:00:00', 5);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (9, 'VIE', '08:00:00', 5);
INSERT INTO horarios (id_horario, dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES (10, 'SAB', '08:00:00', 4);

INSERT INTO categorias_producto (id_categoria_producto, nombre_categoria_producto) VALUES (1, 'salsas');
INSERT INTO categorias_producto (id_categoria_producto, nombre_categoria_producto) VALUES (2, 'embutidos');
INSERT INTO categorias_producto (id_categoria_producto, nombre_categoria_producto) VALUES (3, 'lacteos');
INSERT INTO categorias_producto (id_categoria_producto, nombre_categoria_producto) VALUES (4, 'panes');
INSERT INTO categorias_producto (id_categoria_producto, nombre_categoria_producto) VALUES (5, 'congelados');

INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0001', 1, 'salsa de tomate', 'salsa de tomate para consumo');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0002', 2, 'chorizo aumado', 'chorizo aumado paquete 5 unidades');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0003', 2, 'jamon iberico', 'jamos iberico 500 gr');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0004', 3, 'queso mozzarella', 'queso mozzarella 500 gr');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0005', 3, 'crema de leche', 'crema de leche 250 gr');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0006', 4, 'pan para hamburguesa', 'pan para hamburguesa paquete 8 unidades');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0007', 4, 'pan para perro', 'pan para perro paquete 10 unidades');
INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0008', 5, 'papa prefritas', 'paquete de papa prefritas');

INSERT INTO lotes (id_lote, fecha_lote) VALUES (1, '2023-11-02');
INSERT INTO lotes (id_lote, fecha_lote) VALUES (2, '2023-11-01');
INSERT INTO lotes (id_lote, fecha_lote) VALUES (3, '2023-10-31');
INSERT INTO lotes (id_lote, fecha_lote) VALUES (4, '2023-10-30');
INSERT INTO lotes (id_lote, fecha_lote) VALUES (5, '2023-10-29');

INSERT INTO sujetos (id_sujeto, nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES (1, 'JCHT1', '3157577757', 'MEE');
INSERT INTO sujetos (id_sujeto, nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES (2, 'felipe', '3167577757', 'PER');
INSERT INTO sujetos (id_sujeto, nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES (3, 'distribuidora carnes sa', '74082828', 'EMP');
INSERT INTO sujetos (id_sujeto, nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES (4, 'pepito', '3128577757', 'PER');
INSERT INTO sujetos (id_sujeto, nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES (5, 'indu lacteos boyaca', '3127587857', 'EMP');