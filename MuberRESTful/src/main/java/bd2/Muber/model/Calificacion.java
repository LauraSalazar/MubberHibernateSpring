package bd2.Muber.model;

public class Calificacion {
	
	public Calificacion(){
		super();
	}

	public Calificacion( String comentario, Integer puntaje, Pasajero p) {
		super();
		this.puntaje = puntaje;
		this.comentario = comentario;
		this.pasajero = p;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Integer getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
	}

	private Integer idCalificacion;
	private Integer puntaje;
	private String comentario;
	private Pasajero pasajero;
}
