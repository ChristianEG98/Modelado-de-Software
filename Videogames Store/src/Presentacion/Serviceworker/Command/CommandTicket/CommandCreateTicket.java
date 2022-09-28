/**
 * 
 */
package _2.Dise�o.Presentacion.Serviceworker.Command.CommandTicket;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Ticket.imp.TTicket;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandCreateTicket implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		int idCliente = (int) details;
		TTicket tticket = FactorySA.getInstance().createSATicket().createTicket(idCliente);
		
		if(tticket!=null) return new Context(Events.CREATE_TICKET_OK, tticket);
		else return new Context(Events.CREATE_TICKET_KO, tticket);
	}
}