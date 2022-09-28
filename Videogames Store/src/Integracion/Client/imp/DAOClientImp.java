package _2.Diseño.Integracion.Client.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import _2.Diseño.Integracion.Client.DAOClient;
import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Client.imp.TClient;

public class DAOClientImp implements DAOClient{

	public int createClient(TClient tClient) {
		// TODO Auto-generated method stub
		int id = -1;
        boolean empoderao = false;

        TransactionManager transactionManager = TransactionManager.getInstance(); 
        Transaction transaction = transactionManager.getTransaction();
        Connection connection = null;

        if(transaction!=null){
            connection = (Connection) transaction.getResource();
        }
        else { //"DAO empoderao"
        	empoderao = true;
            ConnectionDAO c = ConnectionDAO.getInstance();
            connection = c.getConnection();
        }
            if(connection != null){
                try {

                    Statement statement = connection.createStatement();
                    statement.executeUpdate("INSERT INTO client (name,lastName, DNI, email, phone, active)" + "VALUES" + "('" 
                    + tClient.getName() + "', '" 
                    + tClient.getLastName() + "', '" 
                    + tClient.getDNI() + "', '" 
                    + tClient.getEmail() + "', '" 
                    + tClient.getPhone() + "', "
                    + 1 + ");");

                    String query = "SELECT last_insert_id() as last_id from client";
                    ResultSet resultSet = statement.executeQuery(query);
                    if (resultSet.next())
                        id=resultSet.getInt("last_id");

                    statement.close();
                    if (empoderao)
                        connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    id = -1;
                }
            }
        return id;
	}

	
	public int deleteClient(int idClient) {
		// TODO Auto-generated method stub
		boolean empoderao = false;

        TransactionManager transactionManager = TransactionManager.getInstance(); 
        Transaction transaction = transactionManager.getTransaction();
        Connection connection = null;

        if(transaction!=null){
            connection = (Connection) transaction.getResource();
        }
        else { // "DAO empoderao"
        	empoderao = true;
            ConnectionDAO c = ConnectionDAO.getInstance();
            connection = c.getConnection();
        }
            if(connection != null){
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("UPDATE client SET active= 0  WHERE idClient=" + idClient);

                    statement.close();
                    if (empoderao)
                        connection.close(); 

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    idClient = -1;
                    }
            }

        return idClient;
	}

	public int modifyClient(TClient tClient) {
		// TODO Auto-generated method stub
		int id = -1;
        boolean empoderao = false;

        TransactionManager transactionManager = TransactionManager.getInstance(); 
        Transaction transaction = transactionManager.getTransaction();
        Connection connection = null;

        if(transaction!=null){
            connection = (Connection) transaction.getResource();
        }
        else { //"DAO empoderao"
        	empoderao = true;
            ConnectionDAO c = ConnectionDAO.getInstance();
            connection = c.getConnection();
        }
            if(connection != null){
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("UPDATE client SET "
                    + "name='" + tClient.getName() + "', "
                    + "lastName='" + tClient.getLastName() + "', "
                    + "DNI='" + tClient.getDNI() + "', " 
                    + "phone='" + tClient.getPhone() + "', " 
                    + "email='" + tClient.getEmail() + "', " 
                    + "active=" + (tClient.getActive() ? 1: 0) + " " 
                    + "WHERE idClient= " + tClient.getIdClient());

                    id = tClient.getIdClient();

                    statement.close();
                    if (empoderao)
                        connection.close();

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    id = -1;
                    }
                }

        return id;
	}

	public TClient searchClient(int idClient) {
		// TODO Auto-generated method stub
		TClient tClient = null;
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
                String query = "SELECT * FROM client WHERE idClient=" + idClient;

                if(!empoderao)
                    query = "SELECT * FROM client WHERE idClient=" + idClient + " FOR UPDATE";

                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()) {
                    tClient = new TClient(
                            resultSet.getInt("idClient"),
                            resultSet.getString("name"),
                            resultSet.getString("lastName"),
                            resultSet.getString("email"),
                            resultSet.getString("DNI"),
                            resultSet.getInt("phone"),
                            resultSet.getBoolean("active")
                            );
                }
                statement.close();
                if (empoderao)
                    connection.close();
            } catch (SQLException e) {
            	tClient = null;
            }
        }

        return tClient;
	}

	@Override
	public TClient searchClientByDni(String dni) {
		// TODO Auto-generated method stub
		TClient tClient = null;
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
                String query = "SELECT * FROM client WHERE DNI = '" + dni + "'";

                if(!empoderao)
                    query = "SELECT * FROM client WHERE DNI = '" + dni + "'"  + " FOR UPDATE";

                ResultSet resultSet = statement.executeQuery(query);
                if(resultSet.next()) {
                    tClient = new TClient(
                            resultSet.getInt("idClient"),
                            resultSet.getString("name"),
                            resultSet.getString("lastName"),
                            resultSet.getString("email"),
                            dni,
                            resultSet.getInt("phone"),
                            resultSet.getBoolean("active")
                            );
                }

                statement.close();
                if (empoderao)
                    connection.close();
            } catch (SQLException e) {
                tClient = null;
            }
        }

        return tClient;
	}

	@Override
	public ArrayList<TClient> listClients() {
		// TODO Auto-generated method stub
		ArrayList<TClient> listClients = new  ArrayList<>();
        TClient tClient = null;
        boolean empoderao = false;
        
        TransactionManager transactionManager = TransactionManager.getInstance(); 
           Transaction transaction = transactionManager.getTransaction();
           Connection connection = null;
                       if(transaction!=null){
               connection = (Connection) transaction.getResource();
           }   else { // "DAO empoderao"
        	   empoderao = true;
               	ConnectionDAO c = ConnectionDAO.getInstance();
               	connection = c.getConnection();            
               }
               if(connection != null){                    
            	   try {
                       Statement statement = connection.createStatement();
                       String query = "SELECT * FROM client WHERE active=1";
                       ResultSet resultSet = statement.executeQuery(query);                        
                       if (!empoderao)
                           query = "SELECT * FROM client WHERE active=1 FOR UPDATE";
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
                       if (empoderao)	connection.close(); 
                       
                   } catch (SQLException e) {
                       System.out.println(e.getMessage());
                       tClient = null;
                       }
               }
               
       return listClients;
   }

}
