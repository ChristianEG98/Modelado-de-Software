
package _2.Diseño.Integracion.Query;

import java.sql.Date;


public class TQuery {

	private Date fecha;
	private int idProduct;

	public TQuery(int idProduct, Date fecha){
		this.idProduct =idProduct;
		this.fecha = fecha;
	}
	
	public TQuery(int idProduct){
		this.idProduct =idProduct;
		this.fecha = null;
	}
	
	public TQuery(Date fecha) {
		this.idProduct = 0;
		this.fecha = fecha;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setMes(Date fecha) {
		this.fecha = fecha;
	}
}