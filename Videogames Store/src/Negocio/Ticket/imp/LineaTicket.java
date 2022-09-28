/**
 * 
 */
package _2.Diseño.Negocio.Ticket.imp;



public class LineaTicket {
	
	private int numProducts;
	
	private float totalPrice;
	
	private int idProduct;
	
	private int idTicket;
	
	public LineaTicket(int idProducto, int numProductos, float precioTotal) {
		this.idProduct = idProducto;
		this.numProducts = numProductos;
		this.totalPrice = precioTotal;
	}

	public LineaTicket(int idTicket, int idProducto, int numProductos, float precioTotal) {
		this.idTicket = idTicket;
		this.idProduct = idProducto;
		this.numProducts = numProductos;
		this.totalPrice = precioTotal;
	}
	
	public int getNumProducts() {
		return this.numProducts;
	}

	public void setNumProducts(int numProductos) {
		this.numProducts = numProductos;
	}

	public float getTotalPrice() {
		return this.totalPrice;
	}

	
	public void setTotalPrice(float f) {
		this.totalPrice = f;
	}

	
	public int getIdProduct() {
		return this.idProduct;
	}


	public void setIdProduct(int idProducto) {
		this.idProduct = idProducto;
	}
	
	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

}