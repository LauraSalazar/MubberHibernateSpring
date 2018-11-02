package bd2.Muber.dto;

public class CalificacionDTO {
	private Integer idCalificacion;
	private Integer puntaje;
	private String comentario;
	private Integer idPasajero;

	public Integer getIdCalificacion() {
		return idCalificacion;
	}

	public void setIdCalificacion(Integer idCalificacion) {
		this.idCalificacion = idCalificacion;
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

	public Integer getIdPasajero() {
		return idPasajero;
	}

	public void setIdPasajero(Integer idPasajero) {
		this.idPasajero = idPasajero;
	}
}
