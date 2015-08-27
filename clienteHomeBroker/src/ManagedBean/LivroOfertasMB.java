package ManagedBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Operacao;
import facade.OfertaOperacaoService;

@ManagedBean
@ViewScoped
public class LivroOfertasMB {
	
	@EJB
	private OfertaOperacaoService ofertaOperacaoService;
	private List<Operacao> listaOperacoes;
	
	@PostConstruct
	public void onPostConstruct(){
		setListaOperacoes(ofertaOperacaoService.recuperarOperacoes());
	}

	public List<Operacao> getListaOperacoes() {
		return listaOperacoes;
	}

	public void atualizarListaOperacoes(){
		setListaOperacoes(ofertaOperacaoService.recuperarOperacoes());
	}
	public void setListaOperacoes(List<Operacao> listaOperacoes) {
		this.listaOperacoes = listaOperacoes;
	}

	
	
	
	

}
