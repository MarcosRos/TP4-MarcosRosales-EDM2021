package ar.unju.edu.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Producto;
import ar.unju.edu.edm.model.Venta;
import ar.unju.edu.edm.repository.IProductoDAO;
import ar.unju.edu.edm.repository.IVentaDAO;
import ar.unju.edu.edm.service.IVentaService;

@Service
@Qualifier("impventamysql")
public class VentaServiceMySQL  implements IVentaService{
	@Autowired
	Venta venta;

	@Autowired
	IVentaDAO iVentaDAO;
	
	@Autowired
	IProductoDAO productoDAO;

		@Override
		public void guardarVenta(Venta unaVenta, Producto unProducto) {
			// TODO Auto-generated method stub
			int calculo=unProducto.getStock()-unaVenta.getCantProductos();
			unProducto.setStock(calculo);
			productoDAO.save(unProducto);
			iVentaDAO.save(unaVenta);
		}

		@Override
		public Venta crearVenta() {
			// TODO Auto-generated method stub
			return venta;
		}

		@Override
		public List<Venta> obtenerTodaVenta() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Venta encontrarUnaVenta(int id) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	}
