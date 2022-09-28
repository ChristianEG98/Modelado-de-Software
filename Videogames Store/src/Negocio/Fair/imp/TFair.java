/**
 * 
 */
package _2.Diseño.Negocio.Fair.imp;


public class TFair {
	
	private boolean active;
	
	private int idFair;
	
	private String place;
	
	private String nameFair;
	
	private int capacity;

	
	public TFair(int idFair, boolean active, int capacity, String place, String nameFair) {
		this.idFair = idFair;
		this.active = active;
		this.capacity = capacity;
		this.place = place;
		this.nameFair = nameFair;
	}

	
	public TFair(boolean active, int capacity, String place, String nameFair) {
		this.active = active;
		this.capacity = capacity;
		this.place = place;
		this.nameFair = nameFair;
	}
	
	public boolean getActive() {
		return this.active;
	}

	
	public void setActive(boolean active) {
		this.active = active;
	}

	
	public int getCapacity() {
		return this.capacity;
	}

	
	public void setCapacityd(int capacity) {
		this.capacity = capacity;
	}

	
	public int getIdFair() {
		return this.idFair;
	}

	
	public void setIdFair(int idFair) {
		this.idFair = idFair;
	}

	
	public String getPlace() {
		return this.place;
	}

	
	public void setPlace(String place) {
		this.place = place;
	}

	
	public String getNameFair() {
		return this.nameFair;
	}

	
	public void setNameFair(String nameFair) {
		this.nameFair = nameFair;
	}


	
}