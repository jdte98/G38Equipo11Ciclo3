package com.grupo38.tiendagenerica.DAO;

import java.sql.*;

public class Conexion {
	
	//Parametros de conexión
	static String nombre_base_datos = "g38e11";
	static String usuariodb = "admin";
	static String clavebd = "minticroca";
	static String url ="jdbc:mysql://tiendasgenericasdr-g9-g38-53.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/" + nombre_base_datos;
	
	//Objeto sin inicializar de la conexion
	Connection connection = null;
	
	//constructor 
	public Conexion() {
		try {
			//Obtenemos el driver de para mysql
			Class.forName("org.mariadb.jdbc.Driver");
			//obtenemos la conexión
			connection = DriverManager.getConnection(url, usuariodb, clavebd);
			//Si hay conexión correcta mostrar la información en consola
			if(connection != null) {
				System.out.println("Conexión a base de datos " + nombre_base_datos + " OK\n");
			}
		} catch (SQLException e) {
			//Error de la base de datos
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			//Error en carga de clases
			System.out.println(e);
		} catch (Exception e) {
			//Cualquier otro error
			System.out.println(e);
		}
	}
	
	//Permite retornar la conexión
	public Connection getConnection() {
		return connection;
	}
	
	//Cerrando la conexión
	public void desconectar() {
		connection = null;
	}
	

}
