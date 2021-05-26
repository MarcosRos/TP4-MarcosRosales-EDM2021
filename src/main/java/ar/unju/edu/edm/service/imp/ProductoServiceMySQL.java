package ar.unju.edu.edm.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.repository.IProductoDAO;
import ar.unju.edu.edm.service.ProductoService;

@Service
@Qualifier("impprodmysql")
public class ProductoServiceMySQL implements ProductoService{

	@Autowired
	Producto unProducto;
	
	@Autowired
	IProductoDAO productoDAO;
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		productoDAO.save(unProducto);
	}

	@Override
	public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(Producto productoAEliminar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerUnProducto(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return productoDAO.findById(id).orElseThrow(()->new Exception("El producto NO existe"));
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (ArrayList<Producto>) productoDAO.findAll();
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

}
