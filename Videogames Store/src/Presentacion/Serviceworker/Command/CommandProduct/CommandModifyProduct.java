/**
 * 
 */
package _2.Dise�o.Presentacion.Serviceworker.Command.CommandProduct;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Product.imp.TProduct;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandModifyProduct implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		TProduct tProduct = (TProduct) details;
		int id = FactorySA.getInstance().createSAProduct().modifyProduct(tProduct);
		
		if(id > 0) return new Context(Events.MODIFY_PRODUCT_OK, id);
		else return new Context(Events.MODIFY_PRODUCT_KO, id);
	}
}