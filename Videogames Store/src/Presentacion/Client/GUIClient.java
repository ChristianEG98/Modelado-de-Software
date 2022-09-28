/**
 * 
 */
package _2.Diseño.Presentacion.Client;

import javax.swing.JFrame;
import _2.Diseño.Presentacion.View.GUI;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Producto.GUIProductImp;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class GUIClient extends JFrame implements GUI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static GUIClient instance;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static GUIClient getInstance() {
		if (instance ==null)
		{
			instance=new GUIClientImp();
		}
		return instance;
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public abstract void update(Context context);
}