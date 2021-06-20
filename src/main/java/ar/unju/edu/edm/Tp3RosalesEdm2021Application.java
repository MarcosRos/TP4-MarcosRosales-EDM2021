package ar.unju.edu.edm;

import java.time.LocalDate;

//import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.unju.edu.edm.model.Cliente;
import ar.unju.edu.edm.service.IClienteService;


@SpringBootApplication
public class Tp3RosalesEdm2021Application implements CommandLineRunner{
	@Autowired
	@Qualifier("impmysql")
	IClienteService clienteService;
	@Autowired
	Cliente cliente;
	public static void main(String[] args) {
		SpringApplication.run(Tp3RosalesEdm2021Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		//inicializo un cliente para pruebas
				/*cliente.setNroDocumento(100001);
				cliente.setNombre("user");
				cliente.setTipoDocumento("DNI");				
				cliente.setEmail("Marcos@gmail.com");
				cliente.setPassword("123456");	
				cliente.setFechaNacimiento(LocalDate.now());							
				clienteService.guardarCliente(cliente);*/
//					
	}
}
