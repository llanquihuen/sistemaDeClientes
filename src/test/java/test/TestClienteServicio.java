package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class TestClienteServicio {
	private static Logger logger = Logger.getLogger("sistemaDeClientes.test.ServicioPersonaTest");
	private final ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>());
	
	Cliente clienteTest = new Cliente("11.111.11-1", "Juan","Perez", "1 Año", CategoriaEnum.ACTIVO);
	Cliente clienteNullTest = null;
	
	@Test
	public void agregarClienteTest() {
		logger.info("Test agregar Cliente");
		String returnClienteTest = clienteServicio.agregarCliente(clienteTest);
		assertEquals("OK",returnClienteTest);
	}
	
	@Test
	public void agregarClienteNullTest() {
		logger.info("Test Cliente Nulo");
		String returnClienteNull = clienteServicio.agregarCliente(clienteNullTest);
		assertEquals("NULO",returnClienteNull);
	}
}
