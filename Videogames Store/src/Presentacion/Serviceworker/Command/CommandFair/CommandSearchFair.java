package _2.Dise�o.Presentacion.Serviceworker.Command.CommandFair;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Fair.imp.TFair;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandSearchFair implements Command{

	public Context execute(Object dato) {
		TFair tFair = FactorySA.getInstance().createSAFair().searchFair((int)dato);

		if(tFair != null){
			return new Context(Events.SEARCH_FAIR_OK, tFair);
		}
		else{
			return new Context(Events.SEARCH_FAIR_KO, tFair);
		}
	}

}
