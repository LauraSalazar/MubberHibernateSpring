package bd2.Muber.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Conductor extends Usuario {
	
	public Conductor(String password, String dni, String fechaIngreso, String fechaLicencia, String licencia,
			String nombre) {
		super(password, dni, nombre, fechaIngreso);
		this.setFechaLicencia(fechaLicencia);
		this.setLicencia(licencia);
		this.viajes = new ArrayList<Viaje>();
	}

	public Conductor() {
		super();
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

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public Boolean agregarViaje(Viaje v) {
		Boolean retorno = false;
		try{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dateLicencia = dateFormat.parse(this.getFechaLicencia());
		Date fechaHoy = new Date();

		if(fechaHoy.after(dateLicencia)){
			this.viajes.add(v);
			System.out.println("Se agrego correctamente el viaje con origen: " + v.getOrigen() + " y destino " + v.getDestino() );	
			retorno = true;
		}
		else{
			System.out.println("El conductor " + this.getNombre() + " tiene la licencia vencida");
		}

		} 
		catch(ParseException e){
			System.out.println("La fecha " + this.getFechaLicencia() + " no es una fecha valida");
		}
		return retorno;
	}

	private String licencia;
	private String fechaLicencia;
	private List<Viaje> viajes;
}
