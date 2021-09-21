package com.grupo38.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo38.tiendagenerica.DTO.UsuarioVO;

public class UsuarioDAO {
	
	
	public void resgistrarUsuario(UsuarioVO user) {
		
		//Se llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();
		
		try {
			//Sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO usuarios VALUES(" 
					+ user.getCedula_usuario() + "," + "'"
					+ user.getEmail_usuario() + "'," + "'" 
					+ user.getNombre_usuario() + "'," + "'" 
					+ user.getPassword()+ "'," + "'" 
					+ user.getUsuario() + "'" 
					+ ");";
			//Ejecutar la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			//impresión en consola para verificación
			System.out.println("Registrado "+ sentencia);
			//Cerrando la sentencia y la conexión
			estatuto.close();
			conex.desconectar();
		} catch(SQLException e) {
			//Si hay un error en el SQL
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR SQL¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible ingresar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			//Si hay algun otro error
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo ingresar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());			
		}
		
		
	}

	public ArrayList<UsuarioVO> consultarUsuario(String usuario){
		//Lista que contendra el o los usuarios
		ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
		//Conexion
		Conexion conex = new Conexion();
		try {
			//Sentencia para la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
			//Cambiamos el comodin ? por el dato que llega en el parametro
			consulta.setString(1, usuario);
			//Ejecuta la sentencia
			ResultSet res = consulta.executeQuery();
			//Crear un obejeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setCedula_usuario(Integer.parseInt("cedula_usuario"));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setPassword(res.getString("password"));
				Usuario.setUsuario(res.getString("usuario"));
				
				listausuarios.add(Usuario);
				
			}
			//Cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());			
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible ingresar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listausuarios;
	}
	
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		//Creamos una lista donde se obtendran los datos
		ArrayList<UsuarioVO> listausuarios = new ArrayList<UsuarioVO>();
		//Iniciamos la conexión par la base de datos
		Conexion conex = new Conexion();
		
		try {
			//Sentencia para la base e datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			//Ejecutamos la sentencia
			ResultSet res = consulta.executeQuery();
			
			//Creamos un objeto para cada usuario encontrado en la base de datos
			while (res.next()) {
				UsuarioVO usuario = new UsuarioVO();
				usuario.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				usuario.setEmail_usuario(res.getString("email_usuario"));
				usuario.setNombre_usuario(res.getString("nombre_usuario"));
				usuario.setPassword(res.getString("password"));
				usuario.setUsuario(res.getString("usuario"));
				
				//Añadimos los datos del usuario a la lista
				listausuarios.add(usuario);
			}
			//Cerramos la sentencia, la conexión y e l resultado
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			//Errores en SQL
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			//Cualquier otro error
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los usuarios");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listausuarios;
	}
	
	public void eliminarUsuario(Integer cedula_usuario) {
		//Iniciar la conexión 
		Conexion conex = new Conexion();
		try {
			//Sentencia para la base de datos
			Statement consulta = conex.getConnection().createStatement();
			//Sentencia que se va a realizar
			String sentencia = "DELETE FROM usuarios WHERE cedula_usuario =" + cedula_usuario + ";";
			
			//Impresión de verificación
			System.out.println("Registrado " + sentencia);
			
			//Ejecutamos la sentencia en la base de datos
			consulta.execute(sentencia);
			
			//Cerrar la sentencia y la conexión
			consulta.close();
			conex.desconectar();
			
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
	}

	public void actualizarUsuario(UsuarioVO user) {
		//Iniciar la conexión
		Conexion conex = new Conexion();
		
		try {
			//Iniciando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			String sentencia = "UPDATE usuarios "
					+ "SET email_usuario = '"+ user.getEmail_usuario()
					+"', nombre_usuario = '" + user.getNombre_usuario()
					+"', password = '"+ user.getPassword()
					+"', usuario = '"+ user.getEmail_usuario()
					+"' WHERE cedula_usuario = "+ user.getCedula_usuario()
					+";";
			//Ejecutar la sentencia
			estatuto.executeUpdate(sentencia);
			//Verificar por consola la sentencia
			System.out.println("Registrado " + sentencia);
			
			//Cerrar sentencia y conexion
			estatuto.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}
