USE proyecto_bases;

INSERT INTO municipios (nombre_municipio) VALUES ('tunja');
INSERT INTO municipios (nombre_municipio) VALUES ('paipa');
INSERT INTO municipios (nombre_municipio) VALUES ('sogamoso');
INSERT INTO municipios (nombre_municipio) VALUES ('duitama');
INSERT INTO municipios (nombre_municipio) VALUES ('ventaquemada');

INSERT INTO roles_empleado (nombre_rol_empleado) VALUES ('supervisor principal');
INSERT INTO roles_empleado (nombre_rol_empleado) VALUES ('repartidor');
INSERT INTO roles_empleado (nombre_rol_empleado) VALUES ('vendedor');
INSERT INTO roles_empleado (nombre_rol_empleado) VALUES ('almacenista');
INSERT INTO roles_empleado (nombre_rol_empleado) VALUES ('cajero');

INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('LUN', '08:00:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('LUN', '14:30:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('MAR', '08:00:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('MAR', '14:30:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('MIE', '08:00:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('MIE', '14:30:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('JUE', '08:00:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('JUE', '14:30:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('VIE', '08:00:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('VIE', '14:30:00', 5);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('SAB', '08:00:00', 4);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('SAB', '14:00:00', 4);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('LUN', '08:30:00', 3);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('MIE', '15:00:00', 4);
INSERT INTO horarios (dia_semana_horario, hora_inicio_horario, numero_horas_horario) VALUES ('VIE', '10:00:00', 2);

INSERT INTO categorias_producto (nombre_categoria_producto) VALUES ('salsas');
INSERT INTO categorias_producto (nombre_categoria_producto) VALUES ('embutidos');
INSERT INTO categorias_producto (nombre_categoria_producto) VALUES ('lacteos');
INSERT INTO categorias_producto (nombre_categoria_producto) VALUES ('panes');
INSERT INTO categorias_producto (nombre_categoria_producto) VALUES ('congelados');

INSERT INTO productos (codigo_producto, id_categoria_producto, nombre_producto, descripcion_producto) VALUES 
('PR0001', 1, 'salsa de tomate', 'salsa de tomate 1000 ml');
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
('PR0008', 5, 'papa prefritas', 'paquete de papa prefritas 1kg');

INSERT INTO lotes (fecha_lote) VALUES ('2023-11-02');
INSERT INTO lotes (fecha_lote) VALUES ('2023-11-01');
INSERT INTO lotes (fecha_lote) VALUES ('2023-10-31');
INSERT INTO lotes (fecha_lote) VALUES ('2023-10-30');
INSERT INTO lotes (fecha_lote) VALUES ('2023-10-29');

INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto) VALUES ('JCHT1', '3157577757', 'MEE');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('felipe', '3167577757', 'PER', 'alvarez', '123331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, nit_empresa) 
VALUES ('distribuidora sa', '74082828', 'EMP', 'NIT1212');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3128577757', 'PER', 'perez', '153331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, nit_empresa) 
VALUES ('indu lacteos sa', '3127587857', 'EMP', 'NIT1213');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado1', '3128577657', 'PER', 'apellido1', '123631');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado2', '3128977757', 'PER', 'apellido2', '823331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado3', '3108577757', 'PER', 'apellido3', '123931');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado4', '3128574757', 'PER', 'apellido4', '123301');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado5', '3128507757', 'PER', 'apellido5', '173331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado6', '3128577707', 'PER', 'apellido6', '223331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('empleado7', '3129577757', 'PER', 'apellido7', '123339');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3128556757', 'PER', 'apellido8', '122331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3128577897', 'PER', 'apellido9', '123371');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3128589957', 'PER', 'apellido10', '903331');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3122337757', 'PER', 'apellido11', '129131');
INSERT INTO sujetos (nombre_sujeto, telefono_sujeto, tipo_sujeto, apellido_persona, numero_documento_persona) 
VALUES ('pepito', '3456577757', 'PER', 'apellido12', '123390');

INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (6,1,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (6,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (6,5,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (7,2,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (7,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (8,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (8,5,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (9,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (10,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (10,4,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (10,5,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (11,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (12,3,1);
INSERT INTO empleados_roles (id_empleado, id_rol_empleado, es_activo_empleado_rol) VALUES (12,5,1);

INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (6,13,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (6,14,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (6,15,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (7,1,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (8,1,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (9,2,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (10,2,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (6,3,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (10,3,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (12,4,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (12,5,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (9,5,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (8,6,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (7,6,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (10,7,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (12,8,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (11,8,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (10,9,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (8,9,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (12,10,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (11,10,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (8,10,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (11,11,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (10,11,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (11,12,1);
INSERT INTO empleados_horarios (id_empleado, id_horario, es_activo_empleado_horario) VALUES (12,12,1);

INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0001',3, 1.1);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0002',3, 5.9);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0003',3, 3.7);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0005',3, 2.1);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0006',3, 4.5);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0007',3, 4.2);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0008',3, 3.8);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0004',5, 4.3);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0005',5, 2.3);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0006',4, 4.2);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0007',4, 3.9);
INSERT INTO productos_proveedores (codigo_producto, id_proveedor, precio_producto_proveedor) VALUES ('PR0008',4, 3.5);

INSERT INTO ventas (id_cliente, id_empleado, fecha_hora_venta) VALUES (1,1,'2023-11-14');