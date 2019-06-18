package ar.edu.undec.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import ar.edu.undec.Exception.ClienteException;
import ar.edu.undec.Exception.ClienteIncompletoException;
import ar.edu.undec.Exception.ClienteMenorDeEdadException;
import ar.edu.undec.repositorio.IDateTime;
import ar.edu.undec.sistema_cuenta_bancaria.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class TestUnitCliente {
	
	
	@Mock
	IDateTime fechaDelSistema;
	
	
		
	@Test
	public void factoryCliente_TodosLosAtributosOk_instanciaCorrecta() throws ClienteException, ClienteIncompletoException {
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 12, 12);
		Mockito.when(fechaDelSistema.getDate()).thenReturn(LocalDate.of(2019,06,06));
		Cliente unCliente = Cliente.factoryCliente(fechaDelSistema,"Thor", "39473874", "3826363-323" , "Asgard", fechaDeNacimiento);
		assertNotNull(unCliente);
	
	}
    @Test
	public void factoryCliente_MenorDe18Anios_InstanciaIncompleta() {
		LocalDate fechaNacimiento = LocalDate.of(2010, 12, 12);
		Mockito.when(fechaDelSistema.getDate()).thenReturn(LocalDate.of(2019, 06, 6));
		assertThrows(ClienteMenorDeEdadException.class, () -> Cliente.factoryCliente(fechaDelSistema,"Iron man", "20092019", "273832-233232" , "Tierra", fechaNacimiento));
	}
    @Test
	public void factoryCliente_FaltanAtributos_InstanciaIncompleta() {
		LocalDate fechaDeNacimiento = null;
		Mockito.when(fechaDelSistema.getDate()).thenReturn(LocalDate.of(2019, 06, 6));		
		assertThrows(ClienteIncompletoException.class, () -> Cliente.factoryCliente(fechaDelSistema,"", "", "" , "", fechaDeNacimiento));
	}
}




