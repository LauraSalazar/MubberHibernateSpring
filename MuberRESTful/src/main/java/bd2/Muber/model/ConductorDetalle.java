package bd2.Muber.model;

public class ConductorDetalle {

	private String nombre;
	private long viajes;
	private double promedio;
	private String fechaLicencia;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getViajes() {
		return viajes;
	}

	public void setViajes(long viajes) {
		this.viajes = viajes;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	public String getFechaLicencia() {
		return fechaLicencia;
	}

	public void setFechaLicencia(String fechaLicencia) {
		this.fechaLicencia = fechaLicencia;
	}

	public ConductorDetalle(String nombre, Long viajes, double promedio, String fechaLicencia) {
		this.setNombre(nombre);
		this.setViajes(viajes);
		this.setFechaLicencia(fechaLicencia);
		this.setPromedio(promedio);
	}

}
