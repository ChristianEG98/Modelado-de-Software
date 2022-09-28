package _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees;




import java.util.List;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Factory.FactorySA;

import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandListEmployees implements Command{

	@Override
	public Context execute(Object details) {
		// TODO Auto-generated method stub
List<TEmployees> employees = FactorySA.getInstance().createSAEmployees().listEmployees();
		
		if(employees != null) return new Context(Events.LIST_EMPLOYEESS_OK, employees);
		else return new Context(Events.LIST_EMPLOYEESS_KO, employees);
	}

}
