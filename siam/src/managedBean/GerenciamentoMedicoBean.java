package managedBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import entity.Pessoa;

@ManagedBean
@ViewScoped
public class GerenciamentoMedicoBean extends BaseBean {
	
	@PostConstruct
	private void onPostConstruct(){
		
		
	}
	
	public void alertaBemVindo(){
		Pessoa pessoa = (Pessoa) getFacesContext().getExternalContext().getFlash().get("pessoa");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Bem vindo! "+pessoa.getNome(), null));
	}

}
