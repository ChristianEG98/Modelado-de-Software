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
public class CommandCloseTicket implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		TTicket currentTicket = (TTicket) details;

		int idNewTicket = FactorySA.getInstance().createSATicket().closeTicket(currentTicket);

		if (idNewTicket > 0 || idNewTicket == -4) {
			return new Context(Events.CLOSE_TICKET_OK, idNewTicket);

		} else {
			String error = "";

			if (idNewTicket == -8)
				error = "Error en la actualizaci�n de la DDBB de producto";
			else if (idNewTicket == -7)
				error = "No hay stock para alg�n producto";
			else if (idNewTicket == -6)
				error = "El producto no existe";
			else if (idNewTicket == -3)
				error = "No se ha podido crear la transaccion. ";
			else if (idNewTicket == -2)
				error = "Venta ya cerrada. ";
			else if (idNewTicket == -100)
				error = "Error, ha habido algun problema en la venta Actual";
			else
				error = "Error al cerrar la venta";
			
			return new Context(Events.CLOSE_TICKET_KO, error);
		}
	}
}