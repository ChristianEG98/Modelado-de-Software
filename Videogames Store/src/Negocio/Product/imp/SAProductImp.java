/**
 * 
 */
package _2.Diseño.Negocio.Product.imp;

import java.util.ArrayList;

import _2.Diseño.Integracion.Factory.FactoryIntegration;
import _2.Diseño.Integracion.Product.DAOProduct;
import _2.Diseño.Integracion.Query.FactoryQuery;
import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Product.SAProduct;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author David
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public  class SAProductImp implements SAProduct {
	/** 
	* (non-Javadoc)
	* @see SAProduct#createProduct(TProduct tProduct)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int createProduct(TProduct tProduct) {
	
		int id = -1; //Product exists
		
		if (tProduct != null) {
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.createTransaction();
			transaction.start();

			FactoryIntegration integrationFactory = FactoryIntegration.getInstance();
			DAOProduct daoProduct = integrationFactory.createDAOProduct();

			TProduct tProductExists = daoProduct.searchProductByName(tProduct.getName());
			
			tProduct.setActive(true);

			if(tProductExists == null){
				id = daoProduct.createProduct(tProduct);
				if(id == -100) transaction.rollback();
				else transaction.commit();
			}
			else{
				if(!tProductExists.getActive()){
					if ((tProductExists instanceof TConsoles && tProduct instanceof TConsoles) || tProductExists instanceof TVideogames && tProduct instanceof TVideogames) {
						tProduct.setIdProduct(tProductExists.getIdProduct());
						id = daoProduct.modifyProduct(tProduct);
						if (id == -100) transaction.rollback();
						else transaction.commit();
					} else {
						transaction.rollback();
						id = -2;
					}
				}
				else transaction.rollback();
			}
			transactionManager.deleteTransaction();
		}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProduct#deleteProduct(Integer idProduct)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int deleteProduct(int idProduct) {
		int id = -1; // Product does not exist

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();

		FactoryIntegration integrationFactory = FactoryIntegration.getInstance();
		DAOProduct daoProducto = integrationFactory.createDAOProduct();

		TProduct tProductExists = daoProducto.searchProduct(idProduct);

		if (tProductExists == null) transaction.rollback();
		else {
			if (tProductExists.getActive()) {
				id = daoProducto.deleteProduct(idProduct);
				if (id == -100) transaction.rollback();
				else transaction.commit();
			} else {
				transaction.rollback();
				id = -2;
			}
		}
		transactionManager.deleteTransaction();

		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProduct#modifyProduct(TProduct tProduct)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int modifyProduct(TProduct tProduct) {
		int id = -1; //Product does not exist

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		FactoryIntegration factoryIntegration = FactoryIntegration.getInstance();
		DAOProduct daoProduct = factoryIntegration.createDAOProduct();

		TProduct tProductExists = daoProduct.searchProduct(tProduct.getIdProduct());

		if (tProductExists == null) transaction.rollback();
		else {
			if (tProductExists.getActive()) {
				TProduct tModificar = daoProduct.searchProductByName(tProduct.getName());
				if (tModificar == null) {
					id = daoProduct.modifyProduct(tProduct);
					if (id == -100) transaction.rollback();
					else transaction.commit();
				} else {
					if(tProductExists.getIdProduct() == tModificar.getIdProduct()){
						id = daoProduct.modifyProduct(tProduct);
						if (id == -100) transaction.rollback();
						else transaction.commit();
					} else {
						id = -2;
						transaction.rollback();
					}
				}
			} else {
				id = -3;
				transaction.rollback();
			}
		}
		transactionManager.deleteTransaction();
		
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProduct#searchProduct(Integer idProduct)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProduct searchProduct(int idProduct) {
		TProduct tProducto = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		DAOProduct daoProduct = FactoryIntegration.getInstance().createDAOProduct();
		tProducto = daoProduct.searchProduct(idProduct);
		
		if(tProducto == null) transaction.rollback();
		else transaction.commit();
	
		transactionManager.deleteTransaction();
		
		return tProducto;
	}

	/** 
	* (non-Javadoc)
	* @see SAProduct#searchProductsByPrice(Float price)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProduct> searchProductsByPrice(float price) {
		ArrayList<TProduct> products = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		
		transaction.start();
		DAOProduct daoProducto = FactoryIntegration.getInstance().createDAOProduct();
		products = daoProducto.searchProductsByPrice(price);
		transaction.commit();
		
		transactionManager.deleteTransaction();
		return products;
	}

	
	/** 
	* (non-Javadoc)
	* @see SAProduct#listProducts()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProduct> listProducts() {
		ArrayList<TProduct> products = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		
		transaction.start();
		DAOProduct daoProducto = FactoryIntegration.getInstance().createDAOProduct();
		products = daoProducto.listProduct();
		transaction.commit();
		
		transactionManager.deleteTransaction();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TProduct> BestSellingProductSince_X_Date(TQuery dat) {
		// TODO Auto-generated method stub
			ArrayList<TProduct> products = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		FactoryQuery factoriaQuery = FactoryQuery.getInstance();
		products =  (ArrayList<TProduct>) factoriaQuery.bestSellingProductSince_X_Date().execute(dat);
		transaction.commit();
	
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return products;
	}
}