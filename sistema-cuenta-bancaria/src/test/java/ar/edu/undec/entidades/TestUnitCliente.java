package ar.edu.undec.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ar.edu.undec.Exception.ClienteIncompletoException;

class TestUnitCliente {

	@Test
	public void factoryCliente_TodosLosAtributosOk_instanciaCorrecta() throws ClienteIncompletoException {
		Cliente unCliente =Cliente.factoryCliente(1, "Juan Perez", "12345678", "San Martin 100","3825-124356",LocalDate.of(1990, 2, 01));
		Assertions.assertNotNull(unCliente);
	
	}
    @Test
    public void factoryCliente_MenorDeEdad_ClienteIncompletoException(){
        Assertions.assertThrows(ClienteIncompletoException.class, ()-> Cliente.factoryCliente(null,null,null,"Perez","123456",null));
    }
}




