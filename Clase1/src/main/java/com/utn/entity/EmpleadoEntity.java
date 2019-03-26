package com.utn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmpleadoEntity implements Serializable{


	private static final long serialVersionUID = 5430384620754563967L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEmployee;
	 
	@Column(name="email")
	private String correo;
 
	@Column(name="firstname")
	private String nombre;
 
	@Column(name="lastname")
	private String apellido;
 
    public EmpleadoEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
    
    
	// 
}
