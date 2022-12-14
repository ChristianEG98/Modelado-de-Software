package _2.Dise?o.Presentacion.Serviceworker.Command.CommandEmployees;

import _2.Dise?o.Negocio.Employees.TEmployees;
import _2.Dise?o.Negocio.Factory.FactorySA;
import _2.Dise?o.Presentacion.Context;
import _2.Dise?o.Presentacion.Events;
import _2.Dise?o.Presentacion.Serviceworker.Command.Command;

public class CommandSearchByDniEmployees  implements Command{

	
	@Override
	public Context execute(Object details) {
		// TODO Auto-generated method stub
		TEmployees tEmployees = FactorySA.getInstance().createSAEmployees().seacrhEmployeesByDni((String)details); 
		if (tEmployees!=null)
		{
			return new Context(Events.SEARCH_BY_DNI_EMPLOYEES_OK, tEmployees);
		}
		else{
			return new Context(Events.SEARCH_BY_DNI_EMPLOYEES_KO, tEmployees);
		}
		
	}

}
