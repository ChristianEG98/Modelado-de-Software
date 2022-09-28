/**
 * 
 */
package _2.Diseño.Presentacion;


public class Context {
	
	private Object details;
	
	private int event;
	
	
	
	
	public Context(int event, Object details)
	{
		this.details=details;
		this.event=event;
	}

	
	public Object getDetails() {
	

		return this.details;
		
	}


	public void setDetails(Object details) {
	
		this.details=details;
	}


	public int getEvent() {
		
		return this.event;
	}

	
	public void setEvent(int event) {
		
		this.event=event;
	}

	
}