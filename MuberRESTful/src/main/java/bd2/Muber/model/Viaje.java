package bd2.Muber.model;

import java.util.ArrayList;
import java.util.List;

public class Viaje {

	public Viaje(Integer cant_pasajeros, String origen, String destino, Double costo_total) {
		super();
		this.setCant_pasajeros(cant_pasajeros);
		this.setOrigen(origen);
		this.setDestino(destino);
		this.setCostoTotal(costo_total);
		this.calificaciones = new ArrayList<Calificacion>();
		this.pasajeros = new ArrayList<Pasajero>();
		this.finalizado = false;
	}

	public Viaje() {
		super();
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getCant_pasajeros() {
		return cant_pasajeros;
	}

	public void setCant_pasajeros(Integer cant_pasajeros) {
		this.cant_pasajeros = cant_pasajeros;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public String agregarCalificacion(Calificacion calif) {
		String ok = "0";
		//Verifico que al pasajero de la calificacion le corresponda calificar
		if (this.getPasajeros().contains(calif.getPasajero())){
			//Verifico que el pasajero de la calificacion no haya calificado
			for (Calificacion c : this.getCalificaciones()){
				if (c.getPasajero().equals(calif.getPasajero())){
					ok= "1";
				}
			}
			if (ok.equals("1")){
			System.out.println("Al pasajero no le corresponde calificar este viaje");
			}
			else{
				this.calificaciones.add(calif);
				System.out.println("Se ha calificado correctamente");
				ok ="2";
				}
		}
		else{
			System.out.println("Este pasajero no ha viajado en el viaje");
			ok="3";
		}
		return ok;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Boolean agregarPasajero(Pasajero pasaj) {
		Boolean retorno = false;
		if (this.pasajeros.size() < this.cant_pasajeros && this.getFinalizado() != true) {
			this.pasajeros.add(pasaj);
			retorno = true;
		}
		else{
			retorno = false;
		}
		return retorno;
		
	}

	public void finalizar() {
		if (this.finalizado.equals(false)) {
			this.setFinalizado(true);
			for (Pasajero p : this.pasajeros) {
				p.descontarCredito(this.getCostoTotal()/this.getPasajeros().size());

			}
		}
	}

	public Integer getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Integer idViaje) {
		this.idViaje = idViaje;
	}

	private Integer idViaje;
	private String destino;
	private String origen;
	private Double costoTotal;
	private String fecha;
	// cant_pasajeros indica la cantidad maxima de pasajeros aceptados por el
	// viaje
	private Integer cant_pasajeros;
	private Boolean finalizado;
	private List<Calificacion> calificaciones;
	private List<Pasajero> pasajeros;

}
