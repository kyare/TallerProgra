import java.util.ArrayList;



public class ListaBuses {
	
	private ArrayList<Bus> listaBus = new ArrayList<Bus>();
	
	/**
	 * Agrega un Bus al Array. 
	 * @param hora
	 * @param minuto
	 * @param horaLleg
	 * @param minutoLleg
	 * @param dia
	 * @param mes
	 * @param año
	 * @return Retorna el bus si fue agregado, 
	 * en caso contrario retorna null. 
	 */
	public Bus agregarBus(String hora,String minuto, String horaLleg, String minutoLleg, String dia, String mes, String año){
		
		if(buscarBushora(hora+minuto+dia+mes+año)==null)
		{
			Bus bus = new Bus();
			bus.setHorario(hora, minuto, horaLleg, minutoLleg, dia, mes, año);
			if(listaBus.add(bus)==true)	return bus;
		}
		return null;
	}
	/**
	 * Busca un bus por su horario completo.
	 * @param horario
	 * @return Retorna un bus en caso de existir con el mismo horario en el Array,
	 * sino retorna null. 
	 */
	public Bus buscarBushora(String horario){
		if (listaBus.size()>0){
			int i=listaBus.size();
			Bus bus=null;
				while(i>0 && bus==null){
					if(((listaBus.get(i-1).getHorario()).equals(horario))==true){
						bus=listaBus.get(i-1);
					}
					i--;
				};
				return bus;
		}
		return null;
	}
	/**
	 * Bus un bus por su dia mes y año.
	 * @param fecha (String con dia mes y año concatenados). 
	 * @return Retorna una lista de buses de el dia señalado,
	 * en caso de no haber ningun bus en el dia, retorna null.
	 */
	public Bus[] listarBuses(String fecha){
		if(listaBus.size()>0){
			int i=listaBus.size(), z=0;
			Bus bus=null;
			while(i>0){
				if((listaBus.get(i-1).getFecha()).equals(fecha)){
					z++;
				}
				i--;
			};
			Bus[] buses = new Bus[z];
			i=listaBus.size();
			z=0;
			while(i>0){
				if((listaBus.get(i-1).getFecha()).equals(fecha))  {
						bus=listaBus.get(i-1);
						buses[z]=bus;
						z++;
				}
				i--;
			};
			return buses;
		}
		return null;
	}
	/**
	 *  Busca un bus por su dia, mes, año y cantidad de asientos necesarios. 
	 * @param fecha (String con dia mes y año).
	 * @param cantAsientos (cantidad de asientos requeridos por el clientes).
	 * @return Retorna una lista de buses de el dia y con la cantidad de asientos
	 * necesaria, en caso de no haber buses con esa cantidad de asientos disponibles
	 * o que no hayan en la fecha, retorna null.
	 */
	public Bus[] listarBuses(String fecha, int cantAsientos){
		if(listaBus.size()>0){
			int i=listaBus.size(), z=0;
			Bus bus=null;
			while(i>0){
				if((listaBus.get(i-1).getFecha()).equals(fecha) && (44-listaBus.get(i-1).contAsientos)>=cantAsientos){
					z++;
				}
				i--;
			};
			Bus[] buses = new Bus[z];
			z=0;
			i=listaBus.size();
			while(i>0){
				if(((listaBus.get(i-1).getFecha()).equals(fecha)) && (44-listaBus.get(i-1).contAsientos)>=cantAsientos){
					bus=listaBus.get(i-1);
					buses[z]=bus;
					z++;
				}
				i--;
			};
			return buses;
		}
		return null;
	}
	
	/**
	 * Reserva un asiento en el bus.
	 * @param bus
	 * @param asiento (numero de asiento)
	 * @return Retorna "true" si el asiento estaba disponible,
	 * si el asiento esta ocupado retorna "false".
	 */
	public boolean agregarAsiento(Bus bus, int asiento){
		if(bus.revisarAsientos(asiento)==true){
			bus.setAsientos(asiento);
			return true;
		}
		return false;
	}
	
	/**
	 * Libera un asiento de un bus.
	 * @param bus
	 * @param asiento (numero de asiento).
	 * @return Retorna "true" si el asiento fue liberado,
	 * si el asiento ya estaba desocupado retorna "false".
	 */
	public boolean quitarAsiento(Bus bus, int asiento){
		if(bus.quitarAsiento(asiento)==true){
			return true;
		}
		return false;		
	}
	/**
	 * Elimina un bus del Array.
	 * @param busEliminar
	 * @return Retorna el bus eliminado sino pudo eliminarlo retorna null;
	 */
	public Bus borrarBus(Bus busEliminar){
		int i=listaBus.size();
		Bus bus=null;
				while(i>0 && bus==null){
					if(listaBus.get(i-1)==busEliminar){
						listaBus.remove(i-1);
						return busEliminar;
					}
				};
				return null;
	}
	/**
	 * @return Retorna la lista de buses
	 */
	public Bus[]  listarBuses() {
	     Bus[] buses = new Bus[listaBus.size()];
	  for(int i=0; i < listaBus.size(); i++) buses[i] = listaBus.get(i);
	  return buses;
	}

}
