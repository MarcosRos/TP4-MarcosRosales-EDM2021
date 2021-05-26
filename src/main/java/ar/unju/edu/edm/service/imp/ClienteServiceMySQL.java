package ar.unju.edu.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.unju.edu.edm.model.Cliente;
import ar.unju.edu.edm.repository.IClienteDAO;
import ar.unju.edu.edm.service.IClienteService;

@Service
@Qualifier("impmysql")
public class ClienteServiceMySQL implements IClienteService{
	@Autowired
	Cliente unCliente;
	
	@Autowired
	IClienteDAO clienteDAO;
	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		clienteDAO.save(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente encontrarUnCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		return clienteDAO.findByNroDocumento(dni).orElseThrow(()->new Exception("El cliente NO existe"));
	}

	@Override
	public void eliminarCliente(int dni) throws Exception {
		// TODO Auto-generated method stub
		clienteDAO.deleteByNroDocumento(dni);;
	}

	@Override
	public Cliente encontrarUnClienteId(int id) throws Exception {
		// TODO Auto-generated method stub
		return clienteDAO.findById(id).orElseThrow(()->new Exception("El cliente no existe"));
	}

	@Override
	public void modificarCliente(Cliente unCliente) throws Exception {
		// TODO Auto-generated method stub
		/*clienteAModificar.setNombre(clienteModificado.getNombre());
			clienteAModificar.setCodigoAreaTelefono(clienteModificado.getCodigoAreaTelefono());
			clienteAModificar.setEmail(clienteModificado.getEmail());
			clienteAModificar.setFechaNacimiento(clienteModificado.getFechaNacimiento());
			clienteAModificar.setNroDocumento(clienteModificado.getNroDocumento());
			clienteAModificar.setNumTelefono(clienteModificado.getNumTelefono());
			clienteAModificar.setTipoDocumento(clienteModificado.getTipoDocumento());*/
	}

}
