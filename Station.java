


public class Station {
	private String contract_name, nom_station, address, status, last_update;
	private int number, bike_stands, available_bike_stands,available_bikes;
	private boolean banking, bonus;
	private Position position;	
	

	
	
	public int getNbVelos(){ 
		return available_bikes;
	}
	
	public int getNumber(){
		return number;
	}
	

	
}
