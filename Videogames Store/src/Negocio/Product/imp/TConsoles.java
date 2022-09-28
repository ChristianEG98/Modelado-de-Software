/**
 * 
 */
package _2.Diseño.Negocio.Product.imp;


public class TConsoles extends TProduct {
	
	private Integer storage;
	
	private String colour;
	
	private String manufacturer;


	public TConsoles(int idProduct, String name, float price, int stock, boolean active,
		int storage,String colour, String manufacturer) {
		
	    super(idProduct, name, price, stock, active);
		this.storage=storage;
		this.colour=colour;
		this.manufacturer=manufacturer;
		
	}
	
	public TConsoles(String name, float price, int stock, boolean active,
			int storage,String colour, String manufacturer) {
			
		    super( name, price, stock, active);
			this.storage=storage;
			this.colour=colour;
			this.manufacturer=manufacturer;
			
		}


	public int getStorage() {
		
		return this.storage;
		
	}


	public void setStorage(int storage) {
	
		this.storage=storage;
	}


	public String getColour() {
	
		return this.colour;
	
	}


	public void setColour(String colour) {

		this.colour=colour;
	}


	public String getManufacturer() {
		
		return this.manufacturer;
		
	}


	public void setManufacturer(String manufacturer) {

		this.manufacturer=manufacturer;
	}
}