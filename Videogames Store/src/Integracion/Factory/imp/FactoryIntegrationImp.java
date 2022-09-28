/**
 * 
 */
package _2.Diseño.Integracion.Factory.imp;

import _2.Diseño.Integracion.Client.DAOClient;
import _2.Diseño.Integracion.Client.imp.DAOClientImp;
import _2.Diseño.Integracion.Factory.FactoryIntegration;
import _2.Diseño.Integracion.Product.DAOProduct;
import _2.Diseño.Integracion.Product.imp.DAOProductImp;
import _2.Diseño.Integracion.Ticket.DAOTicket;
import _2.Diseño.Integracion.Ticket.imp.DAOTicketImp;


public class FactoryIntegrationImp extends FactoryIntegration {

	@Override
	public DAOProduct createDAOProduct() {
		return new DAOProductImp();
	}

	public DAOTicket createDAOTicket() {
		return new DAOTicketImp();
	}
	
	public DAOClient createDAOClient() {
		return new DAOClientImp();
	}
	
}