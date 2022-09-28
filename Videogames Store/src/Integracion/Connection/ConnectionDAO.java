/**
 * 
 */
package _2.Diseño.Integracion.Connection;

import java.sql.Connection;

import _2.Diseño.Integracion.Connection.imp.ConnectionDAOImp;


public abstract class ConnectionDAO {

	private static ConnectionDAO instance;


	public static ConnectionDAO getInstance() {
	
		// TODO Auto-generated constructor stub
		// begin-user-code
		// TODO auto-generated method stub
		// end-user-code
		if (instance == null) {
			instance = new ConnectionDAOImp();
		}
		return instance;
	}

public abstract Connection getConnection();
}