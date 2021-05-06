package ar.unju.edu.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	ProductoService iProductoService;

	@GetMapping("/producto")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return ("producto");
	}

	@PostMapping("/producto")
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "resultado";
	}

	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		// model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		return ("redirect:/producto");
	}
	
	@GetMapping("/mostrar")
	public String mostrarProductos(Model model) {
		return ("resultado");
	}
}