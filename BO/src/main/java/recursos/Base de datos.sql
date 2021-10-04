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
insert into usuarios values (001,'name1@gmail.com','Name 1','admin123456','admininicial');
insert into usuarios values (002,'name2@gmail.com','Name 2','pass','user');
insert into usuarios values (003,'name3@gmail.com','Name 3','pass1','user1');

#Comando para ver la tabla con los datos
select * from usuarios;

#----------------------------------Crear tabla de clientes------------------------------
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


select * from clientes;
CREATE TABLE proveedores ( 
nitproveedor BIGINT PRIMARY KEY,
ciudad_proveedor VARCHAR (255) NOT NULL,
direccion_proveedor VARCHAR (255) NOT NULL,
nombre_proveedor VARCHAR (255) NOT NULL,
telefono_proveedor VARCHAR (255) NOT NULL
);
INSERT INTO proveedorers VALUES (001, 'bogota','las brisas','postobon','3114155447');
INSERT INTO proveedorers VALUES (002, 'bogota','las brisas','postobon','3114155447');
INSERT INTO proveedorers VALUES (003, 'bogota','las brisas','postobon','3114155447');
INSERT INTO proveedorers VALUES (004, 'bogota','las brisas','postobon','3114155447');
INSERT INTO proveedorers VALUES (005, 'bogota','las brisas','postobon','3114155447'); 

CREATE TABLE productos(
codigo_producto BIGINT PRIMARY KEY,
iva_compra DOUBLE NOT NULL,
nitproveedor BIGINT NOT NULL,
nombre_producto VARCHAR(255) NOT NULL,
precio_compra DOUBLE NOT NULL,
precio_venta DOUBLE NOT NULL,
foreign key (nitproveedor) REFERENCES proveedores(nitproveedor)
);

INSERT INTO productos VALUES(201,0.19,1,'leche entera', 2000.0,3000.0);


