/**
 * 
 */
package _2.Diseño.Integracion.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;


public class TransactionMySQL implements Transaction {
	
	private Connection connection;

	
	public void commit() {
		try {
			connection.commit();
			connection.close();
			TransactionManager.getInstance().deleteTransaction();
		}catch (SQLException exception) {
			exception.printStackTrace();
		}
		
	}

	
	public Object getResource() {
		return connection;
	}

	
	public void rollback() {
		try {
			connection.rollback();
			connection.close();
			
		}catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	
	public void start() {
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");
			connection.setAutoCommit(false);
		}catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}