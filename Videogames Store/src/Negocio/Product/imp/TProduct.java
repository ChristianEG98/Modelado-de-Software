/**
 * 
 */
package _2.Diseño.Negocio.Product.imp;



public class TProduct {

	private Integer idProduct;

	private String name;

	private float price;
	
	private Integer stock;

	private boolean active;

	public TProduct(int idProduct, String name, float price, int stock, boolean active) {
		
		this.idProduct=idProduct;
		this.name=name;
		this.price=price;
		this.stock=stock;
		this.active=active;
		
	}
	public TProduct(String name, float price, int stock, boolean active) {
		
		this.name=name;
		this.price=price;
		this.stock=stock;
		this.active=active;
		
	}

	public int getIdProduct() {

		return this.idProduct;

	}

	public void setIdProduct(int idProduct) {

		this.idProduct=idProduct;
	}

	public String getName() {

		return this.name;
	}


	public void setName(String name) {

		this.name=name;
	}


	public float getPrice() {

		return this.price;

	}


	public void setPrice(float price) {

		this.price=price;
	}


	public int getStock() {

		return this.stock;
	
	}


	public void setStock(int stock) {

		this.stock=stock;
	}


	public boolean getActive() {

		return this.active;

	}

	public void setActive(boolean active) {

		this.active=active;
	}
}