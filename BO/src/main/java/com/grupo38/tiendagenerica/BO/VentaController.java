package com.grupo38.tiendagenerica.BO;

import  java.util.ArrayList ;
import  org.springframework.web.bind.annotation.DeleteMapping ;
import  org.springframework.web.bind.annotation.GetMapping ;
import  org.springframework.web.bind.annotation.PostMapping ;
import  org.springframework.web.bind.annotation.PutMapping ;
import  org.springframework.web.bind.annotation.RestController ;

import com.grupo38.tiendagenerica.VentaDAO ;
import com.grupo38.tiendagenerica.DTO.VentaVO ;



@RestController
 VentaController public class  {
	
	/ *
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * * /

	@PostMapping ( " / registrarventa " )
	pública  vacío  registrarVenta ( Ventavo  venta ) {
		VentaDAO  Dao  =  nuevo  VentaDAO ();
		Dao . registrarVenta (venta);
	}

	@GetMapping ( " / listarventas " )
	public  ArrayList < VentaVO >  listaDeVentas () {
		VentaDAO  Dao  =  nuevo  VentaDAO ();
		devuelve  Dao . listaDeVentas ();
	}

	@DeleteMapping ( " / eliminarventa " )
	public  void  eliminarVenta ( Integer  codigo_venta ) {
		VentaDAO  Dao  =  nuevo  VentaDAO ();
		Dao . eliminarVenta (codigo_venta);
	}

	@PutMapping ( " / actualizarventa " )
	public  void  actualizarVenta ( VentaVO  venta ) {
		VentaDAO  Dao  =  nuevo  VentaDAO ();
		Dao . actualizarVenta (venta);
	}
	
	
	@GetMapping ( " / contadorventa " )
	public  Integer  contadorVentas () {
		VentaDAO  Dao  =  nuevo  VentaDAO ();
		devuelve  Dao . contadorVentas ();
	}
	
	
}
