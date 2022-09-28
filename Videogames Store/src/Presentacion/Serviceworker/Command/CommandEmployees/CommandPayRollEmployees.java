package _2.Diseño.Presentacion.Serviceworker.Command.CommandEmployees;

import _2.Diseño.Negocio.Employees.TEmployees;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandPayRollEmployees implements Command {

	@Override
	public Context execute(Object details) {
		TEmployees tEmployees= FactorySA.getInstance().createSAEmployees().searchEmployees((int) details);
		
		if(tEmployees != null) return new Context(Events.PAYROLL_EMPLOYEE_OK, tEmployees);
		else return new Context(Events.PAYROLL_EMPLOYEE_KO, tEmployees);
	}

}
