/**
 * 
 */
package _2.Diseño.Integracion.Factory;

import _2.Diseño.Integracion.Client.DAOClient;
import _2.Diseño.Integracion.Factory.imp.FactoryIntegrationImp;
import _2.Diseño.Integracion.Product.DAOProduct;
import _2.Diseño.Integracion.Ticket.DAOTicket;



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