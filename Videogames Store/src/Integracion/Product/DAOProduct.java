/**
 * 
 */
package _2.Dise�o.Integracion.Product;

import java.util.ArrayList;

import _2.Dise�o.Negocio.Product.imp.TProduct;


public interface DAOProduct {

	public int createProduct(TProduct tProduct);


	public int deleteProduct(int idProduct);


	public int modifyProduct(TProduct tProduct);


	public TProduct searchProduct(int idProduct);


	public ArrayList<TProduct>searchProductsByPrice(float price);


	public TProduct searchProductByName(String name);


	public ArrayList<TProduct> listProduct();
}