/**
 * 
 */
package _2.Diseño.Integracion.Query;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Negocio.Product.imp.VideogamesType;


public class BestSellingProductSince_X_Date implements Query {

	public Object execute(Object o) {
		// begin-user-code
		// TODO Auto-generated method stub
		ArrayList<TProduct> listProducts = new ArrayList<>();
		TProduct tProduct = null;
		
		Date fechaCompra = ((TQuery) o).getFecha();
		
		boolean daoBilbao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else { //DAO de Bilbao
			daoBilbao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if (connection != null) {

			try {
				Statement statement = connection.createStatement();
				Statement statement2 = connection.createStatement();
				
				String query = "SELECT product.* FROM product"
							+ " JOIN lineTicket ON product.idProduct = lineTicket.idProduct"
							+ " JOIN ticket ON ticket.idTicket = lineTicket.idTicket"
							+ " WHERE ticket.date >='" + fechaCompra
							+ "' GROUP BY lineTicket.idProduct HAVING SUM(lineTicket.numberProducts)="
							+ "(SELECT SUM(lineTicket.numberProducts) max_suma FROM lineTicket"
							+ " JOIN ticket ON ticket.idTicket = lineTicket.idTicket "
							+ "GROUP BY lineTicket.idProduct ORDER BY max_suma DESC LIMIT 1)";

													
				if (!daoBilbao)
					query = "SELECT product.* FROM product"
							+ " JOIN lineTicket ON product.idProduct = lineTicket.idProduct"
							+ " JOIN ticket ON ticket.idTicket = lineTicket.idTicket"
							+ " WHERE ticket.date >='" + fechaCompra
							+ "'GROUP BY lineTicket.idProduct HAVING SUM(lineTicket.numberProducts)="
							+ "(SELECT SUM(lineTicket.numberProducts) max_suma FROM lineTicket"
							+ " JOIN ticket ON ticket.idTicket = lineTicket.idTicket "
							+ "GROUP BY lineTicket.idProduct ORDER BY max_suma DESC LIMIT 1) FOR UPDATE";
				
				ResultSet resultSet = statement.executeQuery(query);
				ResultSet resultSet2;
				TProduct tProductLeido;
				while(resultSet.next()) {
					tProductLeido = new TProduct(
							resultSet.getInt("idProduct"),
							resultSet.getString("name"),
							resultSet.getFloat("price"),
							resultSet.getInt("stock"),
							resultSet.getBoolean("active")
							);
					query = "SELECT * FROM videogames WHERE idProduct=" + resultSet.getInt("idProduct");
					if (!daoBilbao){
						query = "SELECT * FROM videogames WHERE idProduct=" + resultSet.getInt("idProduct") + " FOR UPDATE";
					}
					resultSet2 = statement2.executeQuery(query);
					if(resultSet2.next()) {
						tProduct = new TVideogames(
							resultSet2.getInt("idProduct"),
							tProductLeido.getName(),
							tProductLeido.getPrice(),
							tProductLeido.getStock(),
							tProductLeido.getActive(),
							resultSet2.getString("gender"),
							VideogamesType.parse(resultSet2.getString("platform")),
							resultSet2.getInt("age")
							);
					} else {
						query = "SELECT * FROM consoles WHERE idProduct=" + resultSet.getInt("idProduct");
						if (!daoBilbao)
							query = "SELECT * FROM consoles WHERE idProduct=" + resultSet.getInt("idProduct") + " FOR UPDATE";
						resultSet2 = statement2.executeQuery(query);
						if(resultSet2.next()) {
							tProduct = new TConsoles(
									resultSet2.getInt("idProduct"),
									tProductLeido.getName(),
									tProductLeido.getPrice(),
									tProductLeido.getStock(),
									tProductLeido.getActive(),
									resultSet2.getInt("storage"),
									resultSet2.getString("colour"),
									resultSet2.getString("manufacture")
									);
						}
					}
					listProducts.add(tProduct);
					}
				
				if (daoBilbao)
					connection.close();
				
				} catch (SQLException e) {
					tProduct = null;
				}
			
			}

		return listProducts;
	}
}