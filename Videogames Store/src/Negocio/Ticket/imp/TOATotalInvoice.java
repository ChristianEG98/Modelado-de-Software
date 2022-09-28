/**
 * 
 */
package _2.Diseño.Negocio.Ticket.imp;

import java.util.ArrayList;
import java.util.HashMap;

import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Negocio.Product.imp.TProduct;


public class TOATotalInvoice {
	
	private TTicket tTicket;

	
	private TClient tClient;
	
	
	private HashMap<Integer, LineaTicket> ticketline;
	private ArrayList <TProduct> tProducts;

	
	public TOATotalInvoice(TClient tclient, ArrayList<TProduct> productos, TTicket tticket) {
		this.tClient= tclient;
		this.tProducts = productos;
		this.tTicket = tticket;
		this.ticketline = tticket.getLineaTicket();
	}

	public TClient gettCLiente() {
		return tClient;
	}

	public void setClient(TClient tclient) {
		this.tClient = tclient;
	}

	public ArrayList<TProduct> getProducts() {
		return tProducts;
	}

	public void setProducts(ArrayList<TProduct> tProducts) {
		this.tProducts = tProducts;
	}

	public HashMap<Integer, LineaTicket> getTicketLine() {
		return ticketline;
	}

	public void setTicketLine(HashMap<Integer, LineaTicket> ticketline) {
		this.ticketline = ticketline;
	}

	public TTicket getTicket() {
		return tTicket;
	}

	public void setTicket(TTicket tTicket) {
		this.tTicket = tTicket;
	}
}