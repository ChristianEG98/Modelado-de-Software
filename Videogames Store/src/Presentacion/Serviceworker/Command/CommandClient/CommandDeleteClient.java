/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandClient;

import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandDeleteClient implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object fact) {
		int id = FactorySA.getInstance().createSAClient().deleteClient((int) fact);
		
		if(id > 0) return new Context(Events.DELETE_CLIENT_OK, id);
		else return new Context(Events.DELETE_CLIENT_KO, id);
	}
}