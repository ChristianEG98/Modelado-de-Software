/**
 * 
 */
package _2.Dise�o.Integracion.Transaction.TransactionManager;

import _2.Dise�o.Integracion.Transaction.Transaction;


public abstract class TransactionManager {
	
	private static TransactionManager instance;

	
	public abstract Transaction createTransaction();
	
	
	public abstract void deleteTransaction();
	
	public static TransactionManager getInstance() {
		
				
		if (instance==null)
		{
			instance= new TransactionManagerImp();
		}
		return instance;
	}


	public abstract Transaction getTransaction();
}