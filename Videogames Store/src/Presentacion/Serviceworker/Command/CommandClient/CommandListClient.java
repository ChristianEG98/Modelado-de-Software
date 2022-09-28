/**
 * 
 */
package _2.Dise�o.Presentacion.Serviceworker.Command.CommandClient;

import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

import java.util.ArrayList;

import _2.Dise�o.Negocio.Client.imp.TClient;
import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandListClient implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object fact) {
		ArrayList<TClient> clients = FactorySA.getInstance().createSAClient().listClients();
		
		if(clients != null) return new Context(Events.LIST_CLIENTS_OK, clients);
		else return new Context(Events.LIST_CLIENTS_KO, clients);

	}
}