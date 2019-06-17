package ar.edu.undec.UseCase;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;

import ar.edu.undec.entidades.Cliente;
import ar.edu.undec.repositorio.IRepositorioCrearCliente;

public class updateClienteUnitTest {
	 @Mock
	    IRepositorioCrearCliente updateClienteGateway;
	@test
	public void modificarNombre_InstanciaCorrecta_NombreModificado() throws ClienteIncompletoException{
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(updateClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	UpdateCliente clienteNuevoModificado= new UpdateCliente(updateClienteGateway);
    	boolean resultado=clienteNuevoModificado.modificarNombre(clienteNuevo.setNombre("Juan Pablo Perez"));
    	Assertions.assertTrue(resultado);
	}
	@test
	public void modificarDocumento_InstanciaCorrecta_DocumentoModificado() throws ClienteIncompletoException{
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(updateClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	UpdateCliente clienteNuevoModificado= new UpdateCliente(updateClienteGateway);
    	boolean resultado=clienteNuevoModificado.modificarDocumento(clienteNuevo.setDocumento("1231238"));
    	Assertions.assertTrue(resultado);
	}
	@test
	public void modificarDomicilio_InstanciaCorrecta_DomicilioModificado() throws ClienteIncompletoException{
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(updateClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	UpdateCliente clienteNuevoModificado= new UpdateCliente(updateClienteGateway);
    	boolean resultado=clienteNuevoModificado.modificarDomicilio(clienteNuevo.setDomicilio("Av Siempreviva 742 "));
    	Assertions.assertTrue(resultado);
	}
	@test
	public void modificarTelefono_InstanciaCorrecta_TelefonoModificado() throws ClienteIncompletoException{
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(updateClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	UpdateCliente clienteNuevoModificado= new UpdateCliente(updateClienteGateway);
    	boolean resultado=clienteNuevoModificado.modificarTelefono(clienteNuevo.setTelefono("3825-523620"));
    	Assertions.assertTrue(resultado);
	}
	@test
	public void modificarFechaDeNacimiento_InstanciaCorrecta_FechaDeNacimientoModificada() throws ClienteIncompletoException{
		Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(updateClienteGateway.guardar(clienteNuevo)).thenReturn(true);
    	UpdateCliente clienteNuevoModificado= new UpdateCliente(updateClienteGateway);
    	boolean resultado=clienteNuevoModificado.modificarFechaDeNacimiento(clienteNuevo.setFechaDeNacimiento(LocalDate.of(1990, 2, 19)));
    	Assertions.assertTrue(resultado);
	}
}
