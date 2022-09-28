/**
 * 
 */
package _2.Dise�o.Integracion.Factory.imp;

import _2.Dise�o.Integracion.Client.DAOClient;
import _2.Dise�o.Integracion.Client.imp.DAOClientImp;
import _2.Dise�o.Integracion.Factory.FactoryIntegration;
import _2.Dise�o.Integracion.Product.DAOProduct;
import _2.Dise�o.Integracion.Product.imp.DAOProductImp;
import _2.Dise�o.Integracion.Ticket.DAOTicket;
import _2.Dise�o.Integracion.Ticket.imp.DAOTicketImp;


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