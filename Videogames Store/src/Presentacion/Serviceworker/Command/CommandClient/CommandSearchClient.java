/**
 * 
 */
package _2.Dise�o.Presentacion.Serviceworker.Command.CommandClient;

import _2.Dise�o.Presentacion.Serviceworker.Command.Command;
import _2.Dise�o.Negocio.Client.imp.TClient;
import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandSearchClient implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object fact) {
		TClient tClient = FactorySA.getInstance().createSAClient().searchClient((int) fact);
		
		if(tClient != null) return new Context(Events.SEARCH_CLIENT_OK, tClient);
		else return new Context(Events.SEARCH_CLIENT_KO, tClient);
	}
}