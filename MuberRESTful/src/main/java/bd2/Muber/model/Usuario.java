package bd2.Muber.model;

public class Usuario {

	public Usuario(String password, String dni, String nombre, String fechaIngreso) {
		super();
		this.setContrasena(password);
		this.setDni(dni);
		this.setNombre(nombre);
		this.setFechaIngreso(fechaIngreso);
	}

	public Usuario() {
		super();
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

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	private Integer idUsuario;
	private String nombre;
	private String dni;
	private String contrasena;
	private String fechaIngreso;

}
