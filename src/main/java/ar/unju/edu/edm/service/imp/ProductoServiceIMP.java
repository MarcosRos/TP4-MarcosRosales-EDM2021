package ar.unju.edu.edm.service.imp;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.service.ProductoService;

@Service
public class ProductoServiceIMP implements ProductoService{
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceIMP.class);
	
	@Autowired
	Producto unProducto;
	
	ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		listaDeProductos.add(unProducto);
	}

	@Override
	public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void eliminarProducto(Producto productoAEliminar) {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public Producto obtenerUnProducto(Integer codProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return listaDeProductos;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		int i = listaDeProductos.size() - 1;
		return listaDeProductos.get(i);
	}

	@Override
	public Producto obtenerCodigoProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(int codigo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto encontrarUnProducto(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}