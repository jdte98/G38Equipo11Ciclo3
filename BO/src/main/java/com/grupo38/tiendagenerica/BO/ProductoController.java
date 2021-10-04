package com.grupo38.tiendagenerica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo38.tiendagenerica.DAO.ProductoDAO;
import com.grupo38.tiendagenerica.DTO.ProductoVO;
@RestController
public class ProductoController {

	 // @GetMapping obtener o buscar
	 // @PostMapping insertar o agregar
	 // @PutMapping modificar o actualizar
	 // @DeleteMapping eliminar o borrar
	 
	@PostMapping("/registrarproducto")
	public void registrarProducto(ProductoVO producto) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.registrarProducto(producto);
	}
	
	@GetMapping("/consultarproducto")
	public ArrayList<ProductoVO> consultarProducto(Integer code) {
		ProductoDAO Dao = new ProductoDAO();
		return Dao.consultarProducto(code);
	}
	
	@GetMapping("/listarproductos")
	public ArrayList<ProductoVO> listaDeProductos(){
		ProductoDAO Dao = new ProductoDAO();
		return Dao.listaDeProductos();
	}
	
	@DeleteMapping("/eliminarproducto")
	public void eliminarProducto(Integer code) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.eliminarProducto(code);
	}
	
	@DeleteMapping("/eliminartodoproducto")
	public void eliminarTodoProducto() {
		ProductoDAO Dao = new ProductoDAO();
		Dao.eliminarTodoProducto();
	}
	
	@PutMapping("/actualizarproducto")
	public void actualizarProducto(ProductoVO producto) {
		ProductoDAO Dao = new ProductoDAO();
		Dao.actualizarProducto(producto);
	}

}
