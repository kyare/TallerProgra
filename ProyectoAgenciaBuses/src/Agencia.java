import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class Agencia {
	private ListaTramos tramos = new ListaTramos();
	private static Map <String,Cliente> clientes = new HashMap <String,Cliente>() ;
	BufferedReader lee=new BufferedReader(new InputStreamReader(System.in));
	
	
	/**
	 * Muestra todos los clientes guardados en la lista.
	 * @return Retorna un array con todos los clientes
	 * ordenados.
	 */
	public Cliente[] listarClientes() {
		Cliente[] clientes = new Cliente[Agencia.clientes.size()];
		int i=0;
		for (String key: Agencia.clientes.keySet()) {
			clientes[i] = Agencia.clientes.get(key);
			i++;
		}
		return clientes;
	}
	
	/**
	 * Entrega un arreglo con los lugares 
	 * @return String[]
	 */
	public String[] listarLugarestoString() {
		return tramos.listarLugarestoString();
	}
	
	/**
	 * Agrega un tramo a la Lista de Tramos
	 * @param lugarSalida
	 * @param lugarLlegada
	 * @param precio
	 * @return Tramo
	 */
	public Tramo agregarTramo(Lugar lugarSalida,Lugar lugarLlegada,int precio) {
		return tramos.agregarTramo(lugarSalida, lugarLlegada, precio);
	}
	/**
	 *  Se busca un tramo el cual es retornado
	 * @param salida
	 * @param llegada
	 * @return Tramo
	 */
	public Tramo buscarTramo(Lugar salida, Lugar llegada) {
		return tramos.buscarTramo(salida, llegada);
	}
	/**
	 * Se borra un tramo y se retorna el tramo borrado
	 * @param tramo
	 * @return Tramo
	 */
	public Tramo borrarTramo(Tramo tramo) {
		return tramos.borrarTramo(tramo);
	}
	/**
	 * Entrega un arreglo de tramos
	 * @return Tramo[]
	 */
	public Tramo[] listarTramos() {
		return tramos.listarTramos();
	}
	/**
	 * Se elimina un lugar , el cual es retornado
	 * @param lugar
	 * @return Lugar
	 */
	public Lugar borrarLugar(Lugar lugar) {
		return tramos.borrarLugar(lugar);
	}
	
	/**
	 * Busca un lugar en la lista de tramos
	 * @param lugar
	 * @return Lugar
	 */
	public Lugar buscarLugar(String lugar){
		return tramos.buscarLugar(lugar);		
	}
	/**
	 * Agrega un lugar a la lista de tramos
	 * @param lugar
	 * @return Lugar
	 */
	public Lugar agregarLugar(String lugar){
		return tramos.agregarLugar(lugar);
		
	}
	/**
	 * Entrega un array de lugares 
	 * @return Lugar[]
	 */
	public Lugar[] listarLugares(){
		return tramos.listarLugares();		
	}
	/**
	  * El cliente compra un pasaje y se retorna el pasaje
	  * @param bus
	  * @param rut
	  * @param fecha
	  * @param salida
	  * @param llegada
	  * @param asiento
	  * @param precio
	  * @return Pasaje
	  */
	 public Pasaje comprarPasaje(Bus bus, String rut,String fecha,Lugar salida,Lugar llegada,int asiento,int precio){
		  
		 // Se marca el asiento
		 if(bus.setAsientos(asiento)) {
			 Cliente cliente = clientes.get(rut);
			 Pasaje pasaje;
			 if(cliente != null && (pasaje=cliente.agregarPasaje(salida, llegada, asiento, precio, bus))!=null) {
				 return pasaje;
			 }
		 }
		 return null;
	 }

	/**
	 * Agrega un cliente al HashMap  y hace un reporte
	 * @param persona
	 * @return false si ya esta el cliente y true si se pudo agregar
	 * 
	 */
	public Cliente agregarCliente(String rut,String nombres,String apellidos,String fechaNacimiento,Boolean estudiante,String telefono) {
		if(rut!=null && nombres!=null && apellidos!=null && fechaNacimiento!=null && telefono !=null){
			if(clientes.containsKey(rut))
				return null;
			Cliente persona=new Cliente(); 
			persona.setApellidos(apellidos);
			persona.setEstudiante(estudiante);
			persona.setFechaNacimiento(fechaNacimiento);
			persona.setNombres(nombres);
			persona.setRut(rut);
			persona.setTelefono(telefono);
			clientes.put(rut, persona);
			
			return persona;
		}return null;
	}

	/**
	 * Edita un cliente con los datos de persona usando como parametro de busqueda el rut de persona y reporta la edicion
	 * @param persona
	 * @return Cliente si existia la persona en el registro y null en caso contrario
	 * @throws IOException 
	 */
	public Cliente editarCliente(Cliente persona) throws IOException{
		Cliente aux=new Cliente();
		if(clientes.containsKey(persona.getRut())){
			aux=clientes.get(persona.getRut());
			clientes.get(persona.getRut()).editarCliente(persona);
			String ruta=lee.readLine();
			String fileName=lee.readLine();
			String contenido="Se ha editado un cliente:\nNombres:"+persona.getNombres()+"\nApellidos:"+persona.getApellidos()+"\nRut:"+persona.getRut()+"\nFecha_de_nacimiento:"+persona.getFechaNacimiento()+"\nTelefono:"+persona.getTelefono()+"\nEs estudiante?"+persona.getEstudiante()+"\n\n";
			reporteCliente(ruta,fileName,contenido);
			return aux;
		}
		return null;
		
	}

	public boolean reporteCliente(String ruta,String nombreArchivo,String cadena) {
		System.out.println("Ingrese ruta donde guardar reporte (ej: C:\\Program Files)\n");
		
		String nombre= ruta+" "+nombreArchivo;
		File f= new File(nombre);
		cadena= cadena+"\n";
		if(f.exists()){
		try{
			FileWriter w = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw); 
			wr.append(cadena); //concatenamos en el archivo sin borrar lo existente
		        //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
		        //de no hacerlo no se escribirá nada en el archivo
			wr.close();
			bw.close(); 
		}catch(IOException e){};
		}
		else{
			try{
				FileWriter w = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw); 
				wr.write(cadena);//escribimos en el archivo
				wr.close();
				bw.close();
			}catch(IOException e){};
		}
		 
		
		return false;
		
	}

	/**
	  * 
	  * @param rut
	  * @return false si rut no es valido y true si es valido
	  */
	public boolean validarRut(String rut) {
		if(rut.length() < 10 && rut.length() > 7){
			int index=rut.length()-1, 
					serie=2,
					total=0,
					rutNum=0;
			String numeros = rut.substring(0, index),
					dv = rut.substring(index, index+1);
			if(esNumero(numeros)){
				int arrayRut[] = new int[numeros.length()];
				rutNum = Integer.parseInt(numeros);
				for(int i=0; i < numeros.length(); i++) {
					arrayRut[i] = rutNum%10;
					rutNum=(rutNum - (rutNum%10))/10;
				}
				for(int i=0; i < numeros.length(); i++) {
					total= total + (arrayRut[i] * serie);
					if(serie == 7)
						serie = 2;
					else
						serie++;
				}
				int dvnuevo = 11 - (total % 11);
				String stringDV;
				if(dvnuevo == 11)
					stringDV = "0";
				else if(dvnuevo == 10)
					stringDV = "K";
				else
					stringDV = "" + dvnuevo;
				if(stringDV.equals(dv))
					return true;
			}
		} 
		return false;
	}
	/**
	 * Busca un cliente en el HashMapcon el key rut
	 * @param rut
	 * @return cliente
	 */
	public Cliente buscarCliente(String rut){
		Cliente auxiliar;
		if(!clientes.isEmpty()){
			if(clientes.containsKey(rut)){
			auxiliar=clientes.get(rut);
			return auxiliar;
			}
		}
		return null;
	} 

	/**
	 * Muestra un cliente de la tabla de clientes
	 * @param rut
	 * @return true si se puede mostrar false si la persona no existe
	 */
	public boolean mostrarCliente(String rut){
		Cliente persona=buscarCliente(rut);
		if(persona !=null){
			
		System.out.println("Nombres: "+persona.getNombres()
				+"\n Apellidos: "+persona.getApellidos()
				+"\n Fecha de Nacimiento: "+persona.getFechaNacimiento()
				+"\n rut: "+persona.getRut()
				+"\n Telefono: "+persona.getTelefono()
				+"\n Estudiante: "+persona.getEstudiante());
		return true;
		}
		return false;
		
	}
	/**
	 * Elimina un cliente del HashMap con la clave rut 
	 * @param rut
	 * @return false si el cliente no esta y true si el cliente esta y se elimino
	 */
	public boolean borrarCliente(String rut){
		if(clientes.containsKey(rut)){
			clientes.remove(rut);
			return true;
		}
		return false;
	}
	public Pasaje buscarPasaje( int codigo){
		Pasaje pasaje=null;
		for (String key: clientes.keySet() ) {
			pasaje =clientes.get(key).buscarPasaje(codigo);
			if(pasaje!=null)return pasaje;
		}
		return null;
	}
	
	/**
	 * Elimina un Pasaje del HashMap de clientes y retorna el pasaje
	 * @param codigo
	 * @return false si no se pudo borrar y true si se pudo borrar
	 */
	
	public Pasaje borrarPasaje(int codigo){
		Pasaje pasaje=null;
		Cliente persona;
		for (String key: clientes.keySet() ) {
			persona = clientes.get(key);
			pasaje = persona.buscarPasaje(codigo);
			if(persona.borrarPasaje(pasaje)!=null){
				pasaje.getBus().quitarAsiento(pasaje.getAsiento());
				return pasaje;
			}
		}
		return null;
		
	}
	
	/**
	  * verifica que la cadena entregada sea un numero
	  * @param cadena
	  * @return false si no es numero y true si es numero
	  */
		public boolean esNumero(String cadena){ //verifica si la cadena es un numero
	    	try {
	    			Integer.parseInt(cadena);
	    			return true;
	    		} catch (NumberFormatException nfe){
	    			return false;
	    	}
	    }
						
	
		
}
