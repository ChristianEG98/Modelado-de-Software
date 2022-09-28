/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class CommandSearchProduct implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute(Object fact)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details) {
		TProduct tProduct = FactorySA.getInstance().createSAProduct().searchProduct((int) details);
		
		if(tProduct != null) return new Context(Events.SEARCH_PRODUCT_OK, tProduct);
		else return new Context(Events.SEARCH_PRODUCT_KO, tProduct);
	}
}