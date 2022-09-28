/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket;

import java.util.ArrayList;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Negocio.Ticket.imp.TTicket;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandListTickets implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		
		ArrayList<TTicket> tickets = FactorySA.getInstance().createSATicket().listTickets();
		
		if(tickets!=null) return new Context(Events.LIST_TICKET_OK, tickets);
		else return new Context(Events.LIST_TICKET_KO, tickets);
	}
}