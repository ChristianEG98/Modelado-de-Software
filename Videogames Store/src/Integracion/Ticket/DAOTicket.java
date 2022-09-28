/**
 * 
 */
package _2.Diseño.Integracion.Ticket;

import _2.Diseño.Negocio.Ticket.imp.TTicket;
import java.util.ArrayList;


public interface DAOTicket {

	public int createTicket(TTicket tTicket);


	public TTicket searchTicket(int idTicket);


	public ArrayList<TTicket> listTickets();


	public int modifyTicket(TTicket tTicket);
	
}