/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandTicket;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandReturnTicket implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		int[] d = (int[]) details;
		int r = FactorySA.getInstance().createSATicket().returnProduct(d[0], d[1], d[2]);
		
		if(r > 0) return new Context(Events.RETURN_PRODUCT_OK, r);
		else return new Context(Events.RETURN_PRODUCT_KO, r);
	}
}