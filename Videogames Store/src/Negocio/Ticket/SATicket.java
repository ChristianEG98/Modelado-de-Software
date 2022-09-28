/**
 * 
 */
package _2.Diseño.Negocio.Ticket;

import _2.Diseño.Negocio.Ticket.imp.TOATotalInvoice;
import _2.Diseño.Negocio.Ticket.imp.TTicket;
import java.util.ArrayList;


public interface SATicket {
	
	public TTicket createTicket(int idCliente); 

	
	public TTicket searchTicket(int idTicket);

	
	public int closeTicket(TTicket tTicket);

	
	public ArrayList<TTicket> listTickets();

	
	public TTicket modifyTicket(int idProducto, int numProductos);

	
	public int returnProduct(int idTicket, int idProduct, int numProductos);

	
	public TOATotalInvoice getTotalInvoice(int idTicket);
}