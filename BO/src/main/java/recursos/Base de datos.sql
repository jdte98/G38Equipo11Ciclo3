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
#Comando para eliminar la tabla clientes si llega a existir con el mismo nombre
DROP TABLE IF EXISTS CLIENTES;

#Crear la tabla
create table if not exists clientes(
	cedula_cliente bigint primary key,
    direccion_cliente varchar(255),
    email_cliente varchar(255) UNIQUE NOT NULL,
    nombre_cliente varchar(255) NOT NULL,
    telefono_cliente varchar(255) NOT NULL
);

 #Insertar datos en la tabla
insert into clientes values (001,'street1','client1@mail.com','cliente 1','7000001');
insert into clientes values (002,'street2','client2@mail.com','cliente 2','7000002');
insert into clientes values (003,'street3','client3@mail.com','cliente 3','7000003');

#Mostrar la tabla
select * from clientes;

