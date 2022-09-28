package _2.Dise�o.Presentacion.Serviceworker.Command.CommandProduct;

import _2.Dise�o.Negocio.Factory.FactorySA;
import _2.Dise�o.Negocio.Product.imp.TProduct;
import _2.Dise�o.Presentacion.Context;
import _2.Dise�o.Presentacion.Events;
import _2.Dise�o.Presentacion.Serviceworker.Command.Command;

public class CommandSearchModifyProduct implements Command{

	@Override
	public Context execute(Object details) {
		TProduct tProduct = null;
		tProduct = FactorySA.getInstance().createSAProduct().searchProduct((int) details);
		
		if(tProduct != null) return new Context(Events.SEARCH_MODIFY_PRODUCT_OK, tProduct);
		else return new Context(Events.SEARCH_MODIFY_PRODUCT_KO, tProduct);
	}

}
