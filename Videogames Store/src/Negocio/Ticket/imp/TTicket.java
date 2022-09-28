/**
 * 
 */
package _2.Diseño.Negocio.Ticket.imp;


import java.util.Set;
import java.util.Date;
import java.util.HashMap;


public class TTicket {
	
	private boolean active;
	
	private Integer idTicket;
	
	private Date date;
	
	private float price;
	
	private String cif;
	
	private Integer idCliente;
	
	private HashMap<Integer, LineaTicket> lineaTicket;

	
	public TTicket(int idTicket, int idCliente, String cif, Date fecha, float precio, HashMap<Integer, LineaTicket> lineasTickets,
			boolean activo) {
		this.idTicket= idTicket;
		this.idCliente = idCliente;
		this.cif = cif;
		this.date = fecha;
		this.price = precio;
		this.lineaTicket = lineasTickets;
		this.active = activo;
	}

	public TTicket(int idClient){
		this.idCliente = idClient;
		this.lineaTicket = new HashMap<>();
		this.active = true;
	}
	
	
	public int getIdTicket() {
		return this.idTicket;
	}

	
	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	
	public Date getDate() {
		return this.date;
	}

	
	public void setDate(Date fecha) {
		this.date = fecha;
	}

	
	public float getPrice() {
		return this.price;
	}

	
	public void setPrice(float precio) {
		this.price = precio;
	}

	
	public String getCif() {
		return this.cif;
	}

	
	public void setCif(String cif) {
		this.cif = cif;
	}

	
	public boolean getActive() {
		return this.active;
	}

	
	public void setActive(boolean b) {
		this.active = b;
	}

	
	public int getIdCliente() {
		return this.idCliente;
	}

	
	public HashMap<Integer, LineaTicket> getLineaTicket() {
		return this.lineaTicket;
	}
	
	public void setLineaTicket(HashMap<Integer, LineaTicket> lineaTickets) {
		this.lineaTicket = lineaTickets;
	}
}