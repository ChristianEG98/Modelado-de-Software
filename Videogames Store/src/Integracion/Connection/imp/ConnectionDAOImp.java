/**
 * 
 */
package _2.Diseño.Integracion.Connection.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import _2.Diseño.Integracion.Connection.ConnectionDAO;

public class ConnectionDAOImp extends ConnectionDAO {

	private Connection connection;

	
	public Connection getConnection() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		try{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos", "root", "");
		}catch(SQLException exception)
		{
			exception.printStackTrace();
		}
		return connection;
	}


	public void close() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		
		try {
			if (connection!=null && !connection.isClosed()){
				connection.close();
			}
		}catch (SQLException exception) {
			// TODO: handle exception
			exception.printStackTrace();
		}
	}
}