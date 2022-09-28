/**
 * 
 */
package _2.Diseño.Presentacion.Company;

import javax.swing.JFrame;
import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Presentacion.Context;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public abstract class GUICompany extends JFrame implements GUI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static GUICompany instance;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public static GUICompany getInstance() {
		
		if(instance == null)
			instance= new GUICompanyImp();
		
		return instance; 
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public abstract void update(Context context);
}