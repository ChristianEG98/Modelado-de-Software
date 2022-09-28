/**
 * 
 */
package _2.Diseño.Presentacion.Fair;

import javax.swing.JFrame;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.View.GUI;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public abstract class GUIFair extends JFrame implements GUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static GUIFair instance;
	
	public static GUIFair getInstance() {
		if(instance == null){
			instance = new GUIFairImp();
		}
		return instance;
	}
	
	@Override
	public abstract void update(Context context);
}