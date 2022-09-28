/**
 * 
 */
package _2.Dise�o.Integracion.Factory;

import _2.Dise�o.Integracion.Client.DAOClient;
import _2.Dise�o.Integracion.Factory.imp.FactoryIntegrationImp;
import _2.Dise�o.Integracion.Product.DAOProduct;
import _2.Dise�o.Integracion.Ticket.DAOTicket;



public abstract class FactoryIntegration {

	private static FactoryIntegration instance;


	public synchronized static FactoryIntegration getInstance() {	
		if (instance==null) instance = new FactoryIntegrationImp();
		return instance;
	}


	public abstract DAOProduct createDAOProduct();
	
	public abstract DAOTicket createDAOTicket();
	
	public abstract DAOClient createDAOClient();

	
}