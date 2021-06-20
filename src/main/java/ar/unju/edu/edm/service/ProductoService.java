package ar.unju.edu.edm.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Producto;

@Service
public interface ProductoService {
	
	public void guardarProducto(Producto unProducto);
	public void modificarProducto(Producto productoModificado)throws Exception;
	public void eliminarProducto(int codigo) throws Exception;
	public Producto obtenerUnProducto(Integer codProducto) throws Exception;
	public ArrayList<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	Producto obtenerCodigoProducto(Integer codigo);
	public Producto encontrarUnProducto(int codigo) throws Exception;

}