/**
 * 
 */
package _2.Diseño.Negocio.Product.imp;


public enum VideogamesType {
	
	XBOX("XBOX"), NINTENDO ("NINTENDO"), PLAYSTATION("PLAYSTATION"), PC("PC");
	
	private String parameterName;

	private VideogamesType(String param) {
		parameterName = param;
	}

	public static VideogamesType parse(String param) {

		for (VideogamesType t : VideogamesType.values()) {
			if (t.parameterName.equals(param)) {
				return t;
			}
		}
		return null;
	}
	
	public String getString(){
		return this.parameterName;
	}
}