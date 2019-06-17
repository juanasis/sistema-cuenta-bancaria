package ar.edu.undec.entidades;

import org.junit.jupiter.api.Assertions;

public class TestUnitCuentaBancaria {
	
	@test
	factoryCuenta_todosLosAtributos_instanciaCorrecta()throws CuentaCorrienteInconmpletaException{
		CuentaCorriente unaCuenta = CuentaCorriente("Juan Perez","20-12345678-4");
		Assertions.assertNotNull(unaCuenta);
	}
	@test
	factoryCuenta_FaltaAlgunAtributo_instanciaIncorrecta(){
		
		Assertions.assertThrows(CuentaBancariaIncompletaException.class, ()-> CuentaBancaria.factoryCuenta(null,"20-12345678-4"));
	}
}