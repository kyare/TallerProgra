
public class Bus {

	private boolean asientos[]= new boolean[44];
	private Horario horario;
	int contAsientos=0; 
	public boolean revisarAsientos(int i) {
		if(this.asientos[i]!=true){
			return true;
		} //retorna verdadero si el asiento esta desocupado 
		return false;
	}
	public boolean setAsientos(int numeroAsiento) { //guarda asiento deseado por pasajero
		int i = numeroAsiento-1;
		if (this.asientos[i]!=true){
				this.asientos[i] = true;
				contAsientos++; //aumenta cantidad de asientos ocupados
			return true;
		}	
		else{
			System.out.println("Asiento ocupado, escoja otro\n");
			return false;
		}
	}
	
	public boolean quitarAsiento(int numeroAsiento){ //libera asiento ocupado anteriormente
		int i=numeroAsiento-1;
		if(this.asientos[i]==true){
			System.out.println("Asiento desocupado");
			return false;
		}
		else{
			this.asientos[i]=false;
			System.out.println("Asiento liberado");
			return true;
		}
	}
	public String getHorario() {
		return horario.horaSalida(); //obtiene hora de salida y fecha de un bus
	}
	public String getFecha(){
		return horario.fecha();
	}
	public void setHorario(String hora,String minuto, String horaLleg, String minutoLleg, String dia, String mes, String año) {
		Horario horario= new Horario(hora, minuto, horaLleg, minutoLleg, dia, mes, año);
		this.horario=horario;
		}	

}
