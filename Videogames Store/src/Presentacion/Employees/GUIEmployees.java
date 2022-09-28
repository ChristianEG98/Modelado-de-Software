package _2.Diseño.Presentacion.Employees;

import javax.swing.JFrame;

import _2.Diseño.Presentacion.Context;

import _2.Diseño.Presentacion.View.GUI;

public abstract class GUIEmployees extends JFrame implements GUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static GUIEmployees instance;
	
	public static GUIEmployees getInstance() {
		if(instance == null){
			instance = new GUIEmployeesImp();
		}
		return instance;
	}
	
	@Override
	public abstract void update(Context context);
}
