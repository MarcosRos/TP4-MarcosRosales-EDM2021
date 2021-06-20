package ar.unju.edu.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.unju.edu.edm.model.Venta;

@Repository
public interface IVentaDAO extends CrudRepository<Venta, Integer>{

	@Query("from Venta v order by v.idVenta")
	public List<Venta> obtenerVentas();
	
	public Optional<Venta> findByIdVenta(Integer id);
}
