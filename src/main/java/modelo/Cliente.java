package modelo;

public class Cliente {
	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	CategoriaEnum nombreCategoria;
	
	public Cliente() {
		this.nombreCategoria = CategoriaEnum.ACTIVO;
	}

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,CategoriaEnum nombreCategoria) {
		
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
		
	}
	
	public String getRunCliente() {
		return runCliente;
	}
	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getAniosCliente() {
		return aniosCliente;
	}
	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}
		
	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	@Override
	public String toString() {
		return "\n-------------Datos del Cliente-------------"+
				"\nRUN del Cliente: " + runCliente +
				"\nNombre del Cliente: " + nombreCliente +
				"\nApellido del Cliente: "+ apellidoCliente +
				"\nAños como Cliente: " + aniosCliente +
				"\nCategoria del Cliente: "+(nombreCategoria==CategoriaEnum.ACTIVO?"Activo":"Inactivo")+
				"\n-------------------------------------------";
	}
}
