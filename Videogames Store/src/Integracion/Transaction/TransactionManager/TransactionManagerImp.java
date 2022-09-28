/**
 * 
 */
package _2.Diseño.Integracion.Transaction.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionFactory.TransactionFactory;


public class TransactionManagerImp extends TransactionManager {
	
	private ConcurrentHashMap<Thread, Transaction> transactions;

	
	public TransactionManagerImp(){
		transactions= new ConcurrentHashMap<Thread, Transaction>();
	}
	
	public void deleteTransaction() {
		Thread thread = Thread.currentThread();
		if (transactions!=null) transactions.remove(thread);
	}

	
	public Transaction createTransaction() {
		Thread thread = Thread.currentThread();
		Transaction transaction = null;
		if (this.transactions!= null) {
			transaction = this.transactions.get(thread);
			if (transaction == null) {
				TransactionFactory transactionFactory = TransactionFactory.getInstance();
				transaction = transactionFactory.createTransaction();
				this.transactions.put(thread, transaction);
			}
		}
		return transaction;
	}
	
	public Transaction getTransaction() {
		Thread thread = Thread.currentThread();
		Transaction transaction = null;
		if (this.transactions != null) {
			transaction = this.transactions.get(thread);
		}
		return transaction;
	}
	
}

	
