package managedBean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.PessoaService;
import entity.Medico;
import entity.Pessoa;

@ManagedBean
public class LogginMbean  extends BaseBean {

	private static final String ADMINISTRADOR_USER = "administrador";
	private static final String ADMINISTRADOR_SENHA = "123";

	InitialContext contexto;
	
	@EJB
	PessoaService pessoaService;
	
	private Pessoa pessoa;

	private InitialContext initialContext;

	private String user;
	private String senha;
	

	public String conectar()throws NamingException {
		/*
		 * utilizando LOOKUP COMO EXEMPLO NESTE CASO ,AO INVÉS DA NOTAÇÂO EJB PARA INJEÇÂO DE DEPENDENCIA
		 * OBS: O endereco de LOOKUP PARA O SERVIÇO DO EJB SEGUE O PADRAO: CONTEXTO/CAMINHO BEAN ! CAMINHO INTERFACE REMOTA
		*/
		initialContext = new InitialContext();
//		pessoaService = (PessoaService) initialContext.lookup("java:global/siamEAR/sistemaEspecialista/PessoaBean!service.PessoaService");
		FacesContext context = FacesContext.getCurrentInstance();
		String url = null;
		// se usu�rio n�o preencheou todos os campos

		if ((this.senha == null || this.senha == "")
				|| (this.user == null || this.senha == "")) {
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Atencão",
					"Favor preencher todos campos de loggin! "));

		}

		else {

			// se usuario � o administrador do sistema

			if (this.user.equals(ADMINISTRADOR_USER)
					&& this.senha.equals(ADMINISTRADOR_SENHA)) {
				
				url = "/pages/administrarPaciente.xhtml";
			} else {
				setPessoa(pessoaService.buscarPessoaPorLogin(user, senha));
				FacesContext.getCurrentInstance().getExternalContext().getFlash().put("pessoa", getPessoa());

				// se retorno da busca no banco � null -> usu�rio inexistente
				if (getPessoa() == null) {
					context.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "Atenção",
							"Usuario não encontrado! "));
				} else {

					// verifica se pessoa retornada do banco � instancia de um
					// m�dico e redireciona para p�gina inicial de m�dico

					if (getPessoa() instanceof Medico) {
						url = "/pages/paginaPrincipalMedico.xhtml";

					}
					// caso contr�rio abre a tela de paciente (default)
					else {
						// TODO CHAMAR TELA PRINCIPAL DO PACIENTE
						
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
