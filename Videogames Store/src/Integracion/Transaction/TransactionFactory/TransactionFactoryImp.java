/**
 * 
 */
package _2.Diseño.Integracion.Transaction.TransactionFactory;

import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionMySQL;


public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public Transaction createTransaction() {
		return new TransactionMySQL();
	}
}