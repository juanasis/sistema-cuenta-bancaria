package ar.edu.undec.entidades;

import java.time.LocalDate;

import ar.edu.undec.Exception.ClienteIncompletoException;

public class Cliente {
	private Integer idCliente;
	private String nombre;
	private String documento;
	private String domicilio;
	private String telefono;
	private LocalDate fechaNacimiento;
	
	private Cliente(Integer idCliente, String nombre, String documento, String telefono, String domicilio, LocalDate fechaNacimiento) {
		
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.documento = documento;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.fechaNacimiento = fechaNacimiento;
	}

	public static Cliente factoryCliente(Integer idCliente, String nombre, String documento,String telefono, String domicilio, LocalDate fechaNacimiento)throws ClienteIncompletoException  {
		 if(idCliente==null || nombre==null || documento==null || domicilio==null ||telefono==null || fechaNacimiento == null){
            throw new ClienteIncompletoException();
        }
        else{
            return new Cliente(idCliente,nombre,documento,telefono,domicilio,fechaNacimiento);
        }

	}
}


	
	
	
	
	

