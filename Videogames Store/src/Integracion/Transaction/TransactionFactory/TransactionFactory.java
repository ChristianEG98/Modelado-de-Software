/**
 * 
 */
package _2.Dise�o.Integracion.Transaction.TransactionFactory;

import _2.Dise�o.Integracion.Transaction.Transaction;


public abstract class TransactionFactory {
	
	private static TransactionFactory instance;

	
	public abstract Transaction createTransaction();

	
	public static TransactionFactory getInstance() {
		if(instance==null)
		{
			instance=new TransactionFactoryImp();
		}
		return instance;
	}
}