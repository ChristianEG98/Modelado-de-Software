package _2.Dise�o.Presentacion.Serviceworker.Command.CommandFair;

import java.util.List;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Fair.imp.TFair;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandListFairs implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Context execute(Object dato) {
		List<TFair> fairs = FactorySA.getInstance().createSAFair().listFairs();
		
		if(fairs != null){
			return new Context(Events.LIST_FAIRS_OK, fairs);
		}
		else{
			return new Context(Events.LIST_FAIRS_KO, fairs);
		}
	}
}