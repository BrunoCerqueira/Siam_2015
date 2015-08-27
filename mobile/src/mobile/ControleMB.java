package mobile;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@javax.faces.bean.ManagedBean
@ViewScoped
public class ControleMB {
	
	@PostConstruct
	public void onPostConstruct(){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("nome");
		if(nome != null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Bem vindo"+nome,null));
		}
	}
	
	private Boolean isUsuarioLogado = Boolean.FALSE;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void entrar(){
		if(nome != null && nome.equalsIgnoreCase("bruno")){
			isUsuarioLogado = Boolean.TRUE;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nome", nome);
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Bem vindo", "Login com sucesso!"));
		}else{
			
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro", "Verifique o nome de usuário!"));
		}
		
	}
	public Boolean getIsUsuarioLogado() {
		return isUsuarioLogado;
	}
	public void setIsUsuarioLogado(Boolean isUsuarioLogado) {
		this.isUsuarioLogado = isUsuarioLogado;
	}
	

}
