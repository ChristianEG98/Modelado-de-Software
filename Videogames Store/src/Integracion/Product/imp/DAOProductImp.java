/**
 * 
 */
package _2.Diseño.Integracion.Product.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import _2.Diseño.Integracion.Connection.ConnectionDAO;
import _2.Diseño.Integracion.Product.DAOProduct;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Product.imp.TConsoles;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Product.imp.TVideogames;
import _2.Diseño.Negocio.Product.imp.VideogamesType;


public class DAOProductImp implements DAOProduct {

	public int createProduct(TProduct tProduct) {
		int id =-1;
		boolean empoderao = false;
		
		TransactionManager transactionManager= TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection=null;
		
		if (transaction!=null) connection = (Connection) transaction.getResource();	
		else{ //DAO empoderao
			empoderao = true;
			ConnectionDAO connectionDAO = ConnectionDAO.getInstance();
			connection = connectionDAO.getConnection();
		}
		if (connection!=null) {
			try{
				Statement statement = connection.createStatement();
				int active = 0;
				if(tProduct.getActive()) active = 1;
				String q = "INSERT INTO product(name, price, stock,active)" + "VALUES" + "('" +tProduct.getName()+ "','" +tProduct.getPrice()+ "' ,'" +tProduct.getStock()+ "','"+ active + "');";
				statement.executeUpdate(q);
				q = "SELECT last_insert_id() as last_id from product";
				ResultSet resulset= statement.executeQuery(q);
				if (resulset.next()) id = resulset.getInt("last_id");
				if (tProduct instanceof TConsoles) {
					q = "INSERT INTO consoles(idProduct,storage, manufacture, colour)"+"VALUES ('" +id +"','" +((TConsoles)tProduct).getStorage()+ "','" +((TConsoles)tProduct).getManufacturer()+ "','" +((TConsoles)tProduct).getColour() + "');";
					statement.executeUpdate(q);
				}
				else{
					q = "INSERT INTO videogames (idProduct, gender, age, platform)"+"VALUES ('" +id + "','" +((TVideogames)tProduct).getGender()+ "','" +((TVideogames)tProduct).getAge()+ "','" +((TVideogames)tProduct).getPlatform() + "');";
					statement.executeUpdate(q);
				}
				statement.close();
				if (empoderao) connection.close();
			}catch (SQLException exception) {
				System.out.println(exception.getMessage());
				id=-1;
			}
		}
		return id;
	}


	public int deleteProduct(int idProduct) {
		int id = -1;
		boolean empoderao = false;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String q = "UPDATE product SET active = 0 WHERE idProduct=" + idProduct+"";
				statement.executeUpdate(q);
				id = idProduct;
				statement.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				id = -1;
			}
		}
		return id;
	}


	public int modifyProduct(TProduct tProduct) {
		int id = -1;
		boolean empoderao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				System.out.print(tProduct.getActive());
				String q = "UPDATE product SET " + "name='" + tProduct.getName() + "', " + "price=" + tProduct.getPrice() + ", " + "stock=" + tProduct.getStock() + ", " + "active=" + (tProduct.getActive() ? 1 : 0) + " " + "WHERE idProduct =" + tProduct.getIdProduct();
				statement.executeUpdate(q);
				if (tProduct instanceof TVideogames) {
					q = "UPDATE videogames SET " + "platform='" + ((TVideogames) tProduct).getPlatform() + "', " + "age='"+ ((TVideogames) tProduct).getAge() + "', " + "gender='"+ ((TVideogames) tProduct).getGender() + "' " + "WHERE idProduct=" + tProduct.getIdProduct();
					statement.executeUpdate(q);
				
				} else {
					q = "UPDATE consoles SET " + "storage=" + ((TConsoles) tProduct).getStorage() + ", " + "manufacture='" + ((TConsoles) tProduct).getManufacturer() + "', " + "colour='" + ((TConsoles) tProduct).getColour() + "' " + "WHERE idProduct=" + tProduct.getIdProduct();
					statement.executeUpdate(q);
				}
				id = tProduct.getIdProduct();
				statement.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				id = -1;
			}
		}
		return id;
	}


	public TProduct searchProduct(int idProduct) {
		TProduct tProduct = null;
		boolean empoderao = false;
		
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String q = "SELECT * FROM product WHERE idProduct=" + idProduct;
				if (!empoderao)
					q += " FOR UPDATE" ;
				ResultSet resultSet = statement.executeQuery(q);
				if(resultSet.next()) {
					TProduct tProductRead = new TProduct(idProduct, resultSet.getString("name"), resultSet.getFloat("price"), resultSet.getInt("stock"), resultSet.getBoolean("active"));
					q = "SELECT * FROM consoles WHERE idProduct=" + idProduct;
					if (!empoderao) q += " FOR UPDATE" ;
					resultSet = statement.executeQuery(q);
					if(resultSet.next()) tProduct = new TConsoles(resultSet.getInt("idProduct"), tProductRead.getName(), tProductRead.getPrice(), tProductRead.getStock(), tProductRead.getActive(), resultSet.getInt("storage"), resultSet.getString("manufacture"), resultSet.getString("colour"));
					else {
						q = "SELECT * FROM videogames WHERE idProduct=" + idProduct;
						if (!empoderao) q += " FOR UPDATE" ;
						resultSet = statement.executeQuery(q);
						if (resultSet.next()) tProduct = new TVideogames(resultSet.getInt("idProduct"), tProductRead.getName(), tProductRead.getPrice(), tProductRead.getStock(), tProductRead.getActive(), resultSet.getString("gender"),	VideogamesType.parse(resultSet.getString("platform")), resultSet.getInt("age"));
					}
				}
				statement.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				tProduct = null;
			}
		}
		return tProduct;
	}


	public ArrayList<TProduct> searchProductsByPrice(float price) {
		ArrayList<TProduct> productList = new ArrayList<>();
		TProduct tProduct = null;
		boolean empoderao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if(connection!=null) {
			try {
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				String q = "SELECT * FROM product WHERE active=1 AND price <= " + price;
				if (!empoderao) q += " FOR UPDATE";
				ResultSet resultSet1 = statement1.executeQuery(q);
				ResultSet resultSet2;
				TProduct tProductRead;
				while(resultSet1.next()) {
					tProductRead = new TProduct(resultSet1.getInt("idProduct"), resultSet1.getString("name"), resultSet1.getFloat("price"), resultSet1.getInt("stock"), resultSet1.getBoolean("active"));
					q = "SELECT * FROM consoles WHERE idProduct=" + resultSet1.getInt("idProduct");
					if (!empoderao) q += " FOR UPDATE";
					resultSet2 = statement2.executeQuery(q);
					if(resultSet2.next()) tProduct = new TConsoles(resultSet2.getInt("idProduct"), tProductRead.getName(), tProductRead.getPrice(), tProductRead.getStock(), tProductRead.getActive(), resultSet2.getInt("storage"), resultSet2.getString("manufacture"), resultSet2.getString("colour"));
					else {
						q = "SELECT * FROM videogames WHERE idProduct=" + resultSet1.getInt("idProduct");
						if (!empoderao) q += " FOR UPDATE";
						resultSet2 = statement2.executeQuery(q);
						if(resultSet2.next()) tProduct = new TVideogames(resultSet2.getInt("idProduct"), tProductRead.getName(), tProductRead.getPrice(), tProductRead.getStock(), tProductRead.getActive(), resultSet2.getString("gender"),VideogamesType.parse(resultSet2.getString("platform")), resultSet2.getInt("age"));
					}
					productList.add(tProduct);
				}
				statement1.close();
				statement2.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				tProduct = null;
			}
		}
		return productList;
		
	}


	public TProduct searchProductByName(String name) {
		TProduct tProduct = null;
		boolean empoderao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String q = "SELECT * FROM product WHERE name='" + name + "'";
				if (!empoderao) q += " FOR UPDATE";
				ResultSet resultSet = statement.executeQuery(q);
				if(resultSet.next()) {
					TProduct tProductoLeido = new TProduct(resultSet.getInt("idProduct"), resultSet.getString("name"), resultSet.getFloat("price"), resultSet.getInt("stock"), resultSet.getBoolean("active"));
					q = "SELECT * FROM consoles WHERE idProduct=" + tProductoLeido.getIdProduct();
					if (!empoderao) q += " FOR UPDATE"; 
					resultSet = statement.executeQuery(q);
					if(resultSet.next()) tProduct =new TConsoles(resultSet.getInt("idProduct"), tProductoLeido.getName(), tProductoLeido.getPrice(), tProductoLeido.getStock(), tProductoLeido.getActive(), resultSet.getInt("storage"), resultSet.getString("manufacture"), resultSet.getString("colour"));
					else {
						q = "SELECT * FROM videogames WHERE idProduct=" + tProductoLeido.getIdProduct();
						if (!empoderao) q += " FOR UPDATE";
						resultSet = statement.executeQuery(q);
						if (resultSet.next()) tProduct = new TVideogames(resultSet.getInt("idProduct"), tProductoLeido.getName(), tProductoLeido.getPrice(), tProductoLeido.getStock(), tProductoLeido.getActive(), resultSet.getString("gender"),	VideogamesType.parse(resultSet.getString("platform")), resultSet.getInt("age"));
					}
				}
				statement.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				tProduct = null;
			}
		}
		return tProduct;
	}


	public ArrayList<TProduct> listProduct() {
		ArrayList<TProduct> productList = new ArrayList<>();
		TProduct tProduct = null;
		
		boolean empoderao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) connection = (Connection) transaction.getResource();
		else { //DAO empoderao
			empoderao = true;
			ConnectionDAO c = ConnectionDAO.getInstance();
			connection = c.getConnection();
		}
		if(connection != null) {
			try {
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				String q = "SELECT * FROM product WHERE active=1";
				if (!empoderao)
					q= "SELECT * FROM product WHERE active=1 FOR UPDATE";
				ResultSet resultSet1 = statement1.executeQuery(q);
				ResultSet resultSet2;
				TProduct tProductoLeido;
				while(resultSet1.next()) {
					tProductoLeido = new TProduct(resultSet1.getInt("idProduct"), resultSet1.getString("name"), resultSet1.getFloat("price"), resultSet1.getInt("stock"), resultSet1.getBoolean("active"));
					q = "SELECT * FROM consoles WHERE idProduct=" + tProductoLeido.getIdProduct();
					if (!empoderao) q = "SELECT * FROM consoles WHERE idProduct=" + tProductoLeido.getIdProduct() + " FOR UPDATE";
					resultSet2 = statement2.executeQuery(q);
					if(resultSet2.next()) tProduct = new TConsoles(resultSet2.getInt("idProduct"), tProductoLeido.getName(), tProductoLeido.getPrice(), tProductoLeido.getStock(), tProductoLeido.getActive(), resultSet2.getInt("storage"), resultSet2.getString("manufacture"), resultSet2.getString("colour"));
					else {
						q = "SELECT * FROM videogames WHERE idProduct=" + resultSet1.getInt("idProduct");
						if (!empoderao) q = "SELECT * FROM videogames WHERE idProduct=" + resultSet1.getInt("idProduct") + " FOR UPDATE";
						resultSet2 = statement2.executeQuery(q);
						if(resultSet2.next()) tProduct = new TVideogames(resultSet2.getInt("idProduct"), tProductoLeido.getName(), tProductoLeido.getPrice(), tProductoLeido.getStock(), tProductoLeido.getActive(), resultSet2.getString("gender"),VideogamesType.parse(resultSet2.getString("platform")), resultSet2.getInt("age"));
					}
					productList.add(tProduct);
				}
				statement1.close();
				statement2.close();
				if (empoderao) connection.close();
			} catch (SQLException e) {
				tProduct = null;
			}
		}
		return productList;
	}
	
}