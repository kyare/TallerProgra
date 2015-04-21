/**
 * Tramo en el que viajara el bus.
 * @author Dalkiller
 *
 */
public class Tramo {
   	private ListaBuses buses = new ListaBuses();
	private Lugar lugar1;
	private Lugar lugar2;
	private boolean direccion;
	private int tarifa;
	
	/**
	 * Agrega un bus a la lista de buses.
	 * @param hora
	 * @param minuto
	 * @param horaLleg
	 * @param minutoLleg
	 * @param dia
	 * @param mes
	 * @param anio
	 * @return Retorna el bus si fue agregado, en caso
	 * contrario retorna null.
	 */
	public Bus agregarBus(String hora,String minuto, String horaLleg, String minutoLleg, String dia, String mes, String anio) {
		return buses.agregarBus(hora, minuto, horaLleg, minutoLleg, dia, mes, anio);
	}
	
	/**
	 * Entrega una lista de todos los buses que se encuentren 
	 * en la fecha entregada.
	 * @param fecha
	 * @return Retorna un arreglo de los buses encontrados, 
	 * en caso contrario retorna null.
	 */
	public Bus[] listarBuses(String fecha) {
		return buses.listarBuses(fecha);
	}
	
	/**
	 * Entrega una lista de todos los buses que se encuentran
	 * en la fecha entrgada y tienen un minimo de la cantidad
	 * de asientos disponibles.
	 * @param fecha
	 * @param cantAsientos
	 * @return Retorna un arreglo de los buses encontrados,
	 * en caso contrario retorna null.
	 */
	public Bus[] listarBuses(String fecha, int cantAsientos) {
		return buses.listarBuses(fecha, cantAsientos);
	}
	
	/**
	 * Entrega una lista de todos los buses.
	 * @return Retorna un array con todos los buses.
	 */
	public Bus[] listarBuses() {
		return buses.listarBuses();
	}
	
	/**
	 * Borra el bus indicado.
	 * @param busEliminar
	 * @return Retorna el bus si este fue borrado,
	 * en caso contrario retorna null.
	 */
	public Bus borrarBus(Bus busEliminar) {
		return buses.borrarBus(busEliminar);
	}
	
	/**
	 * Constructor de tramo donde ordenara los lugares
	 * alfabeticamente para realizar una busqueda mas rapida.
	 * @param lugar1
	 * @param lugar2
	 * @param direccion
	 * @param tarifa
	 */
	public Tramo(Lugar lugar1, Lugar lugar2, int tarifa) {
		boolean direccion = false;
		if(lugar1.getLugar().compareTo(lugar2.getLugar()) < 0) {
			this.lugar1 = lugar1;
			this.lugar2 = lugar2;
			this.direccion = direccion;
		}
		else {
			this.lugar1 = lugar2;
			this.lugar2 = lugar1;
			this.direccion = !direccion;
		}
		this.tarifa = tarifa;
	}
	
	
	
	

	/**
	 * Compara si este tramo corresponde al tramo buscado
	 * @param salida
	 * @param llegada
	 * @param direccion
	 * @return
	 */
	public boolean compararTramo(Lugar salida, Lugar llegada) {
		Lugar aux;
		boolean direccion = false;
		if(salida.getLugar().compareTo(llegada.getLugar()) > 0) {
			aux = salida;
			salida = llegada;
			llegada = aux;
			direccion = !direccion;
		}
		
		return (salida.equals(this.lugar1) && llegada.equals(this.lugar2) && direccion == this.direccion);
	}
	
	public Lugar getSalida() {
		if(this.direccion)
			return this.lugar2;
		return this.lugar1;
	}
	
	public Lugar setSalida(Lugar salida) {
		if(this.direccion) {
			if(!salida.equals(this.lugar1))
				return this.lugar2 = salida;
			return null;
		}
		else {
			if(!salida.equals(this.lugar2))
				return this.lugar1 = salida;
			return null;
		}
	}

	public Lugar getLlegada() {
		if(direccion)
			return lugar1;
		return lugar2;
	}
	
	public Lugar setLlegada(Lugar llegada) {
		if(this.direccion) {
			if(!llegada.equals(this.lugar2))
				return this.lugar1 = llegada;
			return null;
		}
		else {
			if(!llegada.equals(this.lugar1))
				return this.lugar2 = llegada;
			return null;
		}
	}

	public int getTarifa() {
		return tarifa;
	}

	public boolean setTarifa(int tarifa) {
		if(tarifa > 0) {
			this.tarifa = tarifa;
			return true;
		}
		return false;
	}
	
	
}
