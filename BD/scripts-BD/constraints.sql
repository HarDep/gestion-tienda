USE proyecto_bases;

ALTER TABLE municipios ADD CONSTRAINT pk_municipios PRIMARY KEY (id_municipio);

ALTER TABLE roles_empleado ADD CONSTRAINT pk_rolesemp PRIMARY KEY (id_rol_empleado);

ALTER TABLE sujetos ADD
    CONSTRAINT pk_sujetos PRIMARY KEY (id_sujeto),
    CONSTRAINT fk_sujetos_mun FOREIGN KEY (id_municipio) REFERENCES municipios (id_municipio),
    CONSTRAINT unq_sujetos_tel UNIQUE (telefono_sujeto),
    CONSTRAINT chk_sujetos_tipo CHECK (tipo_sujeto IN ('EMP', 'PER', 'MEE')),
    CONSTRAINT chk_sujetos_atrib CHECK (
        (tipo_sujeto IN ('PER') AND apellido_persona IS NOT NULL AND numero_documento_persona IS NOT NULL) OR
        (tipo_sujeto IN ('EMP') AND nit_empresa IS NOT NULL) OR tipo_sujeto IN ('MEE'));

CREATE UNIQUE NONCLUSTERED INDEX unq_sujetos_nit ON sujetos (nit_empresa) WHERE nit_empresa IS NOT NULL;
CREATE UNIQUE NONCLUSTERED INDEX unq_sujetos_doc ON sujetos (numero_documento_persona) WHERE numero_documento_persona IS NOT NULL;

ALTER TABLE empleados_roles ADD
    CONSTRAINT pk_emplsrols PRIMARY KEY (id_empleado, id_rol_empleado),
    CONSTRAINT fk_emplsrols_emp FOREIGN KEY (id_empleado) REFERENCES sujetos (id_sujeto),
    CONSTRAINT fk_emplsrols_rol FOREIGN KEY (id_rol_empleado) REFERENCES roles_empleado (id_rol_empleado);

ALTER TABLE horarios ADD
    CONSTRAINT pk_horarios PRIMARY KEY (id_horario),
    CONSTRAINT chk_horarios_dias CHECK (dia_semana_horario IN ('LUN', 'MAR', 'MIE', 'JUE', 'VIE', 'SAB', 'DOM')),
    CONSTRAINT chk_horarios_hors CHECK (numero_horas_horario > 0);

ALTER TABLE empleados_horarios ADD
    CONSTRAINT pk_empshors PRIMARY KEY (id_empleado, id_horario),
    CONSTRAINT fk_empshors_emp FOREIGN KEY (id_empleado) REFERENCES sujetos (id_sujeto),
    CONSTRAINT fk_empshors_tur FOREIGN KEY (id_horario) REFERENCES horarios (id_horario);

ALTER TABLE categorias_producto ADD CONSTRAINT pk_catgsprod PRIMARY KEY (id_categoria_producto);

ALTER TABLE productos ADD
    CONSTRAINT pk_productos PRIMARY KEY (codigo_producto),
    CONSTRAINT fk_productos_catg FOREIGN KEY (id_categoria_producto) REFERENCES categorias_producto (id_categoria_producto);

ALTER TABLE lotes ADD 
    CONSTRAINT pk_lotes PRIMARY KEY (id_lote),
    CONSTRAINT chk_lotes_fec CHECK (fecha_lote <= GETDATE());

ALTER TABLE compras ADD
    CONSTRAINT pk_compras PRIMARY KEY (id_compra),
    CONSTRAINT fk_compras_prov FOREIGN KEY (id_proveedor) REFERENCES sujetos (id_sujeto),
    CONSTRAINT fk_compras_lote FOREIGN KEY (id_lote) REFERENCES lotes (id_lote),
    CONSTRAINT chk_compras_fec CHECK (fecha_hora_compra <= SYSDATETIME());

ALTER TABLE ventas ADD
    CONSTRAINT pk_ventas PRIMARY KEY (id_venta),
    CONSTRAINT fk_ventas_emp FOREIGN KEY (id_empleado) REFERENCES sujetos (id_sujeto),
    CONSTRAINT fk_ventas_clie FOREIGN KEY (id_cliente) REFERENCES sujetos (id_sujeto),
    CONSTRAINT chk_ventas_fec CHECK (fecha_hora_venta <= SYSDATETIME()),
    CONSTRAINT chk_ventas_entg CHECK (fecha_hora_entrega_venta > fecha_hora_venta),
    CONSTRAINT chk_ventas_entgpr CHECK (precio_entrega_venta > 0);

ALTER TABLE productos_proveedores ADD
    CONSTRAINT pk_prodsprovs PRIMARY KEY (codigo_producto, id_proveedor),
    CONSTRAINT fk_prodsprovs_prod FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto),
    CONSTRAINT fk_prodsprovs_prov FOREIGN KEY (id_proveedor) REFERENCES sujetos (id_sujeto),
    CONSTRAINT chk_prodsprovs_prec CHECK (precio_producto_proveedor > 0);

ALTER TABLE productos_compras ADD
    CONSTRAINT pk_prodscomps PRIMARY KEY (codigo_producto, id_compra),
    CONSTRAINT fk_prodscomps_prod FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto),
    CONSTRAINT fk_prodscomps_comp FOREIGN KEY (id_compra) REFERENCES compras (id_compra),
    CONSTRAINT chk_prodscomps_prec CHECK (precio_producto_compra > 0),
    CONSTRAINT chk_prodscomps_cant CHECK (cantidad_producto_compra > 0),
    CONSTRAINT chk_prodscomps_venc CHECK (fecha_vencimiento_producto_compra > GETDATE());

ALTER TABLE productos_ventas ADD
    CONSTRAINT pk_prodsvents PRIMARY KEY (codigo_producto, id_venta),
    CONSTRAINT fk_prodsvents_prod FOREIGN KEY (codigo_producto) REFERENCES productos (codigo_producto),
    CONSTRAINT fk_prodsvents_vent FOREIGN KEY (id_venta) REFERENCES ventas (id_venta),
    CONSTRAINT chk_prodsvents_prec CHECK (precio_producto_venta > 0),
    CONSTRAINT chk_prodsvents_cant CHECK (cantidad_producto_venta > 0);

-- triggers, solo puedo ejecutar los trigger uno por uno

CREATE TRIGGER emps_rols_validator ON empleados_roles FOR INSERT AS
BEGIN
    DECLARE @id_empleado AS INT = (SELECT id_empleado FROM INSERTED)
    IF EXISTS (SELECT * FROM sujetos WHERE id_sujeto = @id_empleado AND tipo_sujeto NOT LIKE 'PER')
    BEGIN
        RAISERROR ('El empleado ingresado no es una persona', 16, 1)
        ROLLBACK TRANSACTION
    END
END

CREATE TRIGGER emps_hors_validator ON empleados_horarios FOR INSERT AS
BEGIN
    DECLARE @id_empleado AS INT = (SELECT id_empleado FROM INSERTED)
    IF EXISTS (SELECT * FROM sujetos WHERE id_sujeto = @id_empleado AND tipo_sujeto NOT LIKE 'PER')
    BEGIN
        RAISERROR ('El empleado ingresado no es una persona', 16, 1)
        ROLLBACK TRANSACTION
    END
END

CREATE TRIGGER ventas_validator ON ventas FOR INSERT AS
BEGIN
    DECLARE @id_empleado AS INT = (SELECT id_empleado FROM INSERTED)
    IF EXISTS (SELECT * FROM sujetos WHERE id_sujeto = @id_empleado AND tipo_sujeto NOT LIKE 'PER')
    BEGIN
        RAISERROR ('Venta no valida por empleado no valido', 16, 1)
        ROLLBACK TRANSACTION
    END
END

CREATE TRIGGER compras_validator ON compras FOR INSERT AS
BEGIN
    DECLARE @id_proveedor AS INT = (SELECT id_proveedor FROM INSERTED)
    IF EXISTS (SELECT * FROM sujetos WHERE id_sujeto = @id_proveedor AND tipo_sujeto LIKE 'MEE')
    BEGIN
        RAISERROR ('Compra no valida, proveedor no valido', 16, 1)
        ROLLBACK TRANSACTION
    END
END

-- trigger para verficar stock
/*
CREATE TRIGGER stock_validator ON productos_compras FOR INSERT AS
BEGIN
    DECLARE @id_venta AS INT = (SELECT id_venta FROM INSERTED)
    DECLARE @codigo_producto AS NVARCHAR(255) = (SELECT codigo_producto FROM INSERTED)
END
*/