/**
 * 
 */
package _2.Diseño.Integracion.Ticket.imp;

import _2.Diseño.Integracion.Ticket.DAOTicket;
import _2.Diseño.Negocio.Ticket.imp.TTicket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Ticket.imp.LineaTicket;


public class DAOTicketImp implements DAOTicket {

	static final String CIF = "1234VMS"; //Cif de nuestra tienda, es común a todos los tickets
	
	public int createTicket(TTicket tTicket) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		int idTicket = -1;
		boolean empoderao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		//el dao abre la conexion
		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		}
		else {
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "INSERT INTO ticket (idClient, cif, date, fullPrice, active)" + " VALUES ("+ tTicket.getIdCliente() + ", '" + CIF + "', '" + tTicket.getDate() + "', " + tTicket.getPrice() + ", " + 0 + ");";
				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_added from ticket";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idTicket = resultSet.getInt("last_added");
					HashMap<Integer, LineaTicket> lineaTickets = tTicket.getLineaTicket();
					Collection<LineaTicket> values = lineaTickets.values();
					Iterator<LineaTicket> iterator = values.iterator();
					LineaTicket lt;
					while (iterator.hasNext()) {
						lt = iterator.next();
						query = "INSERT INTO lineTicket (idTicket,idProduct,numberProducts,fullPriceProducts)" + " VALUES ("
								+ idTicket + ", " + lt.getIdProduct() + ", " + lt.getNumProducts() + ", "
								+ lt.getTotalPrice() + ");";
						statement.executeUpdate(query);
					}
				}

				statement.close();
				if (empoderao) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				idTicket = -1;
			}
		}
		
		return idTicket;
		// end-user-code
	}


	public TTicket searchTicket(int idTicket) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		boolean empoderao = false;
		TTicket tTicket = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		//el dao abre la conexion
		if (transaction != null) {
			connection = (Connection) transaction.getResource();

		} 
		else {
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM ticket WHERE idTicket=" + idTicket;
				if (!empoderao)
					query = "SELECT * FROM ticket WHERE idTicket=" + idTicket + " FOR UPDATE";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					HashMap<Integer, LineaTicket> lineaTickets = new HashMap<>();
					tTicket = new TTicket(idTicket, resultSet.getInt("idClient"), resultSet.getString("cif"), resultSet.getDate("date"), resultSet.getFloat("fullPrice"), 
							 lineaTickets, false);
					query = "SELECT * FROM lineTicket WHERE idTicket=" + idTicket;
					if (!empoderao)
						query = "SELECT * FROM lineTicket WHERE idTicket=" + idTicket + " FOR UPDATE";
					resultSet = statement.executeQuery(query);
					LineaTicket lt;
					while (resultSet.next()) {
						lt = new LineaTicket(idTicket, resultSet.getInt("idProduct"),
								resultSet.getInt("numberProducts"), resultSet.getFloat("fullPriceProducts"));
						lineaTickets.put(lt.getIdProduct(), lt);
					}
				}
				
				statement.close();
				if (empoderao) {
					connection.close();
				}

			} catch (SQLException e) {
				tTicket = null;
			}
		}
		
		return tTicket;
		// end-user-code
	}


	public ArrayList<TTicket> listTickets() {
		// begin-user-code
		// TODO Auto-generated method stub
		
		boolean empoderao = false;
		ArrayList<TTicket> listaTickets = new ArrayList<>();

		TTicket tTicket = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		//el dao abre la conexion
		if (transaction != null) {
			connection = (Connection) transaction.getResource();

		} 
		else {
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}	
		
		if (connection != null) {
			try {
				Statement st1 = connection.createStatement();
				Statement st2 = connection.createStatement();
				String query = "SELECT * FROM ticket";
				if (!empoderao)
					query = "SELECT * FROM ticket FOR UPDATE";
				ResultSet rs1 = st1.executeQuery(query);
				ResultSet rs2;
				HashMap<Integer, LineaTicket> lineaTickets;
				while (rs1.next()) {
					lineaTickets = new HashMap<>();
					tTicket = new TTicket(rs1.getInt("idTicket"), rs1.getInt("idClient"), rs1.getString("cif"),
							rs1.getDate("date"), rs1.getFloat("fullPrice"), lineaTickets, false);
					query = "SELECT * FROM lineTicket WHERE idTicket=" + tTicket.getIdTicket();
					rs2 = st2.executeQuery(query);
					LineaTicket lt;
					while (rs2.next()) {
						lt = new LineaTicket(rs2.getInt("idTicket"), rs2.getInt("numberProducts"),
								rs2.getFloat("fullPriceProducts"));
						lineaTickets.put(lt.getIdProduct(), lt);
					}
					listaTickets.add(tTicket);
				}
				
				st1.close();
				st2.close();
				if (empoderao)
					connection.close();
			} catch (SQLException e) {
				tTicket = null;
			}
		}
		
		return listaTickets;
		// end-user-code
	}


	public int modifyTicket(TTicket tTicket) {
		// begin-user-code
		// TODO Auto-generated method stub
		
		int id = -1;
		boolean empoderao = false;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		//el dao abre la conexion
		if (transaction != null) {
			connection = (Connection) transaction.getResource();

		} 
		else {
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}		
		
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "UPDATE ticket SET " + " " + "date='" + tTicket.getDate() + "'," + "fullPrice='"
						+ tTicket.getPrice() + "' " + "WHERE idTicket=" + tTicket.getIdTicket() + ";";
				statement.executeUpdate(query);
				HashMap<Integer, LineaTicket> lineaTickets = tTicket.getLineaTicket();
				Collection<LineaTicket> values = lineaTickets.values();
				Iterator<LineaTicket> iterator = values.iterator();
				LineaTicket lt;
				while (iterator.hasNext()) {
					lt = iterator.next();
					query = "UPDATE lineticket SET " + "numberProducts=" + lt.getNumProducts() + ", "
							+ "fullPriceProducts=" + lt.getTotalPrice() + " " + "WHERE idTicket="
							+ tTicket.getIdTicket() + " AND idProduct=" + lt.getIdProduct();
					statement.executeUpdate(query);
				}
				id = tTicket.getIdTicket();
				
				statement.close();
				if (empoderao)
					connection.close();
			} catch (SQLException e) {
				id = -1;
			}
		}
		
		return id;
		// end-user-code
	}
}