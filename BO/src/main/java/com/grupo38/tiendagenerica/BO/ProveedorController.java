package com.grupo38.tiendagenerica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo38.tiendagenerica.DAO.ProveedorDAO;
import com.grupo38.tiendagenerica.DTO.ProveedorVO;

@RestController
public class ProveedorController {

	 // @GetMapping obtener o buscar
	 // @PostMapping insertar o agregar
	 // @PutMapping modificar o actualizar
	 // @DeleteMapping eliminar o borrar
	 
	@PostMapping("/registrarproveedor")
	public void registrarProveedor(ProveedorVO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.resgistrarProveedor(proveedor);
	}
	
	@GetMapping("/consultarproveedores")
	public ArrayList<ProveedorVO> consultarProveedor(Integer nitproveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.consultarProveedor(nitproveedor);
	}
	
	@GetMapping("/listarproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ProveedorDAO Dao = new ProveedorDAO();
		return Dao.listaDeProveedores();
	}
	
	@DeleteMapping("/eliminarproveedor")
	public void eliminarCliente(Integer nitproveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.eliminarProveedor(nitproveedor);
	}
	
	@PutMapping("/actualizarproveedor")
	public void actualizarProveedor(ProveedorVO proveedor) {
		ProveedorDAO Dao = new ProveedorDAO();
		Dao.actualizarProveedor(proveedor);
	}

}
