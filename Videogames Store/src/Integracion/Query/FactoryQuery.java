package _2.Diseño.Integracion.Query;


public abstract class FactoryQuery {

	private static FactoryQuery instance;


	public static FactoryQuery getInstance() {
		// begin-user-code
		// TODO Auto-generated method stub
		// end-user-code
		if(instance == null){
			instance = new FactoryQueryImp();
		}
		return instance;
	}


	public abstract BestSellingProductSince_X_Date bestSellingProductSince_X_Date();
	

	public abstract CustomersWhoHaveMadeMoreThan_X_Purchases customersWhoHaveMadeMoreThan_X_Purchases();
	
}