package com.grupo38.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo38.tiendagenerica.DTO.ClienteVO;


public class ClienteDAO {
	
	public void resgistrarCliente(ClienteVO client) {
			
			Conexion conex = new Conexion();
			
			try {
				Statement estatuto = conex.getConnection().createStatement();
				String sentencia = "INSERT INTO clientes VALUES(" 
						+ client.getcedula_cliente() + "," + "'"
						+ client.getDireccion_cliente() + "'," + "'" 
						+ client.getemail_cliente() + "'," + "'" 
						+ client.getnombre_cliente()+ "'," + "'" 
						+ client.getTelefono_cliente() + "'" 
						+ ");";
				estatuto.executeUpdate(sentencia);
				System.out.println("Registrado "+ sentencia);

				estatuto.close();
				conex.desconectar();
			} catch(SQLException e) {
				//Si hay un error en el SQL
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR SQL¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("No fue posible ingresar el cliente");
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
			} catch(Exception e) {
				//Si hay algun otro error
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("No se pudo ingresar el cliente");
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());			
			}
			
			
		}
	
	public ArrayList<ClienteVO> consultarCliente(Integer cedula_cliente){
		//Lista que contendra el o los clientes
		ArrayList<ClienteVO> listaclientes = new ArrayList<ClienteVO>();
		//Conexion
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * "
					+ "FROM clientes WHERE cedula_cliente = ?");
			consulta.setInt(1, cedula_cliente);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setcedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
				Cliente.setemail_cliente(res.getString("email_cliente"));
				Cliente.setnombre_cliente(res.getString("nombre_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				
				listaclientes.add(Cliente);
				
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());			
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible ingresar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return listaclientes;
	}
	
	public ArrayList<ClienteVO> listaDeClientes(){
		ArrayList<ClienteVO> listaclientes = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet res = consulta.executeQuery();
			
			//Creamos un objeto para cada cliente encontrado en la base de datos
			while (res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setcedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Cliente.setDireccion_cliente(res.getString("direccion_cliente"));
				Cliente.setemail_cliente(res.getString("email_cliente"));
				Cliente.setnombre_cliente(res.getString("nombre_cliente"));
				Cliente.setTelefono_cliente(res.getString("telefono_cliente"));
				
				listaclientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los clientes");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaclientes;
	}

	public void eliminarCliente(Integer cedula_cliente) {
		Conexion conex = new Conexion();
		try {
			Statement consulta = conex.getConnection().createStatement();
			String sentencia = "DELETE FROM clientes WHERE cedula_cliente =" + cedula_cliente + ";";
			
			System.out.println("Registrado " + sentencia);
			
			consulta.execute(sentencia);
			
			consulta.close();
			conex.desconectar();
			
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public void actualizarCliente(ClienteVO client) {
		//Iniciar la conexión
		Conexion conex = new Conexion();
		
		try {
			//Iniciando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			String sentencia = "UPDATE clientes "
					+ "SET direccion_cliente = '"+ client.getDireccion_cliente()
					+"', email_cliente = '" + client.getemail_cliente()
					+"', nombre_cliente = '" + client.getnombre_cliente()
					+"', telefono_cliente = '"+ client.getTelefono_cliente()
					+"' WHERE cedula_cliente = "+ client.getcedula_cliente()
					+";";
			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			
			estatuto.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el cliente");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}