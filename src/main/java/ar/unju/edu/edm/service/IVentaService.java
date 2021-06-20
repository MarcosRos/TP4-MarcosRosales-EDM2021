package ar.unju.edu.edm.service;

import java.util.List;
import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.model.Venta;

@Service
public interface IVentaService {

	public void guardarVenta(Venta unaVenta, Producto unProducto);
	public Venta crearVenta();
	public List<Venta> obtenerTodaVenta();
	public Venta encontrarUnaVenta(int id) throws Exception;
}