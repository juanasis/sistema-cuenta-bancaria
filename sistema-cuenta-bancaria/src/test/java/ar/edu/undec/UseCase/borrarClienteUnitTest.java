package ar.edu.undec.UseCase;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.undec.entidades.Cliente;
import ar.edu.undec.repositorio.IRepositorioCrearCliente;

class borrarClienteUnitTest {
	 @Mock
	    IRepositorioCrearCliente borrarClienteGateway;
	@Test
	void borrarCliente_InstanciaCorrecta_clienteBorrado()throws ClienteIncompletoException {
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(borrarClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	borrarCliente clienteNuevoBorrado= new borrarCliente(borrarClienteGateway);
    	boolean resultado=clienteNuevoBorrado.borrarCliente(clienteNuevo);
    	Assertions.assertTrue(resultado);
	}

}
