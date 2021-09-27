package com.grupo38.tiendagenerica.DTO;

import java.io.Serializable;

public class ClienteVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer cedula_cliente;
	private String email_cliente;
	private String nombre_cliente;
	private Integer telefono_cliente;
	private String direccion_cliente;
	
	
	public Integer getcedula_cliente() {
		return cedula_cliente;
	}
	public void setcedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getemail_cliente() {
		return email_cliente;
	}
	public void setemail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getnombre_cliente() {
		return nombre_cliente;
	}
	public void setnombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public Integer getTelefono_cliente() {
		return telefono_cliente;
	}
	public void setTelefono_cliente(Integer telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	public String getDireccion_cliente() {
		return direccion_cliente;
	}
	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	
}