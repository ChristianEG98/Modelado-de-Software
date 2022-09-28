package _2.Diseño.Presentacion.Serviceworker.Command.CommandFair;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Negocio.Fair.imp.TFair;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandCreateFair implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Context execute(Object dato) {
		TFair tfair = (TFair) dato;

		int id = FactorySA.getInstance().createSAFair().createFair(tfair);
		
		if(id > 0){
			return new Context(Events.CREATE_FAIR_OK, id);
		}
		else{
			return new Context(Events.CREATE_FAIR_KO, id);
		}
	}
}