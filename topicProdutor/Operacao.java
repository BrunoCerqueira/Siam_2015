package model;


import java.io.Serializable;
import java.math.BigDecimal;

import enumerator.EnumTipoOperacao;

public class Operacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 
	private Long idOperacao;
	
 
	private EnumTipoOperacao tipoOperacao;
	
	private Long quantidadeLotes;
	private BigDecimal valorLote;
	private String descricao;
	public EnumTipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}
	public void setTipoOperacao(EnumTipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	public Long getQuantidadeLotes() {
		return quantidadeLotes;
	}
	public void setQuantidadeLotes(Long quantidadeLotes) {
		this.quantidadeLotes = quantidadeLotes;
	}
	public BigDecimal getValorLote() {
		return valorLote;
	}
	public void setValorLote(BigDecimal valorLote) {
		this.valorLote = valorLote;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdOperacao() {
		return idOperacao;
	}
	public void setIdOperacao(Long idOperacao) {
		this.idOperacao = idOperacao;
	}
	
	
}
