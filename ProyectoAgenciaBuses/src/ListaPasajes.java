import java.util.HashMap;

/**
 * Lista de todos los pasajes de un cliente.
 * @author Dalkiller
 *
 */
public class ListaPasajes {
   	private HashMap <Integer, Pasaje> pasajes = new HashMap<Integer, Pasaje>();
   	
   	/**
   	 * Agrega un pasaje a la lista.
   	 * @param salida
   	 * @param llegada
   	 * @param asiento
   	 * @param precio
   	 * @return Retorna el pasaje si este fue agregado 
   	 * satisfactoriamente, en caso contrario retorna null.
   	 */
   	public Pasaje agregarPasaje(Lugar salida, Lugar llegada, int asiento, int precio, Bus bus) {
   		Pasaje newPasaje = new Pasaje(salida, llegada, asiento, precio, bus);
   		if(pasajes.put(newPasaje.getCodigo(), newPasaje)!=null)
   			return newPasaje;
   		return null;
   	}
   	
   	/**
   	 * Busca un pasaje por el codigo del pasaje.
   	 * @param clave
   	 * @return Retorna el pasaje si este fue
   	 * encontrado en la lista.
   	 */
   	public Pasaje buscarPasaje(int codigo) {
   		return pasajes.get(codigo);
   	}
   	
   	/**
   	 * Entrega una lista de todos los pasajes
   	 * que se encuentra guardados.
   	 * @return Retorna un arreglo con todos
   	 * los pasajes.
   	 */
   	public Pasaje[] listarPasajes() {
   		Pasaje[] listaPasajes = new Pasaje[pasajes.size()];
   		int i=0;
		for (Integer key: pasajes.keySet()) {
			listaPasajes[i] = pasajes.get(key);
			i++;
		}
		return listaPasajes;
   	}
   	
   	/**
   	 * Elimina un pasaje si este fue encontrado.
   	 * @param pasaje
   	 * @return Retorna true si el pasaje fue encontrado
   	 * y eliminado, en caso contrario retorna false.
   	 */
   	public Pasaje borrarPasaje(Pasaje pasaje) {
   		if(pasajes.get(pasaje) != null) {
   			pasajes.remove(pasaje);
   			return pasaje;
   		}
   		return null;
   	}
   	
}
