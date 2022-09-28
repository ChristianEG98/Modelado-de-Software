/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Negocio.Ticket.imp.TOATotalInvoice;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandGetInvoice implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		
		TOATotalInvoice invoice = FactorySA.getInstance().createSATicket().getTotalInvoice((int)details);
		
		if(invoice!=null) return new Context(Events.GET_INVOICE_OK, invoice);
		else return new Context(Events.GET_INVOICE_KO, invoice);
	}
}