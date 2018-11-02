package bd2.Muber.dto;

import bd2.Muber.model.Pasajero;

public class PasajeroDTO {

	private Integer idUsuario;
	private String nombre;
	private String dni;
	private String contrasena;
	private String fechaIngreso;
	private Double dineroDisponible;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public PasajeroDTO(Pasajero p) {
		super();
		this.idUsuario = p.getIdUsuario();
		this.nombre = p.getNombre();
		this.dni = p.getDni();
		this.contrasena = p.getContrasena();
		this.fechaIngreso = p.getFechaIngreso();
		this.dineroDisponible = p.getDineroDisponible();
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(Double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
}
