/**
 * 
 */
package _2.Diseño.Negocio.Product;

import java.util.ArrayList;

import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Negocio.Product.imp.TProduct;


public interface SAProduct {
	
	public int createProduct(TProduct tProduct);

	
	public int deleteProduct(int idProduct);

	
	public int modifyProduct(TProduct tProduct);

	
	public TProduct searchProduct(int idProduct);

	
	public ArrayList<TProduct> searchProductsByPrice(float price);

	
	public ArrayList<TProduct> listProducts();
	
	public ArrayList<TProduct> BestSellingProductSince_X_Date(TQuery dat);
}