/**
 * 
 */
package _2.Diseño.Presentacion.Serviceworker.Command;

import _2.Diseño.Presentacion.Context;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public interface Command {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param fact
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Context execute(Object details);
}