import java.util.Date;


public class Pasaje {

	private static int codigoGeneral=100000000;
	
	private Lugar salida;
	private Lugar llegada;
	private int asiento;
	private int precio;
	private int codigo;
	private Bus bus;
	private String fechaCompra;
	
	public Pasaje(Lugar salida, Lugar llegada, int asiento, int precio, Bus bus) {
		this.asiento = asiento;
		this.precio = precio;
		this.bus = bus;

		// Instantiate a Date object
		Date date1 = new Date();
		this.fechaCompra = date1.toString();
		this.codigo = codigoGeneral;
		codigoGeneral++;
	}
	
	public Lugar getSalida() {
		return this.salida;
	}
	
	public Lugar setSalida(Lugar salida) { 
		if(!this.llegada.equals(salida))
			return this.salida = salida;
		return null;
	}
	
	public Lugar getLlegada() {
		return llegada;
	}

	public Lugar setLlegada(Lugar llegada) { 
		if(!this.salida.equals(llegada))
			return this.llegada = llegada;
		return null;
	}
	
	public int getAsiento() {
		return this.asiento;
	}
	
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public int getPrecio() {
		return this.precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getFechaCompra() {
		return fechaCompra;
	}
	
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Bus getBus() {
		return this.bus;
	}
	
	public void setBus(Bus bus) {
		this.bus = bus;
	}
}
