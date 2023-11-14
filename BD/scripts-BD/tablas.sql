--CREATE DATABASE proyecto_bases;

USE proyecto_bases;

CREATE TABLE municipios (
    id_municipio INT NOT NULL IDENTITY(1,1),
    nombre_municipio NVARCHAR(50)
);

CREATE TABLE roles_empleado (
    id_rol_empleado INT NOT NULL IDENTITY(1,1),
    nombre_rol_empleado NVARCHAR(50)
);

CREATE TABLE empleados_roles (
    id_rol_empleado INT NOT NULL,
    id_empleado INT NOT NULL,
    es_activo_empleado_rol BIT NOT NULL
);

CREATE TABLE sujetos (
    id_sujeto INT NOT NULL IDENTITY(1,1),
    nombre_sujeto NVARCHAR(50) NOT NULL,
    telefono_sujeto NVARCHAR(20) NOT NULL,
    tipo_sujeto NCHAR(3) NOT NULL,
    id_municipio INT,
    direccion_sujeto NVARCHAR(50),
    apellido_persona NVARCHAR(50),
    numero_documento_persona NVARCHAR(50),
    nit_empresa NVARCHAR(255)
);

CREATE TABLE horarios (
    id_horario INT NOT NULL IDENTITY(1,1),
    dia_semana_horario NCHAR(3) NOT NULL,
    hora_inicio_horario TIME NOT NULL,
    numero_horas_horario SMALLINT NOT NULL
);

CREATE TABLE empleados_horarios (
    id_empleado INT NOT NULL,
    id_horario INT NOT NULL,
    es_activo_empleado_horario BIT NOT NULL
);

CREATE TABLE categorias_producto (
    id_categoria_producto INT NOT NULL IDENTITY(1,1),
    nombre_categoria_producto NVARCHAR(50) NOT NULL
);

CREATE TABLE productos (
    codigo_producto NVARCHAR(255) NOT NULL,
    id_categoria_producto INT NOT NULL,
    nombre_producto NVARCHAR(50) NOT NULL,
    descripcion_producto TEXT NOT NULL
);

CREATE TABLE lotes (
    id_lote INT NOT NULL IDENTITY(1,1),
    fecha_lote DATE NOT NULL
);

CREATE TABLE compras (
    id_compra INT NOT NULL IDENTITY(1,1),
    id_proveedor INT NOT NULL,
    id_lote INT NOT NULL,
    fecha_hora_compra DATETIME2 NOT NULL
);

CREATE TABLE ventas (
    id_venta INT NOT NULL IDENTITY(1,1),
    id_empleado INT NOT NULL,
    id_cliente INT NOT NULL,
    fecha_hora_venta DATETIME2 NOT NULL,
    fecha_hora_entrega_venta DATETIME2,
    precio_entrega_venta FLOAT
);

CREATE TABLE productos_proveedores (
    codigo_producto NVARCHAR(255) NOT NULL,
    id_proveedor INT NOT NULL,
    precio_producto_proveedor FLOAT NOT NULL
);

CREATE TABLE productos_compras (
    codigo_producto NVARCHAR(255) NOT NULL,
    id_compra INT NOT NULL,
    precio_producto_compra FLOAT NOT NULL,
    cantidad_producto_compra INT NOT NULL,
    fecha_vencimiento_producto_compra DATE
);

CREATE TABLE productos_ventas (
    codigo_producto NVARCHAR(255) NOT NULL,
    id_venta INT NOT NULL,
    precio_producto_venta FLOAT NOT NULL,
    cantidad_producto_venta INT NOT NULL
);