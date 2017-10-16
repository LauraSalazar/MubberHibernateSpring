package bd2.Muber.model;

public class Pasajero extends Usuario {

	public Pasajero(String password, Double dineroDisponible, String dni, String fechaIngreso, String nombre) {
		super(password, dni, nombre, fechaIngreso);
		this.setDineroDisponible(dineroDisponible);
	}

	public Pasajero() {
		super();
	}

	public Double getDineroDisponible() {
		return dineroDisponible;
	}

	public void setDineroDisponible(Double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}

	public void descontarCredito(Double costo) {
		this.dineroDisponible = this.dineroDisponible - costo;
	}

	public void cargarCredito(Double monto) {
		this.dineroDisponible += monto;
	}

	private Double dineroDisponible;

}
