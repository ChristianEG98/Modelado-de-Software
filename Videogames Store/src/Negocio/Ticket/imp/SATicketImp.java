/**
 * 
 */
package _2.Diseño.Negocio.Ticket.imp;

import _2.Diseño.Integracion.Client.DAOClient;
import _2.Diseño.Integracion.Factory.FactoryIntegration;
import _2.Diseño.Integracion.Product.DAOProduct;
import _2.Diseño.Integracion.Ticket.DAOTicket;
import _2.Diseño.Integracion.Transaction.Transaction;
import _2.Diseño.Integracion.Transaction.TransactionManager.TransactionManager;
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Negocio.Ticket.SATicket;
import _2.Diseño.Presentacion.Ticket.GUITicket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;


public class SATicketImp implements SATicket {
	
	public TTicket createTicket(int idClient) {
		TTicket newTicket = null;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();

			FactoryIntegration fi = FactoryIntegration.getInstance();
			DAOClient dc = fi.createDAOClient();

			TClient tClient = dc.searchClient(idClient);
			if (tClient != null) {

				boolean ok = tClient.getActive();

				if (ok) {
					newTicket = new TTicket(idClient);
				}
			} else {
				transaction.rollback();
			}

			
		}
		transactionManager.deleteTransaction();
		return newTicket;
	}


	public TTicket searchTicket(int idTicket) {
		TTicket tTicket = null;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();
			FactoryIntegration fi = FactoryIntegration.getInstance();
			DAOTicket daoTicket = fi.createDAOTicket(); //crear
			tTicket = daoTicket.searchTicket(idTicket);
			if (tTicket == null)
				transaction.rollback();
			else
				transaction.commit();
		}

		transactionManager.deleteTransaction();

		return tTicket;
	}


	public int closeTicket(TTicket tTicket) {
				int idTicket = -100;
				if (tTicket != null) { 
					boolean ok = tTicket.getActive();
					if (ok) { 
						TransactionManager transactionManager = TransactionManager.getInstance();
						Transaction transaction = transactionManager.createTransaction();
						if (transaction != null) {
							transaction.start();
							HashMap<Integer, LineaTicket> ticketLine = tTicket.getLineaTicket();

							if (!ticketLine.isEmpty()) {
								FactoryIntegration fi = FactoryIntegration.getInstance();
								DAOProduct dp = fi.createDAOProduct();
								Collection<LineaTicket> clt = ticketLine.values();
								Iterator<LineaTicket> iterator = clt.iterator();
								LineaTicket tl;
								float totalprice = 0;
								while (iterator.hasNext()) {
									tl = iterator.next();
									TProduct ptl = dp.searchProduct(tl.getIdProduct());
									if (ptl != null) {
										if (tl.getNumProducts() <= ptl.getStock()) {
											int stock = ptl.getStock() - tl.getNumProducts();
											ptl.setStock(stock);
											int productupdated = dp.modifyProduct(ptl);
											if (productupdated > 0) {
												float priceproduct = ptl.getPrice();
												tl.setTotalPrice(priceproduct * tl.getNumProducts());
												float finalprice = tl.getTotalPrice();
												totalprice += finalprice;
												tTicket.setPrice(totalprice);
											} 
											else {
												ticketLine.remove(tl.getIdProduct());
												idTicket = -8;
												transaction.rollback();
											}

										} 
										else {
											ticketLine.remove(tl.getIdProduct());
											idTicket = -7;
										}
									} 
									else {
										ticketLine.remove(tl.getIdProduct());
										idTicket = -6;
										transaction.rollback();
									}

								}

								if (!ticketLine.isEmpty()) {

									Calendar calendar = Calendar.getInstance();
									long timeInMillis = calendar.getTimeInMillis();
									Date date = new Date(timeInMillis);
									
									tTicket.setDate(date);
									tTicket.setActive(false); //cambiar en el diagrama
									DAOTicket dt = fi.createDAOTicket();
									idTicket = dt.createTicket(tTicket);

									if (idTicket < 0)
										transaction.rollback();
									else
										transaction.commit();
								} 
								else {
									
									transaction.rollback();
								}

							} 
							else {
								idTicket = -4;
								transaction.rollback();
							}

						} 
						else {
							idTicket = -3;
						}

						transactionManager.deleteTransaction();

					} 
					else {
						idTicket = -2;
					}

				} 

				return idTicket;
	}

	
	public ArrayList<TTicket> listTickets() {
		ArrayList<TTicket> tickets = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();
			DAOTicket dt = FactoryIntegration.getInstance().createDAOTicket();
			tickets = dt.listTickets();
			transaction.commit();
		}
		transactionManager.deleteTransaction();
		return tickets;
	}

	
	public TTicket modifyTicket(int idProducto, int numProductos) { //es void? o devolvuelve el tticket modificado-> TTicket modificado, cambiado en modelo
		TTicket ticket = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		if (transaction != null) {
			transaction.start();
			FactoryIntegration factoriaIntegracion = FactoryIntegration.getInstance();
			GUITicket guit = GUITicket.getInstance();
			ticket = guit.getCurrentTicket(); //falta-> arreglado en GUITicket
			if (ticket != null) {
				DAOProduct dp = factoriaIntegracion.createDAOProduct();
				TProduct p = dp.searchProduct(idProducto);
				if (p != null && p.getActive()) {
					HashMap<Integer, LineaTicket> tlmap = ticket.getLineaTicket();
					boolean ok = tlmap.containsKey(idProducto);
					if (!ok) {
						LineaTicket tl = new LineaTicket(idProducto, numProductos, 0);
						tlmap.put(idProducto, tl);
					}
					else {
						if (numProductos == 0) {
							tlmap.remove(idProducto);
						} 
						else {
							LineaTicket tlaux = tlmap.get(idProducto);
							tlaux.setNumProducts(numProductos);
							tlmap.put(idProducto, tlaux);
						}
					}
					ticket.setLineaTicket(tlmap); //falta un set de la linea ticket-> ver diag clase: no sale en transfer pero sí en codigo. Arreglado
					guit.setTicket(ticket);//setTicket incluido en GUITicket
					transaction.commit();

				} else {
					transaction.rollback();
				}

			}
			transactionManager.deleteTransaction();

		}

		return ticket;

	}

	
	public int returnProduct(int idTicket, int idProduct, int numProductos) {
		int id = -100;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		if (transaction != null) {
			transaction.start();
			FactoryIntegration factoriaIntegracion = FactoryIntegration.getInstance();
			DAOTicket dt = factoriaIntegracion.createDAOTicket();
			TTicket tticket = dt.searchTicket(idTicket);

			if (tticket != null) {
				DAOProduct dp = factoriaIntegracion.createDAOProduct();
				TProduct tproduct = dp.searchProduct(idProduct);
				if (tproduct != null && tproduct.getActive()) {
					HashMap<Integer, LineaTicket> tlmap = tticket.getLineaTicket();
					LineaTicket tl = tlmap.get(idProduct);
					if (tl != null) {
						int soldquantity = tl.getNumProducts();
						if (soldquantity >= numProductos) {
							float price = tl.getTotalPrice();
							tl.setNumProducts(soldquantity - numProductos);
							tl.setTotalPrice(price - (price / soldquantity) * numProductos);
							int stock = tproduct.getStock();
							tproduct.setStock(stock + numProductos);
							id = dp.modifyProduct(tproduct);
							if (id != -100) {
								float totalprice = tticket.getPrice();
								tticket.setPrice(totalprice - (price / soldquantity) * numProductos);
								id = dt.modifyTicket(tticket);
								if (id == -100){
									transaction.rollback();
								}
								else{
									transaction.commit();
								}
							} 
							else{
								transaction.rollback();
							}
							
						}
						else {
							id = -11;
							transaction.rollback();
						}
						
					}
					else {
						id = -10;
						transaction.rollback();
					}
				}
				else {
					id = -9;
					transaction.rollback();
				}
			}
			else {
				id = -8;
				transaction.rollback();
			}
		}
		transactionManager.deleteTransaction();
		return id;
	}

	
	public TOATotalInvoice getTotalInvoice(int idTicket) { //tendremos que pasarle el id en los diagramas no? y como va a ser un get void-> arreglado
		TOATotalInvoice invoice = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		if (transaction != null) {
			transaction.start();
			FactoryIntegration factoriaIntegracion = FactoryIntegration.getInstance();
			DAOTicket dt = factoriaIntegracion.createDAOTicket();
			TTicket tticket = dt.searchTicket(idTicket);
			if (tticket == null){
				transaction.rollback();
			}
			else {
				DAOProduct dp = factoriaIntegracion.createDAOProduct();
				ArrayList<TProduct> productos = new ArrayList<TProduct>();
				DAOClient daoClients = factoriaIntegracion.createDAOClient();
				TClient client = daoClients.searchClient(tticket.getIdCliente());
				HashMap<Integer, LineaTicket> tlmap = tticket.getLineaTicket();
				Collection<LineaTicket> tlc = tlmap.values();
				Iterator<LineaTicket> iterator = tlc.iterator();
				LineaTicket tl;
				while (iterator.hasNext()) {
					tl = iterator.next();
					TProduct product2sell = dp.searchProduct(tl.getIdProduct());
					if (product2sell != null){
						productos.add(product2sell);
					}
				}
				if (client == null || tlmap == null || productos.isEmpty()) {
					transaction.rollback();
				} 
				else {
					invoice = new TOATotalInvoice(client, productos, tticket);
					transaction.commit();
				}

			}
		}

		transactionManager.deleteTransaction();

		return invoice;
	}

}