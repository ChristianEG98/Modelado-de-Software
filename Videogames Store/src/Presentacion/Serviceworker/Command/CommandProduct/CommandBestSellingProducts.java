package _2.Diseño.Presentacion.Serviceworker.Command.CommandProduct;

import java.util.ArrayList;

import _2.Diseño.Integracion.Query.TQuery;
import _2.Diseño.Negocio.Factory.FactorySA;
import _2.Diseño.Negocio.Product.imp.TProduct;
import _2.Diseño.Presentacion.Context;
import _2.Diseño.Presentacion.Events;
import _2.Diseño.Presentacion.Serviceworker.Command.Command;

public class CommandBestSellingProducts implements Command{

	@Override
	public Context execute(Object details) {
		ArrayList<TProduct> products = FactorySA.getInstance().
				createSAProduct().BestSellingProductSince_X_Date((TQuery)details);
		
		if(products != null){
			return new Context(Events.BEST_SELLING_PRODUCTS_OK, products);
		}
		else{
			return new Context(Events.BEST_SELLING_PRODUCTS_KO, products);
		}
	}

}
