package bd2.Muber.dto;

import bd2.Muber.model.Viaje;

public class ViajeDTO {
	public ViajeDTO(Viaje v) {
		super();
		this.idViaje = v.getIdViaje();
		this.destino = v.getDestino();
		this.origen = v.getOrigen();
		this.costoTotal = v.getCostoTotal();
		this.fecha = v.getFecha();
		this.cant_pasajeros = v.getCant_pasajeros();
		this.finalizado = v.getFinalizado();
	}

	public Integer getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(Integer idViaje) {
		this.idViaje = idViaje;
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

	private Integer idViaje;
	private String destino;
	private String origen;
	private Double costoTotal;
	private String fecha;
	private Integer cant_pasajeros;
	private Boolean finalizado;

}
