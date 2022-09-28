package _2.Diseño.Integracion.Query;


public class FactoryQueryImp extends FactoryQuery {

	@Override
	public BestSellingProductSince_X_Date bestSellingProductSince_X_Date() {
		// TODO Auto-generated method stub
		return new BestSellingProductSince_X_Date();
	}

	@Override
	public CustomersWhoHaveMadeMoreThan_X_Purchases customersWhoHaveMadeMoreThan_X_Purchases() {
		// TODO Auto-generated method stub
		return new CustomersWhoHaveMadeMoreThan_X_Purchases();
	}
}