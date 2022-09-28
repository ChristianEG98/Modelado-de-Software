/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandClient;

import _2.Diseño.Presentacion.Serviceworker.Command.Command;
import _2.Diseño.Negocio.Factory.FactorySA;

import java.util.ArrayList;

import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Negocio.Client.imp.TClient;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandCustomersWhoHaveMadeMoreThan_X_Purchases implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object fact) {
		ArrayList<TClient> clients = FactorySA.getInstance().createSAClient().CustomersWhoHaveMadeMoreThan_X_Purchases((TQuery) fact);
		
		if(clients != null){
			return new Context(Events.CUSTOMERS_MORE_X_PURCHASES_OK, clients);
		}
		else{
			return new Context(Events.CUSTOMERS_MORE_X_PURCHASES_KO, clients);
		}
	}
}