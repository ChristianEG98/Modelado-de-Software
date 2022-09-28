/**
 * 
 */
package _2.Diseño.Negocio.Fair;

import java.util.List;

import _2.Diseño.Negocio.Fair.imp.TAssist;
import _2.Diseño.Negocio.Fair.imp.TFair;


public interface SAFair {
	
	public int createFair(TFair tFair);

	
	public int addEmployeesFair(TAssist tAssist);

	
	public int deleteFair(int idFair);

	
	public TFair searchFair(int tFair);

	
	public int deleteEmployeesFair(TAssist tAssist);

	
	public List<TFair> listFairs();

	
	public int modifyFair(TFair tFair);

	
	public List<TAssist> showEmployeesFair(int idFair);
}