package modelo;

import java.time.LocalDate;

public class Huespedes {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimienhto;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;
	public Huespedes() {
	}
	public Huespedes(Integer id, String nombre, String apellido, LocalDate fechaNacimienhto, String nacionalidad,
			String telefono, Integer idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimienhto = fechaNacimienhto;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public LocalDate getFechaNacimienhto() {
		return fechaNacimienhto;
	}
	public void setFechaNacimienhto(LocalDate fechaNacimienhto) {
		this.fechaNacimienhto = fechaNacimienhto;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	
	

}
