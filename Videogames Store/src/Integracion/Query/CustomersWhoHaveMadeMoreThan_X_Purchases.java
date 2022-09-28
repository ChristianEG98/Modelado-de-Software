/**
 * 
 */
package _2.Diseño.Integracion.Query;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Client.imp.TClient;


public class CustomersWhoHaveMadeMoreThan_X_Purchases implements Query {

	public Object execute(Object Parameter2) {
		ArrayList<TClient> listClients = new ArrayList<>();
		TClient tClient = null;
		
		int purchases = ((TQuery) Parameter2).getIdProduct();
		
		boolean empoderao = false;

        TransactionManager transactionManager = TransactionManager.getInstance();
        Transaction transaction = transactionManager.getTransaction();
        Connection connection = null;

        if (transaction != null) {
            connection = (Connection) transaction.getResource();
        } else { // "DAO empoderao"
        	empoderao = true;
            ConnectionDAO c = ConnectionDAO.getInstance();
            connection = c.getConnection();
        }
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT c.*, SUM(t.fullPrice) as 'Total Gastado', COUNT(*) as 'Numero de compras' "
                		+ " FROM client c"
                		+ " JOIN ticket t ON t.idClient = c.idClient"
                		+ " GROUP by c.idClient"
                		+ " HAVING count(*) >" + purchases;
                ResultSet resultSet = statement.executeQuery(query); 
                if(!empoderao)
                    query = "SELECT c.*, SUM(t.fullPrice) as 'Total Gastado', COUNT(*) as 'Numero de compras' "
                    		+ " FROM client c"
                    		+ " JOIN ticket t ON t.idclient = c.idClient"
                    		+ " GROUP by c.idClient"
                    		+ " HAVING count(*) >" + purchases + "FOR UPDATE";

                while(resultSet.next()){
                	tClient = new TClient(
                            resultSet.getInt("idClient"),
                            resultSet.getString("name"),
                            resultSet.getString("lastName"),
                            resultSet.getString("email"),
                            resultSet.getString("DNI"),
                            resultSet.getInt("phone"),
                            resultSet.getBoolean("active")
                            );
                 	   listClients.add(tClient);
                }  
                statement.close();
                if (empoderao)
                    connection.close();
            } catch (SQLException e) {
            	tClient = null;
            }
        }
		
		return listClients;
	}
}