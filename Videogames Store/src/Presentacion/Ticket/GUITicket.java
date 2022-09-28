/**
 * 
 */
package _2.Diseño.Presentacion.Ticket;

import _2.Diseño.Presentacion.View.GUI;

import javax.swing.JFrame;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Negocio.Ticket.imp.TTicket;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public abstract class GUITicket  extends JFrame implements GUI { //faltara el extends jframe en los diagramas
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	* 
	* 
	*/
	private static final long serialVersionUID = 1L;

	private static GUITicket instance;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param context
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public static GUITicket getInstance() {
		if (instance ==null)
		{
			instance=new GUITicketImp();
			
		}
		return instance;
	}

	/** 
	* (non-Javadoc)
	* @see GUI#update(Context context)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public abstract void update(Context context);
	
	public abstract TTicket getCurrentTicket();

	public abstract void setTicket(TTicket tticket);
	
}