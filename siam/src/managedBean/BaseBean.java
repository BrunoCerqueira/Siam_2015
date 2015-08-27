package managedBean;

import javax.faces.context.FacesContext;

public class BaseBean {
	public BaseBean() {
		
	}
	public FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	

}
