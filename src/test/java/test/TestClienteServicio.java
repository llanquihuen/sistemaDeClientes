package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class TestClienteServicio {
	private static Logger logger = Logger.getLogger("cl.desafiolatam.servicios.ServicioPersonaTest");
	private final ClienteServicio clienteServicio = new ClienteServicio(new ArrayList<Cliente>());
	
	@Test
	public void agregarClienteTest() {
		logger.info("Test agregar Cliente");
		Cliente clientePrueba = new Cliente("11.111.111-1", "Juan","Perez", "1 Año", CategoriaEnum.ACTIVO);
		Cliente respuestaServicio = clienteServicio.agregarCliente(clientePrueba);
		assertEquals(clientePrueba,respuestaServicio);
	}
	
	@Test
	public void agregarClienteNullTest() {
		logger.info("Test Cliente Nulo");
		Cliente clientePrueba = null;
		Cliente respuestaNulo = clienteServicio.agregarCliente(null);
		assertEquals(clientePrueba,respuestaNulo);
	}
}
