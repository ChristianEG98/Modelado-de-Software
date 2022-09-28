/**
 * 
 */
package _2.Dise�o.Integracion.Transaction.TransactionFactory;

import _2.Dise�o.Integracion.Transaction.Transaction;
import _2.Dise�o.Integracion.Transaction.TransactionMySQL;


public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction createTransaction() {
		return new TransactionMySQL();
	}
}