
public class Horario {
	private String horaSal, horaLleg;
	 private String minutoSal, minutoLleg;
	 private String dia;
     private String mes;
     private String a�o;
     /**
      * Ingresa la hora en los Strings.
      * @param horaSal
      * @param minutoSal
      * @param horaLleg
      * @param minutoLleg
      * @param dia
      * @param mes
      * @param a�o
      */
     public Horario(String horaSal,String minutoSal, String horaLleg, String minutoLleg, String dia, String mes, String a�o){
    	 this.horaSal=horaSal;
    	 this.minutoSal=minutoSal;
    	 this.horaLleg=horaLleg;
    	 this.minutoLleg=minutoLleg;
    	 this.dia=dia;
    	 this.mes=mes;
    	 this.a�o=a�o;
     }
	 /**
	  * Entrega hora de salida.
	  * @return Retorna un String con la hora de salida (formato hora:minuto).
	  */
	 public String horaSalida(){
		 String HoraSal, cad=":";
		 HoraSal=horaSal+cad+minutoSal;
		 return HoraSal;
	 }
	 /**
	  * Entrega la hora de llegada.
	  * @return Retorna  un String con la hora de salida (formato hora:minuto).
	  */
	 public String horaLlegada() {
		 String HoraLleg, cad= ":";
		 HoraLleg=horaLleg+cad+minutoLleg;
		 	return HoraLleg;        
	 }
	 /**
	  * Entrega fecha.
	  * @return Retorna una cadena (formato dia/mes/a�o).
	  */
	 public String fecha(){
		 String Fecha, cad= "/";
		 Fecha=dia+cad+mes+cad+a�o;
		 return Fecha;
	 }
}