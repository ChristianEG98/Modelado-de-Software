/**
 * 
 */
package _2.Diseño.Negocio.Company;

import _2.Diseño.Negocio.Company.imp.TCompany;

import java.util.List;

import _2.Diseño.Negocio.Company.imp.Company;


public interface SACompany {
	
	public int createCompany(TCompany company);

	
	public int deleteCompany(int idCompany);

	
	public int modifyCompany(TCompany company);

	
	public TCompany searchCompany(int idCompany);

	
	public List<TCompany> listCompanies();

	
	public float calculatePayroll(int idCompany);
}