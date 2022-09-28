/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandClient;

import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandCreateClient implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object fact) {
		// begin-user-code
		// TODO Auto-generated method stub
		 int id = FactorySA.getInstance().createSAClient().createClient((TClient) fact);

	        if(id > 0)
	            return new Context(Events.CREATE_CLIENT_OK, id);
	        else
	            return new Context(Events.CREATE_CLIENT_KO, id);
	        // end-user-code
	}
}