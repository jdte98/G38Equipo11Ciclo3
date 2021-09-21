package com.grupo38.tiendagenerica.DAO;

import java.sql.*;

public class Conexion {
	
	//Parametros de conexión
	static String nombre_base_datos = "tienda";
	static String usuariodb = "root";
	static String clavebd = "Homero120555";
	static String url ="jdbc:mysql://127.0.0.1/" + nombre_base_datos;
	
	//Objeto sin inicializar de la conexion
	Connection connection = null;
	
	//constructor 
	public Conexion() {
		try {
			//Obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
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
