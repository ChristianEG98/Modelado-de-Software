/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandDeleteProduct implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		int id = FactorySA.getInstance().createSAProduct().deleteProduct((int) details);
		
		if(id > 0) return new Context(Events.DELETE_PRODUCT_OK, id);
		else return new Context(Events.DELETE_PRODUCT_KO, id);
	}
	
}