import java.util.ArrayList;

/**
 * 
 * @author Dalkiller
 *
 */
public class ListaTramos {
   	private ArrayList<Tramo> tramos = new ArrayList<Tramo>();
	private ListaLugares listaLugares = new ListaLugares();
	
	/**
	 * Muestra todos los lugares guardados en la lista
	 * en un arreglo de String.
	 * @return Retorna un array con todos los lugares
	 * desordenado.
	 */
	public String[] listarLugarestoString() {
		return listaLugares.listarLugarestoString();
	}
	
   	
   	/**
   	 * Agrega el tramo a la lista si no existe ese tramo en la lista.
   	 * @param lugarSalida
   	 * @param lugarLlegada
   	 * @param precio
   	 * @return retorna tramo si se agrego, en caso contrario null.
   	 */
   	public Tramo agregarTramo(Lugar lugarSalida, Lugar lugarLlegada, int precio) {
   		if(buscarTramo(lugarSalida, lugarLlegada)==null) {
   			Tramo tramo = new Tramo(lugarSalida, lugarLlegada, precio);
   			tramos.add(tramo);
   			return tramo;
   		}
   		return null;
   	}
   	
   	/**
   	 * Busca un tramo en la lista.
   	 * @param lugarSalida
   	 * @param lugarLlegada
   	 * @return retorna el tramo si lo encuentra, en caso contrario
   	 * retorna null.
   	 */
   	public Tramo buscarTramo(Lugar lugarSalida, Lugar lugarLlegada) {
   		if(tramos.size() > 0) {
	   		int i = tramos.size();
	   		Tramo tramo=null;
	   		while(i > 0 && tramo == null) {
	   			if(tramos.get(i-1).compararTramo(lugarSalida,lugarLlegada)) 
	   				tramo = tramos.get(i - 1);
	   			i--;
	   		};
	   		return tramo;
   		}
   		return null;
   	}

   	/**
   	 * Borra el tramo indicado.
   	 * @param tramo
   	 * @return retorna tramo si se borro, en 
   	 * caso contrario retorna null.
   	 */
   	public Tramo borrarTramo(Tramo tramo) {
   			if(tramos.remove(tramo))
   				return tramo;
   			return null;
   	}
   	
   	/**
   	 * Busca todos los tramos existentes.
   	 * @return Retorna un array normal de Tramo[]
   	 * que contiene todos los tramos guardados.
   	 */
   	public Tramo[] listarTramos() {
		Tramo[] tramos = new Tramo[this.tramos.size()];
		for(int i=0; i < this.tramos.size(); i++) 
			tramos[i] = this.tramos.get(i);
		return tramos;
   	}
   	

	/**
	 * Busca en la lista de lugares si existe un lugar.
	 * @param lugar
	 * @return Retorna el lugar si este fue encontrado.
	 */
	public Lugar buscarLugar(String lugar) {
		return listaLugares.buscarLugar(lugar);
	}
	

	/**
	 * Agrega un lugar a la lista de lugares si es
	 * que aun no existe ese lugar.
	 * @param lugar
	 * @return Retorna el lugar agregado si fue
	 * guardado correctamente, en caso contrario
	 * returna null.
	 */
	public Lugar agregarLugar(String lugar) {
		return listaLugares.agregarLugar(lugar);
	}
	

	/**
	 * Muestra todos los lugares guardados en la lista
	 * en un arreglo.
	 * @return Retorna un array con todos los lugares
	 * desordenado (falta entregarlos en orden 
	 * alfabetico).
	 */
	public Lugar[] listarLugares() {
		return listaLugares.listarLugares();
	}
	

	/**
	 * Borra un ligar de la lista
	 * @param lugar
	 * @return Si el lugar fue borrado correctamente
	 * retorna el lugar, en caso cotrario retorna null.
	 */
	public Lugar borrarLugar(Lugar lugar) {
		return listaLugares.borrarLugar(lugar);
	}
}
