
public class Cliente {
	private ListaPasajes pasajes=new ListaPasajes();
	private String rut;	
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private Boolean estudiante;
	private String telefono;
	/**
	 * Edita la informacion de un cliente usando como referencia su rut
	 * @param cliente
	 * @return true si se pudo editar y false si no se pudo
	 */
	public boolean editarCliente(Cliente cliente){
		if(this.rut.equals(cliente.getRut())){
			this.nombres=cliente.getNombres().toUpperCase();
			this.apellidos=cliente.getApellidos().toUpperCase();
			this.estudiante=cliente.getEstudiante();
			this.fechaNacimiento=cliente.getFechaNacimiento();/*se puede editar fechaNac.*/
			this.telefono=cliente.getTelefono();
			return true;
		}
		
		return false;
		
	}
	/**
	 * Busca un pasaje de Lista de Pasajes 
	 * @param codigo
	 * @return Pasaje
	 */
	public Pasaje buscarPasaje(int codigo){
		return this.pasajes.buscarPasaje(codigo);		
	}
	
	/**
	 * Agrega un pasaje a la Lista de Pasajes
	 * @param salida
	 * @param llegada
	 * @param asiento
	 * @param precio
	 * @return Pasaje
	 */
	public Pasaje agregarPasaje(Lugar salida,Lugar llegada,int asiento ,int precio, Bus bus){
		return pasajes.agregarPasaje(salida, llegada, asiento, precio, bus);
	}
	
	/**
	 * Elimina un pasaje de la Lista de Pasajes
	 * @param pasaje
	 * @return Pasaje
	 */
	public Pasaje borrarPasaje(Pasaje pasaje){
		return this.pasajes.borrarPasaje(pasaje);
	}
	
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Boolean getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Boolean estudiante) {
		this.estudiante = estudiante;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
