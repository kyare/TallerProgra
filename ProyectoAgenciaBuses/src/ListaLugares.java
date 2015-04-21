import java.util.Arrays;
import java.util.HashMap;

/**
 * Lista de Lugares donde se almacenaran
 * todos los lugares donde los buses
 * hacen sus recorridos.
 * @author Dalkiller
 *
 */
public class ListaLugares {
	
   	private HashMap <String, Lugar> lugares = new HashMap<String, Lugar>();
   	
   	/**
   	 * Agrega un lugar a la lista de lugares.
   	 * @param lugar
   	 * @return Retorna el lugar si se agrego correctamente, 
   	 * en caso contrario null.
   	 */
   	public Lugar agregarLugar(String lugar) {
   		if(lugares.get(lugar.toUpperCase()) == null) {
   			Lugar nuevoLugar = new Lugar(lugar);
   			lugares.put(lugar.toUpperCase(), nuevoLugar);
   			return nuevoLugar;
   		}
   		return null;
   	}
   	
   	/**
   	 * Busca un lugar dentro de la lista de lugares.
   	 * @param lugar
   	 * @return Retorna el lugar si este fue encontrado.
   	 */
	public Lugar buscarLugar(String lugar) {
		return lugares.get(lugar.toUpperCase());
	}
	
	/**
	 * Muestra todos los lugares guardados en la lista
	 * en un arreglo de String.
	 * @return Retorna un array con todos los lugares
	 * ordenados.
	 */
	public String[] listarLugarestoString() {
		String[] listarLugares = new String[lugares.size()];
		int i=0;
		for (String key: lugares.keySet()) {
			listarLugares[i] = lugares.get(key).getLugar();
			i++;
		}
//		Arrays.sort(listarLugares);
		return listarLugares;
	}
	
	/**
	 * Muestra todos los lugares guardados en la lista
	 * en un arreglo de Lugar.
	 * @return Retorna un array con todos los lugares
	 * desordenado.
	 */
	public Lugar[] listarLugares() {
		Lugar[] listarLugares = new Lugar[lugares.size()];
		int i=0;
		for (String key: lugares.keySet()) {
			listarLugares[i] = lugares.get(key);
			i++;
		}
		return listarLugares;
	}
	
	/**
	 * Borra un lugar de la lista.
	 * @param lugar
	 * @return retorna el lugar si este fue
	 * eliminado satisfactoriamente.
	 */
	public Lugar borrarLugar(Lugar lugar) {
		return lugares.remove(lugar.getLugar());
	}
	
}
