package ar.unju.edu.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.model.Venta;
import ar.unju.edu.edm.service.IClienteService;
import ar.unju.edu.edm.service.IVentaService;
import ar.unju.edu.edm.service.ProductoService;

@Controller
public class VentaController {

	
	@Autowired
	@Qualifier("impprodmysql")
	ProductoService iProductoService;
	
	@Autowired
	@Qualifier("impmysql")
	IClienteService clienteService;
	
	@Autowired
	Producto productoElegido;
	
	@Autowired
	@Qualifier("impventamysql")
	IVentaService ventaService;
	
	@GetMapping("/producto/ventas")
	public String mostrarVentas(Model model) {
		model.addAttribute("productos",iProductoService.obtenerTodosProductos());
		return ("venta");				
	}
	
	
	@GetMapping("/producto/vender/{codigo}")	
	public String realizarVenta(Model model, @PathVariable(name="codigo") Integer codigo) throws Exception {
		Venta venta = new Venta();		
		try {		
			productoElegido = iProductoService.obtenerCodigoProducto(codigo);			
			venta = ventaService.crearVenta();		
			venta.setProducto(productoElegido);
			model.addAttribute("venta",venta);
			model.addAttribute("clientes", clienteService.obtenerTodosClientes());
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
		}		
		return "venta-modal";
	}
	
	@PostMapping("/producto/vender")
	public String guardarNuevaVenta(@ModelAttribute("venta") Venta unaVenta, Model model) throws Exception{
		int calculo=productoElegido.getStock()-unaVenta.getCantProductos();
		
		productoElegido.setStock(calculo);
		System.out.println(productoElegido.getStock());
		ventaService.guardarVenta(unaVenta, iProductoService.encontrarUnProducto(productoElegido.getCodProducto()));
		return("redirect:/producto/ventas");
	}

}

