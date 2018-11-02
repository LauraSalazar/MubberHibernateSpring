package bd2.Muber.dto;

import bd2.Muber.model.Conductor;

public class ConductorDTO {

	public ConductorDTO(Conductor c) {
		super();
		this.contrasena = c.getContrasena();
		this.idUsuario = c.getIdUsuario();
		this.dni = c.getDni();
		this.fechaIngreso = c.getFechaIngreso();
		this.licencia = c.getLicencia();
		this.fechaLicencia = c.getFechaLicencia();
		this.nombre = c.getNombre();
	}

	public Integer getIdUsuario() {
		return idUsuario;
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

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getFechaLicencia() {
		return fechaLicencia;
	}

	public void setFechaLicencia(String fechaLicencia) {
		this.fechaLicencia = fechaLicencia;
	}

	public long getViajesRealizados() {
		return viajesRealizados;
	}

	public Double getPuntajePromedio() {
		return puntajePromedio;
	}

	public void setPuntajePromedio(Double puntajePromedio) {
		this.puntajePromedio = puntajePromedio;
	}

	public void setViajesRealizados(long viajesRealizados) {
		this.viajesRealizados = viajesRealizados;
	}

	private Integer idUsuario;
	private String nombre;
	private String dni;
	private String contrasena;
	private String fechaIngreso;
	private String licencia;
	private String fechaLicencia;
	private Long viajesRealizados;
	private Double puntajePromedio;

}
