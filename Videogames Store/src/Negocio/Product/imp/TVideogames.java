/**
 * 
 */
package _2.Diseño.Negocio.Product.imp;


public class TVideogames extends TProduct {
	
	private String gender;
	
	private VideogamesType platform;
	
	private Integer age;

	
	public TVideogames(int idProduct, String name, float price, int stock, boolean active, String gender,
			VideogamesType platform, int age) {
		
		super(idProduct,name,price,stock,active);
		this.gender=gender;
		this.age=age;
		this.platform=platform;
	}
	
	public TVideogames(String name, float price, int stock, boolean active, String gender,
			VideogamesType platform, int age) {
		
		super(name,price,stock,active);
		this.gender=gender;
		this.age=age;
		this.platform=platform;
	}


	public String getGender() {
		
		return this.gender;
		
	}

	
	public void setGender(String gender) {
		
		this.gender=gender;
	}

	
	public VideogamesType getPlatform() {
		
		return this.platform;
		
	}

	public void setPlatform(VideogamesType platform) {
		
		this.platform=platform;
	}

	
	public int getAge() {
		
		return this.age;
	
	}

	
	public void setAge(Integer age) {
		
		this.age=age;
	}
}