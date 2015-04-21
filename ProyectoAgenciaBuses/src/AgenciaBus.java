import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AgenciaBus {

	static BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		final Agencia agencia = new Agencia();
		

		// Agregar Lugares
		Lugar valpo = agencia.agregarLugar("valparaiso");
		Lugar stgo = agencia.agregarLugar("santiago");
		Lugar tmco = agencia.agregarLugar("temuco");
		
		// Agregar tramos
		Tramo tramo1 = agencia.agregarTramo(valpo, stgo, 2500);
		agencia.agregarTramo(valpo, tmco, 10000);
		agencia.agregarTramo(tmco, valpo, 10000);
		agencia.agregarTramo(tmco, stgo, 8000);
		
		// Agregar bus
		Bus bus1 = tramo1.agregarBus("04", "03","14", "20", "04", "02", "2015");
		tramo1.agregarBus("04", "03","14", "20" , "05", "02", "2015");
		tramo1.agregarBus("04", "03","14", "20", "06", "02", "2015");
		tramo1.agregarBus("04", "03","14", "20","07", "02", "2015");

		// Agregar cliente
		agencia.agregarCliente("111111111", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		agencia.agregarCliente("222222222", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		agencia.agregarCliente("333333333", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		agencia.agregarCliente("44444444", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		agencia.agregarCliente("181944773", "nombres", "apellidos", "fechaNacimiento", true, "telefono");
		
		// ComprarPasaje
		agencia.comprarPasaje(bus1, "181944773", "wdas", tramo1.getSalida(), tramo1.getLlegada(), 33, 2343423);
//		cliente1.agregarPasaje(tramo1.getSalida(), tramo1.getLlegada(), 33, tramo1.getTarifa(), bus1);
//		cliente1.agregarPasaje(tramo1.getSalida(), tramo1.getLlegada(), 33, tramo1.getTarifa(), bus2);

		MenuPrincipal frame = new MenuPrincipal(agencia);
		frame.setVisible(true);
		
		System.out.println("Gracias por preferir nuestros servicios :)");
		/*falta reporte de archivos en las clases*/
	}
	
}
