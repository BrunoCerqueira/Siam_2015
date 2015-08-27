package managedBean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import messageDriven.ProdutorAcao;
import model.Operacao;
import enumerator.EnumTipoOperacao;
import facade.OfertaOperacaoService;

@ManagedBean
@ViewScoped
public class GeracaoOfertasMB {
	
	private Operacao operacao;
	
	public GeracaoOfertasMB(){
		operacao = new Operacao();
	}
	private List<Operacao> listOperacao;
	

	@EJB
	ProdutorAcao produtorAcao;
	
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

	
	
	public List<EnumTipoOperacao> tiposOperacao(){
		return Arrays.asList(EnumTipoOperacao.values());
	}
	public void gerarOfertas(){
		setListOperacao(produtorAcao.adicionarOferta(operacao));
		setListaOperacoes(ofertaOperacaoService.recuperarOperacoes());
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public List<Operacao> getListOperacao() {
		return listOperacao;
	}

	public void setListOperacao(List<Operacao> listOperacao) {
		this.listOperacao = listOperacao;
	}
	
}
