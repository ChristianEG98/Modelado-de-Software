package _2.Diseño.Presentacion.Serviceworker.Command.CommandFair;

import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Negocio.Fair.imp.TFair;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandModifySearchFair implements Command{
	
	public Context execute(Object dato) {
		TFair tFair = null;
		tFair = FactorySA.getInstance().createSAFair().searchFair((int)dato);
	
		if(tFair != null){
			return new Context(Events.SEARCH_MODIFY_FAIR_OK, tFair);
		}
		else{
		return new Context(Events.SEARCH_MODIFY_FAIR_KO, tFair);
		}
	}
}


