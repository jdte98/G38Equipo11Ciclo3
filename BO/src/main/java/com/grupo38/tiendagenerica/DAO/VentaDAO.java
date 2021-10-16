package com.grupo38.tiendagenerica.DAO;

import java.sql.*;
import java.util.ArrayList;

import com.grupo38.tiendagenerica.DTO.VentaVO;

public class VentaDAO {
	public void registrarVenta(VentaVO venta) {
		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();

			String sentencia = "INSERT INTO ventas VALUES(" + venta.getCodigo_venta() + "," + venta.getCedula_cliente()
					+ "," + venta.getCedula_usuario() + "," + venta.getIvaventa() + "," + venta.getTotal_venta() + ","
					+ venta.getValor_venta() + "" + ");";

			
			estatuto.executeUpdate(sentencia);
			
			System.out.println("Registrado " + sentencia);
			
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public ArrayList<VentaVO> listaDeVentas() {
		
		ArrayList<VentaVO> listaventas = new ArrayList<VentaVO>();

		
		Conexion conex = new Conexion();

		try {
			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");

			
			ResultSet res = consulta.executeQuery();

			
			while (res.next()) {
				VentaVO Venta = new VentaVO();
				Venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				Venta.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Venta.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Venta.setIvaventa(Double.parseDouble(res.getString("ivaventa")));
				Venta.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				Venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

				listaventas.add(Venta);
			}

			
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todas las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todas las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaventas;
	}

	public void eliminarVenta(Integer codigo_venta) {

		
		Conexion conex = new Conexion();

		try {
			
			Statement consulta = conex.getConnection().createStatement();

			
			String sentencia = "delete from ventas where codigo_venta=" + codigo_venta + ";";

			
			System.out.println("Registrado " + sentencia);

			
			consulta.execute(sentencia);

			
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public void actualizarVenta(VentaVO venta) {

		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();

			
			String sentencia = "UPDATE ventas " + "SET ivaventa = " + venta.getIvaventa() + "," + "total_venta = "
					+ venta.getTotal_venta() + "," + "valor_venta = " + venta.getValor_venta() + " "
					+ "WHERE codigo_venta = " + venta.getCedula_usuario() + ";";

			
			estatuto.executeUpdate(sentencia);

			
			System.out.println("Registrado " + sentencia);

			
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar  el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el usuario");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}

	public int contadorVentas() {
		
		int contador = 0;

		
		Conexion conex = new Conexion();

		try {
			
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT `AUTO_INCREMENT` " + "FROM  INFORMATION_SCHEMA.TABLES "
							+ "WHERE TABLE_SCHEMA = 'tiendalostiburones' " + "AND   TABLE_NAME   = 'ventas';");

			
			ResultSet res = consulta.executeQuery();

			
			while (res.next()) {
				contador = (res.getInt("AUTO_INCREMENT"));
			}

			
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar contador");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar contador");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return contador;
	}

}
