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
				String sentencia = "INSERT INTO proveedores VALUES(" 
						+ Proveedor.getNit_proveedor()+ "," + "'"
						+ Proveedor.getCiudad_proveedor() + "'," + "'" 
						+ Proveedor.getDireccion_proveedor() + "'," + "'" 
						+ Proveedor.getNombre_proveedor()+ "'," + "'" 
						+ Proveedor.getTelefono_proveedor() + "'" 
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
	
	public ArrayList<ProveedorVO> consultarProveedor(Integer nitproveedor){
		
		ArrayList<ProveedorVO> listaproveedores = new ArrayList<ProveedorVO>();
		//Conexion
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * "
					+ "FROM proveedores WHERE nitproveedor = ?");
			consulta.setInt(1, nitproveedor);
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
			System.out.println("No fue posible consultar el proveedor");
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

	public void eliminarProveedor(Integer nitproveedor) {
		Conexion conex = new Conexion();
		try {
			Statement consulta = conex.getConnection().createStatement();
			String sentencia = "DELETE FROM proveedores WHERE nitproveedor =" + nitproveedor + ";";
			
			System.out.println("Eliminado " + sentencia);
			
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
	
	public void actualizarProveedor(ProveedorVO proveedor) {
		//Iniciar la conexión
		Conexion conex = new Conexion();
		
		try {
			//Iniciando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			String sentencia = "UPDATE proveedores "
					+ "SET direccion_proveedor = '"+ proveedor.getDireccion_proveedor()
					+"', ciudad_proveedor = '" + proveedor.getCiudad_proveedor()
					+"', nombre_proveedor = '" + proveedor.getNombre_proveedor()
					+"', telefono_proveedor = '" + proveedor.getTelefono_proveedor()
					+"' WHERE nitproveedor = " + proveedor.getNit_proveedor()
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