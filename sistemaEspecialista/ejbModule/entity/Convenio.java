package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "convenio", schema = "siam")
public class Convenio {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="idconvenio")
	private Long idConvenio;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="perc_cobertura")
	private int percentualCobertura;
	
	public Long getIdConvenio() {
		return idConvenio;
	}
	
	public void setIdConvenio(Long idConvenio) {
		this.idConvenio = idConvenio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPercentualCobertura() {
		return percentualCobertura;
	}
	public void setPercentualCobertura(int percentualCobertura) {
		this.percentualCobertura = percentualCobertura;
	}
	

}
