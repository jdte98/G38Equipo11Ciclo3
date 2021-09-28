package com.grupo38.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo38.tiendagenerica.DTO.ProveedorVO;


public class ProveedorDAO {
	
	public void resgistrarProveedor(ProveedorVO Proveedor) {
			
			Conexion conex = new Conexion();
			
			try {
				Statement estatuto = conex.getConnection().createStatement();
				String sentencia = "INSERT INTO proveedor VALUES(" 
						+ proveedor.getnit_proveedores() + "," + "'"
						+ proveedor.getciudad_proveedores() + "'," + "'" 
						+ proveedor.getdireccion_proveedores() + "'," + "'" 
						+ proveedor.getnombre_proveedores()+ "'," + "'" 
						+ proveedor.getTelefono_proveedores() + "'" 
						+ ");";
				estatuto.executeUpdate(sentencia);
				System.out.println("Registrado "+ sentencia);

				estatuto.close();
				conex.desconectar();
			} catch(SQLException e) {
				//Si hay un error en el SQL
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR SQL¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("No fue posible ingresar el proveedor");
				System.out.println(e.getMessage());
				System.out.println(e.getErrorCode());
			} catch(Exception e) {
				//Si hay algun otro error
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("No se pudo ingresar el proveedor");
				System.out.println(e.getMessage());
				System.out.println(e.getLocalizedMessage());			
			}
			
			
		}
	
	public ArrayList<ProveedorVO> consultarProveedor(Integer nit_proveedor){
		
		ArrayList<ProveedorVO> listaproveedores = new ArrayList<ProveedorVO>();
		//Conexion
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * "
					+ "FROM clientes WHERE cedula_cliente = ?");
			consulta.setInt(1, nit_proveedor);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				ProveedorVO Proveedor = new ProveedorVO();
				Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nitproveedor")));
				Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
				
				listaproveedores.add(Proveedor);
				
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());			
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible ingresar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return listaproveedores;
	}
	
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ArrayList<ProveedorVO> listaproveedores = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			
			
			while (res.next()) {
				ProveedorVO Cliente = new ProveedorVO();
				Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nitproveedor")));
				Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
				Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
				Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
				Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));
				
				listaproveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los proveedores");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No fue posible consultar todos los proveedores");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaproveedores;
	}

	public void eliminarProveedor(Integer nit_proveedor) {
		Conexion conex = new Conexion();
		try {
			Statement consulta = conex.getConnection().createStatement();
			String sentencia = "DELETE FROM clientes WHERE nit_proveedor =" + nit_proveedor + ";";
			
			System.out.println("Registrado " + sentencia);
			
			consulta.execute(sentencia);
			
			consulta.close();
			conex.desconectar();
			
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public void actualizarProveedor(ProveedorVO provee) {
		//Iniciar la conexión
		Conexion conex = new Conexion();
		
		try {
			//Iniciando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			String sentencia = "UPDATE proveedores "
					+ "SET direccion_proveedor = '"+ provee.getDireccion_proveedor()
					+"', ciudad_proveedor = '" + provee.getCiudad_proveedor()
					+"', nombre_proveedor = '" + provee.getNombre_proveedor()
					+"', telefono_proveedor = '"+ provee.getTelefono_proveedor()
					+"' WHERE nitproveedor = "+ provee.getNit_proveedor()
					+";";
			estatuto.executeUpdate(sentencia);
			System.out.println("Registrado " + sentencia);
			
			estatuto.close();
			conex.desconectar();
			
		} catch(SQLException e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch(Exception e) {
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬ERROR¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("No se actualizo el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
	}
	
}