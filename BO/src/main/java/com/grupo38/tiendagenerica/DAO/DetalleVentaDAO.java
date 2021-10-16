package com.grupo38.tiendagenerica.DAO;

import java.sql.*;
import java.util.ArrayList;
import com.grupo38.tiendagenerica.DTO.DetalleVentaVO;

public class DetalleVentaDAO {
	public void registrarDetalleVenta(DetalleVentaVO detalleventa) {
		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();

			String sentencia = "INSERT INTO detalle_ventas VALUES(" + detalleventa.getCodigo_detalle_venta() + "," + detalleventa.getCantidad_producto()
					+ "," + detalleventa.getCodigo_producto() + "," + detalleventa.getCodigo_producto() + "," + detalleventa.getCodigo_venta() + ","
					+ detalleventa.getValor_total() + "," + detalleventa.getValor_venta() + "," + detalleventa.getValoriva() + "" + ");";

			
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

	public ArrayList<DetalleVentaVO> listaDeDetalleVenta() {
		
		ArrayList<DetalleVentaVO> listadetalle_ventas = new ArrayList<DetalleVentaVO>();

		
		Conexion conex = new Conexion();

		try {
			
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas");

			
			ResultSet res = consulta.executeQuery();

			
			while (res.next()) {
				DetalleVentaVO venta = new DetalleVentaVO();
				venta.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
				venta.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
				venta.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				venta.setValor_total(Double.parseDouble(res.getString("valor_total")));
				venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
				venta.setValoriva(Double.parseDouble(res.getString("valoriva")));

				listadetalle_ventas.add(venta);
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

		return listadetalle_ventas;
	}

	public void eliminarDetalleVenta(Integer codigo_detalleventa) {

		
		Conexion conex = new Conexion();

		try {
			
			Statement consulta = conex.getConnection().createStatement();

			
			String sentencia = "delete from detalle_ventas where codigo_detalle_venta=" + codigo_detalleventa + ";";

			
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

	public void actualizarDetalleVenta(DetalleVentaVO detalleventa) {

		
		Conexion conex = new Conexion();

		try {
			
			Statement estatuto = conex.getConnection().createStatement();

			
			String sentencia = "UPDATE detalle_ventas " + 
					"SET cantidad_producto = " + detalleventa.getCantidad_producto()+ ", " 
					+ "valor_total = " + detalleventa.getValor_total() + ", "
					+ "valor_venta = " + detalleventa.getValor_venta() + ", "
					+ "valoriva = " + detalleventa.getValoriva()+ " "
					+ "WHERE codigo_detalle_venta = " + detalleventa.getCodigo_detalle_venta()+ ";";

			
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

	public int contadorDetalleVenta() {
		
		int contador = 0;

		
		Conexion conex = new Conexion();

		try {
			
			PreparedStatement consulta = conex.getConnection().prepareStatement("select COUNT(*) FROM detalle_ventas;");

			
			ResultSet res = consulta.executeQuery();

			
			while (res.next()) {
				contador = (res.getInt("COUNT(*)")) + 1;
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
