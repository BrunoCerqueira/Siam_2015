package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "paciente", schema = "siam")
public class Paciente extends Pessoa {
	
	@Column(name="nome_pai")
	private String nomePai;
	
	@Column(name="nome_mae")
	private String nomeMae;
	
	@Column(name="altura")
	private Integer altura;

	@ManyToOne
	@JoinColumn(name="idconvenio")
	private Convenio convenio;
	
	@OneToOne
	@JoinColumn(name="fk_fator_risc")
	private HistoricoFatoresRisco historicoFatoresRisco;

	
	public Convenio getConvenio() {
		return convenio;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public HistoricoFatoresRisco getHistoricoFatoresRisco() {
		return historicoFatoresRisco;
	}

	public void setHistoricoFatoresRisco(
			HistoricoFatoresRisco historicoFatoresRisco) {
		this.historicoFatoresRisco = historicoFatoresRisco;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	
}
