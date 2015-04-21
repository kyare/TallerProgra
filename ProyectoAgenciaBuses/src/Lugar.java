/**
 * Lugares desde y a donde vayan los buses, 
 * donde se transformaran todas las palabras
 * a mayusculas.
 * @author Dalkiller
 *
 */
public class Lugar {
	
	private String Lugar;
	
	public Lugar(String lugar) {
		this.Lugar = lugar.toUpperCase();
	}
	
	public String getLugar() {
		return Lugar;
	}

	public void setLugar(String lugar) {
		this.Lugar = lugar.toUpperCase();
	}
	
}
