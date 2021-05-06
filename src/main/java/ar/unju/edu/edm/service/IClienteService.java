package ar.unju.edu.edm.service;

import java.util.List;

import ar.unju.edu.edm.model.Cliente;

public interface IClienteService {
	public void guardarCliente(Cliente unCliente);
	public Cliente crearCliente();
	public List<Cliente> obtenerTodosClientes();

}
