#Comando para crear la base de datos
create database tienda;
#Comando que siempre se debe ejecutar antes de trabajar en las tablas de la base de datos 
use tienda;

#-----------------------------------------Crear la tabla de usuarios---------------------------
#Comando para crear la tabla 
create table usuarios(
	cedula_usuario bigint primary key,
    email_usuario varchar(255),
    nombre_usuario varchar(255),
    password varchar(255) not null,
    usuario varchar(255) not null
);
 #Comandos para que el correo y el usuario nunca se repitan
create unique index email_usuario on usuarios(cedula_usuario);
create unique index usuario on usuarios(cedula_usuario);

#Comandos para ingresar datos a la tabla
insert into usuarios values (000,'admin123456@gmail.com','Admin Inicial','admin123456','admininicial');
insert into usuarios values (001,'name1@gmail.com','Name 1','pass','user');
insert into usuarios values (002,'name2@gmail.com','Name 2','pass2','user2');
insert into usuarios values (003,'name3@gmail.com','Name 3','pass3','user3');
insert into usuarios values (004,'name4@gmail.com','Name 4','pass4','user4');
insert into usuarios values (005,'name5@gmail.com','Name 5','pass5','user5');

#Comando para ver la tabla con los datos
select * from usuarios;
drop table usuarios;

#----------------------------------Tabla de clientes------------------------------
DROP TABLE IF EXISTS CLIENTES;

create table if not exists clientes(
	cedula_cliente bigint primary key,
    direccion_cliente varchar(255),
    email_cliente varchar(255) UNIQUE NOT NULL,
    nombre_cliente varchar(255) NOT NULL,
    telefono_cliente varchar(255) NOT NULL
);

insert into clientes values (001,'street1','client1@mail.com','cliente 1','7000001');
insert into clientes values (002,'street2','client2@mail.com','cliente 2','7000002');
insert into clientes values (003,'street3','client3@mail.com','cliente 3','7000003');
insert into clientes values (004,'street4','client4@mail.com','cliente 4','7000004');
insert into clientes values (005,'street5','client5@mail.com','cliente 5','7000005');

select * from clientes;

#----------------------------------Tabla de Proveedores------------------------------
CREATE TABLE proveedores ( 
nitproveedor BIGINT PRIMARY KEY,
ciudad_proveedor VARCHAR (255) NOT NULL,
direccion_proveedor VARCHAR (255) NOT NULL,
nombre_proveedor VARCHAR (255) NOT NULL,
telefono_proveedor VARCHAR (255) NOT NULL
);

drop table proveedores;

INSERT INTO proveedores VALUES (001, 'ciudad 1','Calle 1','Proveedor 1','3000000001');
INSERT INTO proveedores VALUES (002, 'ciudad 2','Calle 2','Proveedor 2','3000000002'); 
INSERT INTO proveedores VALUES (003, 'ciudad 3','Calle 3','Proveedor 3','3000000003');
INSERT INTO proveedores VALUES (004, 'ciudad 4','Calle 4','Proveedor 4','3000000004');
INSERT INTO proveedores VALUES (005, 'ciudad 5','Calle 5','Proveedor 5','3000000005');

select * from proveedores;

#----------------------------------Tabla de productos------------------------------
CREATE TABLE productos(
codigo_producto BIGINT PRIMARY KEY,
iva_compra DOUBLE NOT NULL,
nitproveedor BIGINT NOT NULL,
nombre_producto VARCHAR(255) NOT NULL,
precio_compra DOUBLE NOT NULL,
precio_venta DOUBLE NOT NULL,
foreign key (nitproveedor) REFERENCES proveedores(nitproveedor)
);

select * from productos;

