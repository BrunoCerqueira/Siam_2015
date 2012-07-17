package managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import service.PessoaService;
import entity.Medico;
import entity.Pessoa;

@ManagedBean
public class LogginMbean extends BaseBean {

	private static final String ADMINISTRADOR_USER = "administrador";
	private static final String ADMINISTRADOR_SENHA = "123";

	@EJB
	PessoaService pessoaService;

	private FacesContext context;

	private String user;
	private String senha;
	private Pessoa pessoa;

	public String conectar() {
		context = FacesContext.getCurrentInstance();
		String url = null;
		// se usu�rio n�o preencheou todos os campos

		if ((this.senha == null || this.senha == "")
				|| (this.user == null || this.senha == "")) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Aten��o",
					"Favor preencher todos campos de loggin! "));

		}

		else {

			// se usuario � o administrador do sistema

			if (this.user.equals(ADMINISTRADOR_USER)
					&& this.senha.equals(ADMINISTRADOR_SENHA)) {
				// TODO TELA DE ADMINISTRADOR
				context.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Aten��o",
						"TELA ADMINISTRADOR"));
				url = null;
			} else {
				pessoa = pessoaService.buscarPessoaPorLogin(user, senha);
				if (pessoa != null) {
					setId(pessoa.getId());
				}

				// se retorno da busca no banco � null -> usu�rio inexistente
				if (pessoa == null) {
					context.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Aten��o",
							"Usuario n�o encontrado! "));
				} else {

					// verifica se pessoa retornada do banco � instancia de um
					// m�dico e redireciona para p�gina inicial de m�dico

					if (pessoa instanceof Medico) {
						// TODO CHAMAR TELA PRINCIPAL DO M�DICO
						context.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "Aten��o",
								"TELA MEDICO "));

					}
					// caso contr�rio abre a tela de paciente (default)
					else {
						// TODO CHAMAR TELA PRINCIPAL DO PACIENTE
						context.addMessage(null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "Aten��o",
								"TELA PACIENTE "));
						url = "/pages/paginaPrincipalPaciente.xhtml";
					}

				}
			}
		}
		return url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}