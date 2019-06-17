package ar.edu.undec.UseCase;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import ar.edu.undec.sistema_cuenta_bancaria.MockitoExtension;
import ar.edu.undec.entidades.Cliente;
import ar.edu.undec.repositorio.IRepositorioCrearCliente;
@ExtendWith(MockitoExtension.class)
class crearClienteUnitTest {
    @Mock
    IRepositorioCrearCliente crearClienteGateway;
   
    
    @test
    public void crearCliente_ClienteNoExiste_GuardaCorrectamente()throws ClienteIncompletoException, ClienteExisteException{
    	Cliente clienteNuevo=Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(crearClienteGateway.guardar(ClienteNuevo)).thenReturn(true);
    	CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteGateway);
    	boolean resultado  = crearClienteUseCase.crearCliente(clienteNuevo);
    	Assertions.assertTrue(resultado);
    }
 
    @test
    public void crearCliente_ClienteExiste_ClienteExisteException()throws ClienteIncompletoException{
    	Cliente clienteNuevo = Cliente.factoryCliente("Juan Perez", "12345678", "3825-577050", "calle falsa 123",LocalDate.of(1990, 2, 20));
    	when(crearClienteGateway.findByDNI("12345678")).thenReturn(Cliente.factoryCliente("Lopez Carlos", "12345678", "3825-394827", "san Roman 123", LocalDate.of(1980, 12, 10)));
    	CrearClienteUseCase crearClienteUseCase = CrearClienteUseCase(crearClienteGateway);
    	Assertions.assertThrows(ClienteExisteException.class,()-> crearClienteUseCase.crearCluente(clienteNuevo));
    }


}
